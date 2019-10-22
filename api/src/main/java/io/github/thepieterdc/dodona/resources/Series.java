/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources;

import javax.annotation.Nonnull;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A series on Dodona.
 */
public interface Series extends Comparable<Series>, Resource {
	/**
	 * Gets the url to the course this series belongs to.
	 *
	 * @return the course url
	 */
	@Nonnull
	String getCourseUrl();
	
	/**
	 * Gets the deadline for this series, if any.
	 *
	 * @return the deadline
	 */
	@Nonnull
	Optional<ZonedDateTime> getDeadline();
	
	/**
	 * Gets the description for this series, if the description is non-empty.
	 *
	 * @return the description
	 */
	@Nonnull
	Optional<String> getDescription();
	
	/**
	 * Gets the url to fetch the exercises of the series.
	 *
	 * @return the exercises url
	 */
	@Nonnull
	String getExercisesUrl();
	
	/**
	 * Parses the id of a series from the url.
	 *
	 * @param url the url to the series
	 * @return the course id
	 */
	@Nonnull
	static Optional<Long> getId(final String url) {
		final Pattern urlPattern = Pattern.compile(
			"https?://.*/series/(\\d+)",
			Pattern.CASE_INSENSITIVE
		);
		
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
	 * Gets the order in which the series should be sorted.
	 *
	 * @return the sorting order
	 */
	int getOrder();
}
