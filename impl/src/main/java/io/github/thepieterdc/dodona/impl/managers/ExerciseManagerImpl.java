/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.data.ActivityType;
import io.github.thepieterdc.dodona.exceptions.accessdenied.ActivityAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.ActivityNotFoundException;
import io.github.thepieterdc.dodona.impl.resources.activities.ActivityImpl;
import io.github.thepieterdc.dodona.managers.ExerciseManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.activities.Activity;
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of ExerciseManager.
 */
public final class ExerciseManagerImpl implements ExerciseManager {
	private static final String ENDPOINT_ACTIVITIES = "/activities";
	private static final String ENDPOINT_ACTIVITIES_ID = ENDPOINT_ACTIVITIES + "/%d";
	
	private static final String ENDPOINT_COURSES_ACTIVITIES_ID = "/courses/%d" + ENDPOINT_ACTIVITIES_ID;
	
	private final String host;
	private final HttpClient http;
	
	/**
	 * ExerciseManagerImpl constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 */
	public ExerciseManagerImpl(final String host, final HttpClient http) {
		this.host = host;
		this.http = http;
	}
	
	@Override
	@Nonnull
	public List<Exercise> getAll(final Series series) {
		return this.getAll(series.getExercisesUrl());
	}
	
	/**
	 * Gets all exercises at the given url.
	 *
	 * @param url the url
	 * @return all exercises
	 */
	@Nonnull
	private List<Exercise> getAll(final String url) {
		final List<Activity> activities = Arrays.asList(this.http
			.get(url, ActivityImpl[].class)
			.forbidden(new ActivityAccessDeniedException(url))
			.notFound(new ActivityNotFoundException(url))
			.resolve());
		return activities.stream()
			.filter(activity -> activity.getType() == ActivityType.EXERCISE)
			.map(activity -> (Exercise) activity)
			.collect(Collectors.toList());
	}
	
	@Override
	@Nonnull
	public List<Exercise> getAll() {
		return this.getAll(this.url(ENDPOINT_ACTIVITIES));
	}
	
	@Override
	public Exercise get(final long courseId, final long exerciseId) {
		return this.get(this.url(String.format(ENDPOINT_COURSES_ACTIVITIES_ID, courseId, exerciseId)));
	}
	
	@Override
	public Exercise get(final long exerciseId) {
		return this.get(this.url(String.format(ENDPOINT_ACTIVITIES_ID, exerciseId)));
	}
	
	@Override
	@Nonnull
	public Exercise get(@Nonnull final SubmissionInfo submission) {
		final Long exerciseId = Activity.getId(submission.getExerciseUrl())
			.orElseThrow(() -> new ActivityNotFoundException(submission.getExerciseUrl()));
		
		return submission.getCourseUrl().flatMap(Course::getId)
			.map(courseId -> this.get(courseId, exerciseId))
			.orElseGet(() -> this.get(exerciseId));
	}
	
	@Nonnull
	@Override
	public Exercise get(final String url) {
		final Activity activity = this.http
			.get(url, ActivityImpl.class)
			.forbidden(new ActivityAccessDeniedException(url))
			.notFound(new ActivityNotFoundException(url))
			.resolve();
		
		if (activity.getType() != ActivityType.EXERCISE) {
			throw new ActivityNotFoundException(url);
		}
		
		return (Exercise) activity;
	}
	
	/**
	 * Prepends the host to the given endpoint.
	 *
	 * @param endpoint the endpoint
	 * @return the complete url
	 */
	@Nonnull
	private String url(final String endpoint) {
		return this.host + endpoint;
	}
}
