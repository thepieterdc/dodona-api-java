/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.resources;

import be.ugent.piedcler.dodona.data.CourseColor;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A course on Dodona.
 */
public interface Course extends Comparable<Course>, Resource {
	/**
	 * Gets the color of the course.
	 *
	 * @return the color
	 */
	@Nonnull
	CourseColor getColor();
	
	/**
	 * Parses the id of a course from the url.
	 *
	 * @param url the url to the course
	 * @return the course id
	 */
	@Nonnull
	static Optional<Long> getId(final String url) {
		final Pattern urlPattern = Pattern.compile("courses/([0-9]+)");
		return Optional.of(urlPattern.matcher(url))
			.filter(Matcher::find)
			.map(matcher -> matcher.group(1))
			.map(Long::parseLong);
	}
	
	/**
	 * Gets the name of the course.
	 *
	 * @return the name of the course
	 */
	@Nonnull
	String getName();
	
	/**
	 * Gets the url to fetch the series of the course.
	 *
	 * @return the series url
	 */
	@Nonnull
	String getSeriesUrl();
	
	/**
	 * Gets the name of the teacher of the course.
	 *
	 * @return the name of the teacher
	 */
	@Nonnull
	Optional<String> getTeacher();
	
	/**
	 * Gets the academic year this course is taught in.
	 *
	 * @return the academic year
	 */
	@Nonnull
	String getYear();
}
