/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.resources;

import be.ugent.piedcler.dodona.resources.Series;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;

/**
 * A series on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class SeriesImpl implements Series {
	private final String exercisesUrl;
	private final long id;
	private final String name;
	private final String url;
	
	/**
	 * SeriesImpl constructor.
	 *
	 * @param exercisesUrl url to fetch exercises
	 * @param id        the id
	 * @param name      the name
	 * @param url       the url
	 */
	public SeriesImpl(@JsonProperty("exercises") final String exercisesUrl,
	                  @JsonProperty("id") final long id,
	                  @JsonProperty("name") final String name,
	                  @JsonProperty("url") final String url) {
		this.exercisesUrl = exercisesUrl;
		this.id = id;
		this.name = name;
		this.url = url;
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
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}
	
	@Override
	public String toString() {
		return String.format("Series{id=%d, name=%s}", this.id, this.name);
	}
}
