/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.exceptions.accessdenied.ExerciseAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.ExerciseNotFoundException;
import io.github.thepieterdc.dodona.impl.resources.ExerciseImpl;
import io.github.thepieterdc.dodona.managers.ExerciseManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Exercise;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.submissions.PartialSubmission;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of ExerciseManager.
 */
public final class ExerciseManagerImpl extends AbstractManagerImpl<Exercise> implements ExerciseManager {
	private static final String ENDPOINT_EXERCISES = "/exercises";
	private static final String ENDPOINT_EXERCISES_ID = ENDPOINT_EXERCISES + "/%d";
	
	private static final String ENDPOINT_COURSES_EXERCISES_ID = "/courses/%d" + ENDPOINT_EXERCISES_ID;
	
	/**
	 * ExerciseManagerImpl constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 */
	public ExerciseManagerImpl(final String host, final HttpClient http) {
		super(host, http, ExerciseImpl.class, ExerciseAccessDeniedException::new, ExerciseNotFoundException::new);
	}
	
	@Override
	@Nonnull
	public List<Exercise> getAll(final Series series) {
		return Arrays.asList(this.get(series.getExercisesUrl(), ExerciseImpl[].class));
	}
	
	@Override
	public Exercise get(final long courseId, final long exerciseId) {
		return this.get(this.url(String.format(ENDPOINT_COURSES_EXERCISES_ID, courseId, exerciseId)));
	}
	
	@Override
	public Exercise get(final long exerciseId) {
		return this.get(this.url(String.format(ENDPOINT_EXERCISES_ID, exerciseId)));
	}
	
	@Override
	@Nonnull
	public Exercise get(@Nonnull final PartialSubmission submission) {
		final Long exerciseId = Exercise.getId(submission.getExerciseUrl())
			.orElseThrow(() -> new ExerciseNotFoundException(submission.getExerciseUrl()));
		
		return submission.getCourseUrl().flatMap(Course::getId)
			.map(courseId -> this.get(courseId, exerciseId))
			.orElseGet(() -> this.get(exerciseId));
	}
}
