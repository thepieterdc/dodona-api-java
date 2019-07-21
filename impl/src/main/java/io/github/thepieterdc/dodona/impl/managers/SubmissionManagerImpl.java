/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.exceptions.accessdenied.SubmissionAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.SubmissionNotFoundException;
import io.github.thepieterdc.dodona.impl.http.HttpWrapper;
import io.github.thepieterdc.dodona.impl.requestbodies.SubmissionCreateRequestBody;
import io.github.thepieterdc.dodona.impl.resources.PartialSubmissionImpl;
import io.github.thepieterdc.dodona.impl.resources.SubmissionImpl;
import io.github.thepieterdc.dodona.impl.responsebodies.SubmissionCreatedResponseBody;
import io.github.thepieterdc.dodona.managers.SubmissionManager;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.resources.submissions.PartialSubmission;
import io.github.thepieterdc.dodona.resources.submissions.Submission;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of SubmissionManager.
 */
public class SubmissionManagerImpl implements SubmissionManager {
	private static final String ENDPOINT_COURSE_ID_EXERCISE_ID = "%s?course_id=%d&exercise_id=%d";
	private static final String ENDPOINT_EXERCISE_ID = "%s?exercise_id=%d";
	private static final String ENDPOINT_SUBMISSIONS = "/submissions";
	private static final String ENDPOINT_SUBMISSIONS_ID = ENDPOINT_SUBMISSIONS + "/%d";
	
	private static final HttpWrapper http = new HttpWrapper()
		.setAccessDeniedHandler(SubmissionAccessDeniedException::new)
		.setNotFoundHandler(SubmissionNotFoundException::new);
	
	private final DodonaClient client;
	
	/**
	 * SubmissionManager implementation.
	 *
	 * @param client client
	 */
	public SubmissionManagerImpl(final DodonaClient client) {
		this.client = client;
	}
	
	@Override
	public long create(@Nullable final Long courseId,
	                   @Nullable final Long seriesId,
	                   final long exerciseId,
	                   final String solution) {
		final SubmissionCreateRequestBody request = new SubmissionCreateRequestBody(
			courseId, seriesId, exerciseId, solution
		);
		
		final SubmissionCreatedResponseBody response = http.post(
			this.client.getHost() + ENDPOINT_SUBMISSIONS,
			this.client.getApiToken(),
			this.client.getUserAgent(),
			request,
			SubmissionCreatedResponseBody.class
		);
		
		return response.getId();
	}
	
	@Override
	@Nonnull
	public Submission get(final long id) {
		return this.get(this.client.getHost() + String.format(ENDPOINT_SUBMISSIONS_ID, id));
	}
	
	@Override
	@Nonnull
	public Submission get(final String url) {
		return http.get(url, this.client.getApiToken(), this.client.getUserAgent(), SubmissionImpl.class);
	}
	
	@Override
	@Nonnull
	public List<PartialSubmission> getAll(final User user) {
		return Arrays.asList(http.get(
			user.getSubmissionsUrl(), this.client.getApiToken(), this.client.getUserAgent(), PartialSubmissionImpl[].class
		));
	}
	
	@Override
	@Nonnull
	public List<PartialSubmission> getAllByMe(final long courseId, final long exerciseId) {
		final String endpoint = String.format(ENDPOINT_COURSE_ID_EXERCISE_ID,
			this.client.me().getSubmissionsUrl(), courseId, exerciseId
		);
		
		return Arrays.asList(http.get(
			endpoint, this.client.getApiToken(), this.client.getUserAgent(), PartialSubmissionImpl[].class
		));
	}
	
	@Override
	@Nonnull
	public List<PartialSubmission> getAllByMe(final long exerciseId) {
		final String endpoint = String.format(ENDPOINT_EXERCISE_ID,
			this.client.me().getSubmissionsUrl(), exerciseId
		);
		
		return Arrays.asList(http.get(
			endpoint, this.client.getApiToken(), this.client.getUserAgent(), PartialSubmissionImpl[].class
		));
	}
}
