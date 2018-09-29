/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.responsebodies;

import be.ugent.piedcler.dodona.impl.resources.UserImpl;
import be.ugent.piedcler.dodona.resources.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
