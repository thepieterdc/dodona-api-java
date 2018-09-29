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

/**
 * A course on Dodona.
 */
public interface Course extends Resource {
	/**
	 * Gets the color of the course.
	 *
	 * @return the color
	 */
	@Nonnull
	CourseColor getColor();
	
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
