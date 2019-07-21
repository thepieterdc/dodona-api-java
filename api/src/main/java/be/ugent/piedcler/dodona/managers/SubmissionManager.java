/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.managers;

import be.ugent.piedcler.dodona.resources.*;
import be.ugent.piedcler.dodona.resources.submissions.PartialSubmission;
import be.ugent.piedcler.dodona.resources.submissions.Submission;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

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
	default long create(@Nullable final Course course,
	                    @Nullable final Series series,
	                    final Exercise exercise,
	                    final String solution) {
		final Long courseId = Optional.ofNullable(course).map(Resource::getId).orElse(null);
		final Long seriesId = Optional.ofNullable(series).map(Resource::getId).orElse(null);
		return this.create(courseId, seriesId, exercise.getId(), solution);
	}
	
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
	 * Gets the full submission, given a partial submission.
	 *
	 * @param partial the partial submission to complete
	 * @return the full submission
	 */
	@Nonnull
	default Submission get(@Nonnull final PartialSubmission partial) {
		return this.get(partial.getUrl());
	}
	
	/**
	 * Gets all submissions of a given user, sorted by creation timestamp.
	 *
	 * @param user the user
	 * @return all submissions by the given user
	 */
	@Nonnull
	List<PartialSubmission> getAll(User user);
	
	/**
	 * Gets all submissions to a given exercise, for the current user.
	 *
	 * @param exercise the exercise
	 * @return all submissions to the exercise, by the user
	 */
	@Nonnull
	default List<PartialSubmission> getAllByMe(final Exercise exercise) {
		return this.getAllByMe(exercise.getId());
	}
	
	/**
	 * Gets all submissions to a given exercise, for the current user.
	 *
	 * @param course     the course id
	 * @param exerciseId the exercise id
	 * @return all submissions to the exercise, by the user
	 */
	@Nonnull
	List<PartialSubmission> getAllByMe(final long course, final long exerciseId);
	
	/**
	 * Gets all submissions to a given exercise, for the current user.
	 *
	 * @param exerciseId the exercise id
	 * @return all submissions to the exercise, by the user
	 */
	@Nonnull
	List<PartialSubmission> getAllByMe(final long exerciseId);
}
