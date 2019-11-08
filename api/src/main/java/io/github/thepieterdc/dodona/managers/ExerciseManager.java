/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.Exercise;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Manager for exercises.
 */
public interface ExerciseManager extends ResourceManager<Exercise> {
	/**
	 * Gets all exercises of a given series.
	 *
	 * @param series the series
	 * @return all exercises in the series
	 */
	@Nonnull
	List<Exercise> getAll(Series series);
	
	/**
	 * Gets an exercise.
	 *
	 * @param courseId   the course id
	 * @param exerciseId the exercise id
	 * @return the exercise
	 */
	Exercise get(long courseId, long exerciseId);
	
	/**
	 * Gets an exercise.
	 *
	 * @param exerciseId the exercise id
	 * @return the exercise
	 */
	Exercise get(long exerciseId);
	
	/**
	 * Gets the exercise of a given submission.
	 *
	 * @param submission the submission info
	 * @return the exercise
	 */
	@Nonnull
	Exercise get(SubmissionInfo submission);
}
