/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.managers;

import be.ugent.piedcler.dodona.resources.Exercise;
import be.ugent.piedcler.dodona.resources.Series;
import be.ugent.piedcler.dodona.resources.Submission;

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
	List<Exercise> getAll(@Nonnull Series series);
	
	/**
	 * Gets the exercise of a given submission.
	 *
	 * @param submission the submission
	 * @return the exercise
	 */
	@Nonnull
	Exercise get(@Nonnull Submission submission);
}
