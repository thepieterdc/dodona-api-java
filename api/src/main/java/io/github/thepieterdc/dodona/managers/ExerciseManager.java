/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;

import javax.annotation.Nonnull;

/**
 * Manager for exercises.
 */
public interface ExerciseManager extends ResourceManager<Exercise> {
	/**
	 * Gets the exercise of a given submission.
	 *
	 * @param submission the submission info
	 * @return the exercise
	 */
	@Nonnull
	Exercise get(SubmissionInfo submission);
}
