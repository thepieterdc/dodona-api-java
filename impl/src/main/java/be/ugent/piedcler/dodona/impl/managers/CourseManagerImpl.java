/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.managers;

import be.ugent.piedcler.dodona.DodonaClient;
import be.ugent.piedcler.dodona.exceptions.accessdenied.CourseAccessDeniedException;
import be.ugent.piedcler.dodona.exceptions.notfound.CourseNotFoundException;
import be.ugent.piedcler.dodona.impl.http.HttpWrapper;
import be.ugent.piedcler.dodona.impl.resources.CourseImpl;
import be.ugent.piedcler.dodona.managers.CourseManager;
import be.ugent.piedcler.dodona.resources.Course;

import javax.annotation.Nonnull;

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
		return this.get(this.client.getBaseUrl() + String.format(ENDPOINT_COURSES, id));
	}
	
	@Override
	@Nonnull
	public Course get(final String url) {
		return http.get(url, this.client.getApiToken(), this.client.getUserAgent(), CourseImpl.class);
	}
}
