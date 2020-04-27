/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers.activities;

import io.github.thepieterdc.dodona.exceptions.accessdenied.ActivityAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.ActivityNotFoundException;
import io.github.thepieterdc.dodona.impl.managers.AbstractManagerImpl;
import io.github.thepieterdc.dodona.impl.resources.activities.ActivityImpl;
import io.github.thepieterdc.dodona.impl.resources.activities.ExerciseImpl;
import io.github.thepieterdc.dodona.managers.activities.ActivityManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Resource;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.activities.Activity;
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of ActivityManager.
 *
 * @param <T> type class of the activity
 */
public abstract class ActivityManagerImpl extends AbstractManagerImpl<Activity> {
	private static final String ENDPOINT_ACTIVITIES = "/activities";
	private static final String ENDPOINT_ACTIVITIES_ID = ENDPOINT_ACTIVITIES + "/%d";
	
	private static final String ENDPOINT_COURSES_ACTIVITIES_ID = "/courses/%d" + ENDPOINT_ACTIVITIES_ID;
	
	/**
	 * ActivityManagerImpl constructor.
	 *
	 * @param host          the host
	 * @param http          the http client
	 * @param activityClass class of the activity type
	 */
	public ActivityManagerImpl(final String host, final HttpClient http) {
		super(host, http, ActivityImpl.class, ActivityAccessDeniedException::new, ActivityNotFoundException::new);
	}
	
	@Override
	@Nonnull
	public List<Exercise> getAll(final Series series) {
		return Arrays.asList(this.get(series.getExercisesUrl(), ExerciseImpl[].class));
	}
	
	@Override
	public Exercise get(final long courseId, final long activityId) {
		return this.get(this.url(String.format(ENDPOINT_COURSES_ACTIVITIES_ID, courseId, activityId)));
	}
	
	@Override
	public Exercise get(final long activityId) {
		return this.get(this.url(String.format(ENDPOINT_ACTIVITIES_ID, activityId)));
	}
	
	@Override
	@Nonnull
	public Exercise get(@Nonnull final SubmissionInfo submission) {
		final Long exerciseId = Exercise.getId(submission.getExerciseUrl())
			.orElseThrow(() -> new ActivityNotFoundException(submission.getExerciseUrl()));
		
		return submission.getCourseUrl().flatMap(Course::getId)
			.map(courseId -> this.get(courseId, exerciseId))
			.orElseGet(() -> this.get(exerciseId));
	}
}
