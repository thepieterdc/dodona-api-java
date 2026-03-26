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
import io.github.thepieterdc.http.exceptions.UnprocessableEntityException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Function;

/**
 * Implementation of a HttpResponse.
 */
final class HttpResponseImpl<T> implements HttpResponse<T> {
	@Nullable
	private final String forbiddenReason;

	private Function<String, ? extends RuntimeException> forbidden;
	private RuntimeException notFound;
	private RuntimeException unprocessable;

	private final Function<HttpResponseImpl<T>, T> resolver;

	/**
	 * HttpResponseImpl constructor.
	 *
	 * @param resolver the value resolver
	 */
	private HttpResponseImpl(final Function<HttpResponseImpl<T>, T> resolver,
	                         final @Nullable String forbiddenReason) {
		this.resolver = resolver;
		this.forbiddenReason = forbiddenReason;
		this.forbidden = reason -> new RuntimeException(
			Optional.ofNullable(reason).orElse("Access denied.")
		);
		this.notFound = new RuntimeException("Not found.");
		this.unprocessable = new UnprocessableEntityException("Unprocessable.");
	}

	@Nonnull
	@Override
	public HttpResponse<T> forbidden(final Function<String, ? extends RuntimeException> exceptionFactory) {
		this.forbidden = exceptionFactory;
		return this;
	}

	/**
	 * Generates a forbidden HTTP/403 response.
	 *
	 * @param <T> type class of the response
	 * @return response
	 */
	@Nonnull
	static <T> HttpResponse<T> forbidden(final @Nullable String reason) {
		return new HttpResponseImpl<>(r -> {
			throw r.forbidden.apply(r.forbiddenReason);
		}, reason);
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
		return new HttpResponseImpl<>(r -> value, null);
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
		}, null);
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
		}, null);
	}

	@Nonnull
	@Override
	public HttpResponse<T> unprocessable(final RuntimeException exception) {
		this.unprocessable = exception;
		return this;
	}

	/**
	 * Generates a not found HTTP/422 response.
	 *
	 * @param <T> type class of the response
	 * @return response
	 */
	@Nonnull
	static <T> HttpResponse<T> unprocessable() {
		return new HttpResponseImpl<>(r -> {
			throw r.unprocessable;
		}, null);
	}
}
