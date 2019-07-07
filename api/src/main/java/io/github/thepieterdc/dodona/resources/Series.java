/*
 * Copyright (c) 2019. All rights reserved.
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

/**
 * A series on Dodona.
 */
public interface Series extends Comparable<Series>, Resource {
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
