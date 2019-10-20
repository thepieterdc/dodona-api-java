/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.impl.resources.SeriesImpl;
import io.github.thepieterdc.dodona.impl.resources.UserImpl;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.responses.RootResponse;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;

/**
 * Implementation of a RootResponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class RootResponseImpl implements RootResponse {
	private final SeriesImpl[] deadlineSeries;
	private final User user;
	
	/**
	 * RootResponse constructor.
	 *
	 * @param deadlineSeries the series with deadlines
	 * @param user           the user
	 */
	public RootResponseImpl(@JsonProperty("deadline_series") final SeriesImpl[] deadlineSeries,
	                        @JsonProperty("user") final UserImpl user) {
		this.deadlineSeries = deadlineSeries;
		this.user = user;
	}
	
	@Override
	@Nonnull
	public Collection<Series> getDeadlineSeries() {
		return Arrays.asList(this.deadlineSeries);
	}
	
	@Override
	@Nonnull
	public User getUser() {
		return this.user;
	}
}
