/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.exceptions.accessdenied.CourseAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.CourseNotFoundException;
import io.github.thepieterdc.dodona.impl.resources.CourseImpl;
import io.github.thepieterdc.dodona.managers.CourseManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.submissions.PartialSubmission;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Implementation of CourseManager.
 */
public final class CourseManagerImpl extends AbstractManagerImpl<Course> implements CourseManager {
	private static final String ENDPOINT_COURSES = "/courses/%d";
	
	/**
	 * CourseManagerImpl constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 */
	public CourseManagerImpl(final String host, final HttpClient http) {
		super(host, http, CourseImpl.class, CourseAccessDeniedException::new, CourseNotFoundException::new);
	}
	
	@Override
	@Nonnull
	public Course get(final long id) {
		return this.get(this.url(String.format(ENDPOINT_COURSES, id)));
	}
	
	@Nonnull
	@Override
	public Optional<Course> get(@Nonnull final PartialSubmission submission) {
		return submission.getCourseUrl().map(this::get);
	}
}
