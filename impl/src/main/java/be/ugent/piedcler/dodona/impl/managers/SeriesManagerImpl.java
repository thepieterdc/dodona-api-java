/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.managers;

import be.ugent.piedcler.dodona.DodonaClient;
import be.ugent.piedcler.dodona.exceptions.accessdenied.SeriesAccessDeniedException;
import be.ugent.piedcler.dodona.exceptions.notfound.SeriesNotFoundException;
import be.ugent.piedcler.dodona.impl.http.HttpWrapper;
import be.ugent.piedcler.dodona.impl.resources.SeriesImpl;
import be.ugent.piedcler.dodona.managers.SeriesManager;
import be.ugent.piedcler.dodona.resources.Course;
import be.ugent.piedcler.dodona.resources.Series;

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
