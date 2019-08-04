/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.exceptions.accessdenied.SeriesAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.SeriesNotFoundException;
import io.github.thepieterdc.dodona.impl.resources.SeriesImpl;
import io.github.thepieterdc.dodona.managers.SeriesManager;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of SeriesManager.
 */
public final class SeriesManagerImpl extends AbstractManagerImpl<Series> implements SeriesManager {
	/**
	 * SeriesManagerImpl constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 */
	public SeriesManagerImpl(final String host, final HttpClient http) {
		super(host, http, SeriesImpl.class, SeriesAccessDeniedException::new, SeriesNotFoundException::new);
	}
	
	@Override
	@Nonnull
	public List<Series> getAll(final Course course) {
		return Arrays.asList(this.get(course.getSeriesUrl(), SeriesImpl[].class));
	}
}
