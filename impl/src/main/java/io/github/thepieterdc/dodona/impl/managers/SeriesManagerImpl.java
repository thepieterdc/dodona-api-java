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
import io.github.thepieterdc.dodona.exceptions.accessdenied.SeriesAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.SeriesNotFoundException;
import io.github.thepieterdc.dodona.impl.http.HttpWrapper;
import io.github.thepieterdc.dodona.impl.resources.SeriesImpl;
import io.github.thepieterdc.dodona.managers.SeriesManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of SeriesManager.
 */
public class SeriesManagerImpl implements SeriesManager {
	private static final HttpWrapper http = new HttpWrapper()
		.setAccessDeniedHandler(SeriesAccessDeniedException::new)
		.setNotFoundHandler(SeriesNotFoundException::new);
	
	private final DodonaClient client;
	
	/**
	 * SeriesManager implementation.
	 *
	 * @param client client
	 */
	public SeriesManagerImpl(final DodonaClient client) {
		this.client = client;
	}
	
	@Override
	@Nonnull
	public List<Series> getAll(final Course course) {
		return Arrays.asList(http.get(
			course.getSeriesUrl(), this.client.getApiToken(), this.client.getUserAgent(), SeriesImpl[].class
		));
	}
	
	@Override
	@Nonnull
	public Series get(final String url) {
		return http.get(url, this.client.getApiToken(), this.client.getUserAgent(), SeriesImpl.class);
	}
}
