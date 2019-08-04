/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.http.impl;

import io.github.thepieterdc.dodona.exceptions.AuthenticationException;
import io.github.thepieterdc.http.HttpResponse;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * Implementation of a HttpResponse.
 */
final class HttpResponseImpl<T> implements HttpResponse<T> {
	private RuntimeException forbidden;
	private RuntimeException notFound;
	
	private final Function<HttpResponseImpl, T> resolver;
	
	/**
	 * HttpResponseImpl constructor.
	 *
	 * @param resolver the value resolver
	 */
	private HttpResponseImpl(final Function<HttpResponseImpl, T> resolver) {
		this.resolver = resolver;
		this.forbidden = new RuntimeException("Access denied.");
		this.notFound = new RuntimeException("Not found.");
	}
	
	@Nonnull
	@Override
	public HttpResponse<T> forbidden(final RuntimeException exception) {
		this.forbidden = exception;
		return this;
	}
	
	/**
	 * Generates a forbidden HTTP/403 response.
	 *
	 * @param <T> type class of the response
	 * @return response
	 */
	@Nonnull
	static <T> HttpResponse<T> forbidden() {
		return new HttpResponseImpl<>(r -> {
			throw r.forbidden;
		});
	}
	
	/**
	 * Generates a successful HTTP response.
	 *
	 * @param <T>   type class of the response
	 * @param value the response value
	 * @return response
	 */
	@Nonnull
	static <T> HttpResponse<T> of(final T value) {
		return new HttpResponseImpl<>(r -> value);
	}
	
	@Nonnull
	@Override
	public HttpResponse<T> notFound(final RuntimeException exception) {
		this.notFound = exception;
		return this;
	}
	
	/**
	 * Generates a not found HTTP/404 response.
	 *
	 * @param <T> type class of the response
	 * @return response
	 */
	@Nonnull
	static <T> HttpResponse<T> notFound() {
		return new HttpResponseImpl<>(r -> {
			throw r.notFound;
		});
	}
	
	@Nonnull
	@Override
	public T resolve() {
		return this.resolver.apply(this);
	}
	
	/**
	 * Generates an unauthorized HTTP/401 response.
	 *
	 * @param <T> type class of the response
	 * @param ex  the authentication exception to throw
	 * @return response
	 */
	@Nonnull
	static <T> HttpResponse<T> unauthorized(final AuthenticationException ex) {
		return new HttpResponseImpl<>(r -> {
			throw ex;
		});
	}
}
