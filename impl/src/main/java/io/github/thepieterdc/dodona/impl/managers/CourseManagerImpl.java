/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.exceptions.accessdenied.CourseAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.CourseNotFoundException;
import io.github.thepieterdc.dodona.impl.http.HttpWrapper;
import io.github.thepieterdc.dodona.impl.resources.CourseImpl;
import io.github.thepieterdc.dodona.managers.CourseManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.submissions.PartialSubmission;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Implementation of CourseManager.
 */
public class CourseManagerImpl implements CourseManager {
	private static final String ENDPOINT_COURSES = "/courses/%d";
	
	private static final HttpWrapper http = new HttpWrapper()
		.setAccessDeniedHandler(CourseAccessDeniedException::new)
		.setNotFoundHandler(CourseNotFoundException::new);
	
	private final DodonaClient client;
	
	/**
	 * CourseManager implementation.
	 *
	 * @param client client
	 */
	public CourseManagerImpl(final DodonaClient client) {
		this.client = client;
	}
	
	@Override
	@Nonnull
	public Course get(final long id) {
		return this.get(this.client.getHost() + String.format(ENDPOINT_COURSES, id));
	}
	
	@Override
	@Nonnull
	public Optional<Course> get(@Nonnull final PartialSubmission submission) {
		return submission.getCourseUrl().map(this::get);
	}
	
	@Override
	@Nonnull
	public Course get(final String url) {
		return http.get(url, this.client.getApiToken(), this.client.getUserAgent(), CourseImpl.class);
	}
}
