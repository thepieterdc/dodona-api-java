/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.resources.submissions.Submission;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Manager for submissions.
 */
public interface SubmissionManager extends ResourceManager<Submission> {
	/**
	 * Submits the given code to the given exercise.
	 *
	 * @param course   the course
	 * @param series   the series
	 * @param exercise the exercise
	 * @param solution solution to the exercise
	 * @return the id of the created submission
	 */
	long create(@Nullable Course course, @Nullable Series series,
	            Exercise exercise, String solution);
	
	/**
	 * Submits the given code to the given exercise.
	 *
	 * @param courseId   id of the course
	 * @param seriesId   the id of the series
	 * @param exerciseId id of the exercise
	 * @param solution   solution to the exercise
	 * @return the id of the created submission
	 */
	long create(@Nullable Long courseId, @Nullable Long seriesId, long exerciseId, String solution);
	
	/**
	 * Gets the submission with the given id.
	 *
	 * @param id the id of the submission
	 * @return the submission
	 */
	@Nonnull
	Submission get(long id);
	
	/**
	 * Gets the full submission, given its info.
	 *
	 * @param info the submission info
	 * @return the full submission
	 */
	@Nonnull
	Submission get(SubmissionInfo info);
	
	/**
	 * Gets all submissions of a given user, sorted by creation timestamp.
	 *
	 * @param user the user
	 * @return all submissions by the given user
	 */
	@Nonnull
	List<SubmissionInfo> getAll(User user);
	
	/**
	 * Gets all submissions by the current user.
	 *
	 * @return all submissions by the current user
	 */
	@Nonnull
	List<SubmissionInfo> getAllByMe();
	
	/**
	 * Gets all submissions to a given exercise, for the current user.
	 *
	 * @param exercise the exercise
	 * @return all submissions to the exercise, by the user
	 */
	@Nonnull
	List<SubmissionInfo> getAllByMe(Exercise exercise);
	
	/**
	 * Gets all submissions to a given exercise, for the current user.
	 *
	 * @param course     the course id
	 * @param exerciseId the exercise id
	 * @return all submissions to the exercise, by the user
	 */
	@Nonnull
	List<SubmissionInfo> getAllByMe(long course, long exerciseId);
	
	/**
	 * Gets all submissions to a given exercise, for the current user.
	 *
	 * @param exerciseId the exercise id
	 * @return all submissions to the exercise, by the user
	 */
	@Nonnull
	List<SubmissionInfo> getAllByMe(long exerciseId);
}
