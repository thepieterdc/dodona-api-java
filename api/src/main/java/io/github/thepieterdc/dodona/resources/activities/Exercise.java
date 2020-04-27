/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources.activities;

import io.github.thepieterdc.dodona.data.ActivityType;
import io.github.thepieterdc.dodona.data.ExerciseStatus;
import io.github.thepieterdc.dodona.resources.ProgrammingLanguage;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * A exercise on Dodona.
 */
public interface Exercise extends Comparable<Exercise>, Activity {
	/**
	 * Gets the boilerplate code.
	 *
	 * @return the boilerplate code
	 */
	@Nonnull
	Optional<String> getBoilerplate();
	
	/**
	 * Gets the programming language of this exercise. This is optional since
	 * not every exercise contains this property.
	 *
	 * @return the programming language
	 */
	@Nonnull
	Optional<ProgrammingLanguage> getProgrammingLanguage();
	
	/**
	 * Gets the status of this exercise.
	 *
	 * @return the status
	 */
	@Nonnull
	ExerciseStatus getStatus();
	
	@Nonnull
	@Override
	default ActivityType getType() {
		return ActivityType.EXERCISE;
	}
	
	/**
	 * Gets whether this exercise has been solved correctly in the past.
	 *
	 * @return true if at least one of the user's submissions to this exercise
	 * is correct
	 */
	boolean hasCorrectSolution();
	
	/**
	 * Gets whether this exercise has at least one solution.
	 *
	 * @return true if the exercise has at least one solution
	 */
	boolean hasSolution();
	
	/**
	 * Gets whether the last submission to this exercise is the best one (e.g.
	 * correct is better than incorrect. If there are no correct submissions,
	 * this is true.
	 *
	 * @return true if the last submission is the best one, or if there are no
	 * correct submissions yet
	 */
	boolean lastSolutionIsBest();
}
