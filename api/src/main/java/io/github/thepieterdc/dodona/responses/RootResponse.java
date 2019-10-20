/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.responses;

import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Root querying the root /
 */
public interface RootResponse {
	/**
	 * Gets the series with deadlines.
	 *
	 * @return the series with deadlines
	 */
	@Nonnull
	Collection<Series> getDeadlineSeries();
	
	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	@Nonnull
	User getUser();
}
