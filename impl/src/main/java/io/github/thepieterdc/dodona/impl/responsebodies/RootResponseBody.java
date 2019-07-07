/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.responsebodies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.impl.resources.UserImpl;
import io.github.thepieterdc.dodona.resources.User;

import javax.annotation.Nonnull;

/**
 * Response from GET /
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class RootResponseBody {
	private final User user;
	
	/**
	 * RootResponse constructor.
	 *
	 * @param user the user
	 */
	public RootResponseBody(@JsonProperty("user") final UserImpl user) {
		this.user = user;
	}
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	@Nonnull
	public User getUser() {
		return this.user;
	}
}
