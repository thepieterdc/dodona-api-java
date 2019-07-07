/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl;

import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.impl.http.HttpWrapper;
import io.github.thepieterdc.dodona.impl.managers.*;
import io.github.thepieterdc.dodona.impl.responsebodies.RootResponseBody;
import io.github.thepieterdc.dodona.managers.*;
import io.github.thepieterdc.dodona.resources.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Implementation of DodonaClient.
 */
public class DodonaClientImpl implements DodonaClient {
	private static final HttpWrapper http = new HttpWrapper();
	
	private String apiToken = "";
	private String host = DEFAULT_HOST;
	private String userAgent = "DodonaApi/" + getClass().getPackage().getImplementationVersion();
	
	@Nullable
	private CourseManager courses;
	
	@Nullable
	private ExerciseManager exercises;
	
	@Nullable
	private SeriesManager series;
	
	@Nullable
	private SubmissionManager submissions;
	
	@Nullable
	private UserManager users;
	
	@Override
	@Nonnull
	public CourseManager courses() {
		if (this.courses == null) {
			this.courses = new CourseManagerImpl(this);
		}
		return this.courses;
	}
	
	@Override
	@Nonnull
	public ExerciseManager exercises() {
		if (this.exercises == null) {
			this.exercises = new ExerciseManagerImpl(this);
		}
		return this.exercises;
	}
	
	@Override
	@Nonnull
	public String getApiToken() {
		return this.apiToken;
	}
	
	@Override
	@Nonnull
	public String getHost() {
		return this.host;
	}
	
	@Override
	@Nonnull
	public String getUserAgent() {
		return this.userAgent;
	}
	
	@Override
	@Nonnull
	public User me() {
		final RootResponseBody root = http.get(this.host, this.apiToken, this.userAgent, RootResponseBody.class);
		return root.getUser();
	}
	
	@Override
	@Nonnull
	public SeriesManager series() {
		if (this.series == null) {
			this.series = new SeriesManagerImpl(this);
		}
		return this.series;
	}
	
	/**
	 * Sets the api token.
	 *
	 * @param token the api token
	 */
	void setApiToken(final String token) {
		this.apiToken = token;
	}
	
	/**
	 * Sets the host url.
	 *
	 * @param host the host url
	 */
	void setHost(final String host) {
		this.host = host;
	}
	
	/**
	 * Sets the user agent.
	 *
	 * @param ua the user agent
	 */
	void setUserAgent(final String ua) {
		this.userAgent = ua;
	}
	
	@Override
	@Nonnull
	public SubmissionManager submissions() {
		if (this.submissions == null) {
			this.submissions = new SubmissionManagerImpl(this);
		}
		return this.submissions;
	}
	
	@Override
	@Nonnull
	public UserManager users() {
		if (this.users == null) {
			this.users = new UserManagerImpl(this);
		}
		return this.users;
	}
}
