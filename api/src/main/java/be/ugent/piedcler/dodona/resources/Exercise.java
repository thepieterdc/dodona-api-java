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
import java.util.Optional;

/**
 * A exercise on Dodona.
 */
public interface Exercise extends Resource {
	/**
	 * Gets the boilerplate code.
	 *
	 * @return the boilerplate code
	 */
	@Nonnull
	Optional<String> getBoilerplate();
	
	/**
	 * Gets the name of the course.
	 *
	 * @return the name of the course
	 */
	@Nonnull
	String getName();
	
	/**
	 * Gets the programming language of this exercise. This is optional since
	 * not every exercise contains this property.
	 *
	 * @return the programming language
	 */
	@Nonnull
	Optional<String> getProgrammingLanguage();
	
	/**
	 * Gets whether this exercise has been solved correctly in the past.
	 *
	 * @return true if at least one of the user's submissions to this exercise
	 * is correct
	 */
	boolean hasCorrectSolution();
	
	/**
	 * Gets whether the last submission to this exercise was correct.
	 *
	 * @return true if the last submission is correctly evaluated
	 */
	boolean isLastSolutionCorrect();
}
