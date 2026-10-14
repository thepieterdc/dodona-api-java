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
import io.github.thepieterdc.dodona.resources.Course;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * A course on Dodona.
 *
 * @param id the id
 * @param name the name
 * @param seriesUrl url to fetch series
 * @param teacher the teacher
 * @param url the url
 * @param year the academic year
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CourseImpl(
	@JsonProperty("id") long id,
	@JsonProperty("name") String name,
	@JsonProperty("series") String seriesUrl,
	@JsonProperty("teacher") @Nullable String teacher,
	@JsonProperty("url") String url,
	@JsonProperty("year") String year
) implements Course {
	@Override
	public int compareTo(final Course o) {
		final int compareYear = this.year.compareTo(o.getYear());
		return compareYear != 0 ? compareYear : this.name.compareToIgnoreCase(o.getName());
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		return o instanceof Course other && this.id == other.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
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
	public String getSeriesUrl() {
		return this.seriesUrl;
	}

	@Override
	@Nonnull
	public Optional<String> getTeacher() {
		return Optional.ofNullable(this.teacher);
	}

	@Override
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}

	@Override
	@Nonnull
	public String getYear() {
		return this.year;
	}

	@Override
	public String toString() {
		return String.format("Course{id=%d, name=%s}", this.id, this.name);
	}
}
