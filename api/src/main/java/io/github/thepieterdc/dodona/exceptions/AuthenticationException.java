/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java
 */
package io.github.thepieterdc.dodona.exceptions;

import javax.annotation.Nonnull;

/**
 * An exception occurred because an invalid API token was used.
 */
public final class AuthenticationException extends DodonaException {
	static final String INVALID = "An invalid API token was provided.";
	static final String MISSING = "No API token was provided.";
	
	/**
	 * AuthenticationException constructor.
	 *
	 * @param message the error message
	 */
	private AuthenticationException(final String message) {
		super(message);
	}
	
	/**
	 * Generates an exception stating that there was an API token provided, but
	 * it was invalid.
	 *
	 * @return the exception
	 */
	@Nonnull
	public static AuthenticationException invalid() {
		return new AuthenticationException(INVALID);
	}
	
	/**
	 * Generates an exception stating that there was no API token provided.
	 *
	 * @return the exception
	 */
	@Nonnull
	public static AuthenticationException missing() {
		return new AuthenticationException(MISSING);
	}
	
	@Override
	public String toString() {
		return String.format("AuthenticationException: %s", this.getMessage());
	}
}
