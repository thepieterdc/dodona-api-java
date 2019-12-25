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
import io.github.thepieterdc.dodona.data.CourseColor;
import io.github.thepieterdc.dodona.resources.Course;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * A course on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CourseImpl implements Course {
	private final CourseColor color;
	private final long id;
	private final String name;
	private final String seriesUrl;
	
	@Nullable
	private final String teacher;
	
	private final String url;
	private final String year;
	
	/**
	 * CourseImpl constructor.
	 *
	 * @param color     the color of the course
	 * @param id        the id
	 * @param name      the name
	 * @param seriesUrl url to fetch series
	 * @param teacher   the teacher
	 * @param url       the url
	 * @param year      the academic year
	 */
	public CourseImpl(@JsonProperty("color") final CourseColor color,
	                  @JsonProperty("id") final long id,
	                  @JsonProperty("name") final String name,
	                  @JsonProperty("series") final String seriesUrl,
	                  @Nullable @JsonProperty("teacher") final String teacher,
	                  @JsonProperty("url") final String url,
	                  @JsonProperty("year") final String year) {
		this.color = color;
		this.id = id;
		this.name = name;
		this.seriesUrl = seriesUrl;
		this.teacher = teacher;
		this.url = url;
		this.year = year;
	}
	
	@Override
	public int compareTo(Course o) {
		final int compareYear = this.year.compareTo(o.getYear());
		return compareYear != 0 ? compareYear : this.name.compareToIgnoreCase(o.getName());
	}
	
	@Override
	@Nonnull
	public CourseColor getColor() {
		return this.color;
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
