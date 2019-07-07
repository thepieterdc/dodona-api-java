/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Manager for series.
 */
public interface SeriesManager extends ResourceManager<Series> {
	/**
	 * Gets all series of a given course, sorted by order.
	 *
	 * @param course the course
	 * @return all series in the course
	 */
	@Nonnull
	List<Series> getAll(Course course);
}
