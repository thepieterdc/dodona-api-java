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
 * An API token was not provided.
 */
public final class ApiTokenNotSetException extends ApiTokenException {
	private static final long serialVersionUID = -2870376489001117692L;
	
	/**
	 * ApiTokenNotSetException constructor.
	 */
	public ApiTokenNotSetException() {
		super("Please provide an API token.");
	}
	
	@Override
	@Nonnull
	public String toString() {
		return "ApiTokenNotSetException";
	}
}
