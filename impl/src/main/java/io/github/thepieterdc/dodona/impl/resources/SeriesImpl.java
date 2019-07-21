/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources;

import io.github.thepieterdc.dodona.resources.Series;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * A series on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class SeriesImpl implements Series {
	@Nullable
	private final ZonedDateTime deadline;
	
	private final String description;
	private final String exercisesUrl;
	private final long id;
	private final String name;
	private final int order;
	private final String url;
	
	/**
	 * SeriesImpl constructor.
	 *
	 * @param deadline     the optional deadline
	 * @param description  the description
	 * @param exercisesUrl url to fetch exercises
	 * @param id           the id
	 * @param name         the name
	 * @param order        the order
	 * @param url          the url
	 */
	public SeriesImpl(@Nullable @JsonProperty("deadline") final ZonedDateTime deadline,
	                  @JsonProperty("description") final String description,
	                  @JsonProperty("exercises") final String exercisesUrl,
	                  @JsonProperty("id") final long id,
	                  @JsonProperty("name") final String name,
	                  @JsonProperty("order") final int order,
	                  @JsonProperty("url") final String url) {
		this.deadline = deadline;
		this.description = description;
		this.exercisesUrl = exercisesUrl;
		this.id = id;
		this.name = name;
		this.order = order;
		this.url = url;
	}
	
	@Override
	public int compareTo(final Series o) {
		return this.order - o.getOrder();
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
	public String toString() {
		return String.format("Series{id=%d, name=%s}", this.id, this.name);
	}
}
