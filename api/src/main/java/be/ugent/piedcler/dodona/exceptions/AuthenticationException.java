/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java
 */
package be.ugent.piedcler.dodona.exceptions;

import javax.annotation.Nonnull;

/**
 * An exception occurred because an invalid API token was used.
 */
public final class AuthenticationException extends DodonaException {
	private final String token;
	
	/**
	 * AuthenticationException constructor.
	 *
	 * @param token the used authentication token
	 */
	public AuthenticationException(final String token) {
		super("The provided API token was not valid.");
		this.token = token;
	}
	
	/**
	 * Gets the used API token.
	 *
	 * @return the API token
	 */
	@Nonnull
	public String getToken() {
		return this.token;
	}
	
	@Override
	public String toString() {
		return String.format("AuthenticationException{token=%s}", this.token);
	}
}
