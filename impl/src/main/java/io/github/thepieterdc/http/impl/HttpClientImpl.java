/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.http.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thepieterdc.dodona.exceptions.AuthenticationException;
import io.github.thepieterdc.http.HttpClient;
import io.github.thepieterdc.http.HttpResponse;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Implementation of a HttpClient.
 */
public final class HttpClientImpl implements HttpClient {
	private static final int HTTP_UNPROCESSABLE_ENTITY = 422;

	private static final String ACCEPT_HEADER = "Accept";
	private static final String ACCEPT_VALUE = "application/json";
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String CONTENT_TYPE_HEADER = "Content-Type";
	private static final String CONTENT_TYPE_VALUE = "application/json";
	private static final String USER_AGENT_HEADER = "User-Agent";

	@Nullable
	private String authentication = null;

	@Nullable
	private String userAgent = null;

	private final java.net.http.HttpClient client = java.net.http.HttpClient.newBuilder()
		.followRedirects(java.net.http.HttpClient.Redirect.NORMAL)
		.build();

	private final ObjectMapper mapper;

	/**
	 * HttpClientImpl constructor.
	 *
	 * @param mapper the object mapper to (de)serialize bodies with
	 */
	public HttpClientImpl(final ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Nonnull
	@Override
	public HttpClient authenticate(final String apiToken) {
		this.authentication = apiToken;
		return this;
	}

	@Nonnull
	@Override
	public <T> HttpResponse<T> get(final String url, final Class<T> returnCls) {
		return this.request(this.newRequest(url).GET(), returnCls);
	}

	@Nonnull
	@Override
	public <R, T> HttpResponse<T> post(final String url, final R body,
	                                   final Class<T> returnCls) {
		try {
			return this.request(
				this.newRequest(url)
					.header(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
					.POST(BodyPublishers.ofByteArray(mapper.writeValueAsBytes(body))),
				returnCls
			);
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Nonnull
	private HttpRequest.Builder newRequest(final String url) {
		final HttpRequest.Builder builder = HttpRequest.newBuilder(URI.create(url))
			.header(ACCEPT_HEADER, ACCEPT_VALUE);
		if (this.authentication != null) {
			builder.header(AUTHORIZATION_HEADER, this.authentication);
		}
		if (this.userAgent != null) {
			builder.header(USER_AGENT_HEADER, this.userAgent);
		}
		return builder;
	}

	@Nonnull
	private <T> HttpResponse<T> request(final HttpRequest.Builder request,
	                                    final Class<T> returnCls) {
		try {
			final java.net.http.HttpResponse<InputStream> response =
				this.client.send(request.build(), BodyHandlers.ofInputStream());

			try (final InputStream in = response.body()) {
				return switch (response.statusCode()) {
					case HttpURLConnection.HTTP_FORBIDDEN ->
						HttpResponseImpl.forbidden(readForbiddenReason(in));
					case HttpURLConnection.HTTP_NOT_FOUND -> HttpResponseImpl.notFound();
					case HttpURLConnection.HTTP_UNAUTHORIZED -> HttpResponseImpl.unauthorized(
						this.authentication != null
							? AuthenticationException.invalid()
							: AuthenticationException.missing()
					);
					case HTTP_UNPROCESSABLE_ENTITY -> HttpResponseImpl.unprocessable();
					default -> {
						if (response.statusCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
							throw new IOException("Unexpected HTTP status " + response.statusCode());
						}
						yield HttpResponseImpl.of(mapper.readValue(in, returnCls));
					}
				};
			}
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		} catch (final InterruptedException ex) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ex);
		}
	}

	@Nullable
	private String readForbiddenReason(final InputStream in) {
		try {
			final String body = new String(in.readAllBytes(), StandardCharsets.UTF_8).trim();
			if (body.isEmpty()) {
				return null;
			}

			final JsonNode error = mapper.readTree(body).get("error");
			if (error != null && error.isTextual()) {
				final String message = error.asText().trim();
				return message.isEmpty() ? null : message;
			}

			return null;
		} catch (final IOException ignored) {
			return null;
		}
	}

	@Nonnull
	@Override
	public HttpClient userAgent(final String userAgent) {
		this.userAgent = userAgent;
		return this;
	}
}
