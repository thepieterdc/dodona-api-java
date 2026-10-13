/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.resources.ProgrammingLanguage;

import javax.annotation.Nonnull;


/**
 * A programming language on Dodona.
 *
 * @param extension the file extension
 * @param id the id
 * @param name the name
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProgrammingLanguageImpl(
	@JsonProperty("extension") String extension,
	@JsonProperty("id") long id,
	@JsonProperty("name") String name
) implements ProgrammingLanguage {
	@Override
	public int compareTo(final ProgrammingLanguage o) {
		return this.name.compareToIgnoreCase(o.getName());
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		return o instanceof ProgrammingLanguage other && this.id == other.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}

	@Override
	@Nonnull
	public String getExtension() {
		return this.extension;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	@Nonnull
	public String getName() {
		return this.name;
	}

	@Override
	@Nonnull
	public String getUrl() {
		return String.format("https://dodona.be/en/programming_languages/%d.json", this.id);
	}

	@Override
	public String toString() {
		return String.format("ProgrammingLanguage{id=%d, name=%s}", this.id, this.name);
	}
}
