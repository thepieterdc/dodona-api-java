/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.http;

import javax.annotation.Nonnull;

/**
 * The response of a HTTP request.
 */
public interface HttpResponse<T> {
	/**
	 * Sets the exception to throw when a HTTP/403 error has occurred.
	 *
	 * @param exception the exception to throw
	 * @return fluent
	 */
	@Nonnull
	HttpResponse<T> forbidden(RuntimeException exception);
	
	/**
	 * Sets the exception to throw when a HTTP/404 error has occurred.
	 *
	 * @param exception the exception to throw
	 * @return fluent
	 */
	@Nonnull
	HttpResponse<T> notFound(RuntimeException exception);
	
	/**
	 * Resolves the current response to the obtained value, optionally invoking
	 * one of the configured handlers upon errors.
	 *
	 * @return the value
	 */
	@Nonnull
	T resolve();
}
