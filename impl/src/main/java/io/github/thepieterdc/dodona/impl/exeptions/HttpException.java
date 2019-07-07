/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java
 */
package io.github.thepieterdc.dodona.impl.exeptions;

import io.github.thepieterdc.dodona.exceptions.DodonaException;

/**
 * An exception occurred when sending a HTTP request.
 */
public final class HttpException extends DodonaException {
	/**
	 * HttpException constructor.
	 *
	 * @param cause the cause for this exception
	 */
	public HttpException(final Exception cause) {
		this(cause.getMessage());
	}
	
	/**
	 * HttpException constructor.
	 *
	 * @param message the error message
	 */
	public HttpException(final String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "HttpException";
	}
}
