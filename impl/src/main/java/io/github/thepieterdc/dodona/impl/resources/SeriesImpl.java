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
import io.github.thepieterdc.dodona.data.SeriesVisibility;
import io.github.thepieterdc.dodona.resources.Series;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * A series on Dodona.
 *
 * @param courseUrl url to the course
 * @param deadline the optional deadline
 * @param description the description
 * @param exercisesUrl url to fetch exercises
 * @param id the id
 * @param name the name
 * @param order the order
 * @param url the url
 * @param visibility the series visibility
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesImpl(
	@JsonProperty("course") String courseUrl,
	@JsonProperty("deadline") @Nullable ZonedDateTime deadline,
	@JsonProperty("description") String description,
	@JsonProperty("exercises") String exercisesUrl,
	@JsonProperty("id") long id,
	@JsonProperty("name") String name,
	@JsonProperty("order") int order,
	@JsonProperty("url") String url,
	@JsonProperty("visibility") SeriesVisibility visibility
) implements Series {
	@Override
	public int compareTo(final Series o) {
		return this.order - o.getOrder();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		return o instanceof Series other && this.id == other.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}

	@Override
	@Nonnull
	public String getCourseUrl() {
		return this.courseUrl;
	}

	@Override
	@Nonnull
	public Optional<ZonedDateTime> getDeadline() {
		return Optional.ofNullable(this.deadline);
	}

	@Override
	@Nonnull
	public Optional<String> getDescription() {
		return Optional.of(this.description).filter(s -> !s.isEmpty());
	}

	@Override
	@Nonnull
	public String getExercisesUrl() {
		return this.exercisesUrl;
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
	public int getOrder() {
		return this.order;
	}

	@Override
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}

	@Override
	@Nonnull
	public SeriesVisibility getVisibility() {
		return this.visibility;
	}

	@Override
	public String toString() {
		return String.format("Series{id=%d, name=%s}", this.id, this.name);
	}
}
