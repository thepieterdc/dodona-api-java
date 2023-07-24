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
import java.util.Objects;

/**
 * A programming language on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ProgrammingLanguageImpl implements ProgrammingLanguage {
	private final String extension;
	private final long id;
	private final String name;
	
	/**
	 * ProgrammingLanguageImpl constructor.
	 *
	 * @param extension the file extension
	 * @param id        the id
	 * @param name      the name
	 */
	public ProgrammingLanguageImpl(@JsonProperty("extension") final String extension,
	                               @JsonProperty("id") final long id,
	                               @JsonProperty("name") final String name) {
		this.extension = extension;
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(final ProgrammingLanguage o) {
		return this.name.compareToIgnoreCase(o.getName());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof ProgrammingLanguage) {
			return this.id == ((ProgrammingLanguage) o).getId();
		}
		return false;
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
	public int hashCode() {
		return Objects.hash(this.id);
	}
	
	@Override
	public String toString() {
		return String.format("ProgrammingLanguage{id=%d, name=%s}", this.id, this.name);
	}
}
