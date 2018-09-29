/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl;

import be.ugent.piedcler.dodona.DodonaClient;
import be.ugent.piedcler.dodona.impl.http.HttpWrapper;
import be.ugent.piedcler.dodona.impl.managers.*;
import be.ugent.piedcler.dodona.impl.responsebodies.RootResponseBody;
import be.ugent.piedcler.dodona.managers.*;
import be.ugent.piedcler.dodona.resources.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Implementation of DodonaClient.
 */
public class DodonaClientImpl implements DodonaClient {
	private static final HttpWrapper http = new HttpWrapper();
	
	private String apiToken = "";
	private String baseUrl = "https://dodona.ugent.be";
	private String userAgent = "DodonaApi/1.0.0";
	
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
	public String getBaseUrl() {
		return this.baseUrl;
	}
	
	@Override
	@Nonnull
	public String getUserAgent() {
		return this.userAgent;
	}
	
	@Override
	@Nonnull
	public User me() {
		final RootResponseBody root = http.get(this.baseUrl, this.apiToken, this.userAgent, RootResponseBody.class);
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
	 * Sets the base url.
	 *
	 * @param url the base url
	 */
	void setBaseUrl(final String url) {
		this.baseUrl = url;
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
