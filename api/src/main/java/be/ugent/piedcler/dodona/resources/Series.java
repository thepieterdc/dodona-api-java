/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.resources;

import javax.annotation.Nonnull;

/**
 * A series on Dodona.
 */
public interface Series extends Resource {
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
}
