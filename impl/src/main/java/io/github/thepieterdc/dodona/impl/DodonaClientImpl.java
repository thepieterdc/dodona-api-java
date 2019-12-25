/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl;

import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.impl.managers.CourseManagerImpl;
import io.github.thepieterdc.dodona.impl.managers.ExerciseManagerImpl;
import io.github.thepieterdc.dodona.impl.managers.SeriesManagerImpl;
import io.github.thepieterdc.dodona.impl.managers.SubmissionManagerImpl;
import io.github.thepieterdc.dodona.impl.managers.UserManagerImpl;
import io.github.thepieterdc.dodona.impl.responses.RootResponseImpl;
import io.github.thepieterdc.dodona.managers.CourseManager;
import io.github.thepieterdc.dodona.managers.ExerciseManager;
import io.github.thepieterdc.dodona.managers.SeriesManager;
import io.github.thepieterdc.dodona.managers.SubmissionManager;
import io.github.thepieterdc.dodona.managers.UserManager;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.responses.RootResponse;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Implementation of DodonaClient.
 */
public final class DodonaClientImpl implements DodonaClient {
	private final String host;
	private final HttpClient http;
	
	private final CourseManager courses;
	private final ExerciseManager exercises;
	private final SeriesManager series;
	private final SubmissionManager submissions;
	private final UserManager users;
	
	/**
	 * DodonaClientImpl constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 */
	DodonaClientImpl(final String host, final HttpClient http) {
		this.host = host;
		this.http = http;
		
		this.courses = new CourseManagerImpl(host, http);
		this.exercises = new ExerciseManagerImpl(host, http);
		this.series = new SeriesManagerImpl(host, http);
		this.submissions = new SubmissionManagerImpl(host, http, this::me);
		this.users = new UserManagerImpl(host, http);
	}
	
	@Override
	@Nonnull
	public CourseManager courses() {
		return this.courses;
	}
	
	@Nonnull
	@Override
	public Collection<Series> deadlines() {
		return this.root().getDeadlineSeries();
	}
	
	@Override
	@Nonnull
	public ExerciseManager exercises() {
		return this.exercises;
	}
	
	@Override
	@Nonnull
	public User me() {
		return this.root().getUser();
	}
	
	@Nonnull
	@Override
	public RootResponse root() {
		return this.http.get(this.host, RootResponseImpl.class).resolve();
	}
	
	@Override
	@Nonnull
	public SeriesManager series() {
		return this.series;
	}
	
	@Override
	@Nonnull
	public SubmissionManager submissions() {
		return this.submissions;
	}
	
	@Override
	@Nonnull
	public UserManager users() {
		return this.users;
	}
}
