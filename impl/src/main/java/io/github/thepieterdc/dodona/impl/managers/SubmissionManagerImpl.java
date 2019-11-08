/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.exceptions.accessdenied.SubmissionAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.SubmissionNotFoundException;
import io.github.thepieterdc.dodona.impl.requestbodies.SubmissionCreateRequestBody;
import io.github.thepieterdc.dodona.impl.resources.submissions.SubmissionImpl;
import io.github.thepieterdc.dodona.impl.resources.submissions.SubmissionInfoImpl;
import io.github.thepieterdc.dodona.impl.responses.SubmissionCreatedResponseBody;
import io.github.thepieterdc.dodona.managers.SubmissionManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Exercise;
import io.github.thepieterdc.dodona.resources.Resource;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.resources.submissions.Submission;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Implementation of SubmissionManager.
 */
public final class SubmissionManagerImpl extends AbstractManagerImpl<Submission> implements SubmissionManager {
	private static final String ENDPOINT_COURSE_ID_EXERCISE_ID = "%s?course_id=%d&exercise_id=%d";
	private static final String ENDPOINT_EXERCISE_ID = "%s?exercise_id=%d";
	private static final String ENDPOINT_SUBMISSIONS = "/submissions";
	private static final String ENDPOINT_SUBMISSIONS_ID = ENDPOINT_SUBMISSIONS + "/%d";
	
	private final Supplier<User> user;
	
	/**
	 * SubmissionManager constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 * @param user user accessor
	 */
	public SubmissionManagerImpl(final String host, final HttpClient http, final Supplier<User> user) {
		super(host, http, SubmissionImpl.class, SubmissionAccessDeniedException::new, SubmissionNotFoundException::new);
		this.user = user;
	}
	
	@Override
	public long create(@Nullable final Course course,
	                   @Nullable final Series series,
	                   final Exercise exercise,
	                   final String solution) {
		final Long courseId = Optional.ofNullable(course).map(Resource::getId).orElse(null);
		final Long seriesId = Optional.ofNullable(series).map(Resource::getId).orElse(null);
		return this.create(courseId, seriesId, exercise.getId(), solution);
	}
	
	@Override
	public long create(@Nullable final Long courseId,
	                   @Nullable final Long seriesId,
	                   final long exerciseId,
	                   final String solution) {
		final SubmissionCreateRequestBody request = new SubmissionCreateRequestBody(
			courseId, seriesId, exerciseId, solution
		);
		
		final String url = this.url(ENDPOINT_SUBMISSIONS);
		return this.http.post(url, request, SubmissionCreatedResponseBody.class)
			.forbidden(new SubmissionAccessDeniedException(url))
			.notFound(new SubmissionNotFoundException(url))
			.resolve()
			.getId();
	}
	
	@Override
	@Nonnull
	public Submission get(final long id) {
		return this.get(url(String.format(ENDPOINT_SUBMISSIONS_ID, id)));
	}
	
	@Nonnull
	@Override
	public Submission get(final SubmissionInfo info) {
		return this.get(info.getUrl());
	}
	
	@Override
	@Nonnull
	public List<SubmissionInfo> getAll(final User user) {
		return Arrays.asList(this.get(user.getSubmissionsUrl(), SubmissionInfoImpl[].class));
	}
	
	@Nonnull
	@Override
	public List<SubmissionInfo> getAllByMe() {
		return Arrays.asList(this.get(
			this.user.get().getSubmissionsUrl(),
			SubmissionInfoImpl[].class
		));
	}
	
	@Nonnull
	@Override
	public List<SubmissionInfo> getAllByMe(final Exercise exercise) {
		return this.getAllByMe(exercise.getId());
	}
	
	@Override
	@Nonnull
	public List<SubmissionInfo> getAllByMe(final long courseId, final long exerciseId) {
		final String endpoint = String.format(ENDPOINT_COURSE_ID_EXERCISE_ID,
			this.user.get().getSubmissionsUrl(), courseId, exerciseId
		);
		
		return Arrays.asList(this.get(endpoint, SubmissionInfoImpl[].class));
	}
	
	@Override
	@Nonnull
	public List<SubmissionInfo> getAllByMe(final long exerciseId) {
		final String endpoint = String.format(ENDPOINT_EXERCISE_ID,
			this.user.get().getSubmissionsUrl(), exerciseId
		);
		
		return Arrays.asList(this.get(endpoint, SubmissionInfoImpl[].class));
	}
}
