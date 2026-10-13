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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of a RootResponse.
 *
 * @param deadlineSeries the series with deadlines
 * @param user           the user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RootResponseImpl(@JsonProperty("deadline_series") List<SeriesImpl> deadlineSeries,
                               @JsonProperty("user") UserImpl user) implements RootResponse {
	@Override
	@Nonnull
	public Collection<Series> getDeadlineSeries() {
		return Collections.unmodifiableList(this.deadlineSeries);
	}

	@Override
	@Nonnull
	public User getUser() {
		return this.user;
	}
}
