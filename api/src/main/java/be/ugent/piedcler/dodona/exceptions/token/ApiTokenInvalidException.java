/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.token;

import javax.annotation.Nonnull;

/**
 * The API token was provided, but it was invalid.
 */
public final class ApiTokenInvalidException extends ApiTokenException {
	private static final long serialVersionUID = -4438066283579453196L;
	
	private final String token;
	
	/**
	 * ApiTokenInvalidException constructor.
	 */
	public ApiTokenInvalidException(final String token) {
		super(String.format("The provided API token \"%s\" is invalid.", token));
		this.token = token;
	}
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	@Nonnull
	public String getToken() {
		return this.token;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("ApiTokenInvalidException{token=%s}", this.token);
	}
}
