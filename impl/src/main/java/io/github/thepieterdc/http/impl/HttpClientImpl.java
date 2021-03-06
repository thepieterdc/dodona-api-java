/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.thepieterdc.dodona.exceptions.AuthenticationException;
import io.github.thepieterdc.http.HttpClient;
import io.github.thepieterdc.http.HttpResponse;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

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
	
	private final ObjectMapper mapper;
	
	/**
	 * HttpClientImpl constructor.
	 *
	 * @param mapper object mapper
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
		return this.request(url, connection -> {
		}, returnCls);
	}
	
	@Nonnull
	@Override
	public <R, T> HttpResponse<T> post(final String url, final R body,
	                                   final Class<T> returnCls) {
		return this.request(url, connection -> {
			try {
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setRequestProperty(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE);
				
				try (final OutputStream out = connection.getOutputStream()) {
					mapper.writeValue(out, body);
				}
			} catch (final IOException ex) {
				throw new RuntimeException(ex);
			}
		}, returnCls);
	}
	
	/**
	 * Performs a HTTP request to the given url.
	 *
	 * @param url       the url
	 * @param adapter   the connection adapter
	 * @param returnCls the class of the response
	 * @return the response parsed as T
	 */
	@Nonnull
	private <T> HttpResponse<T> request(final String url,
	                                    final Adapter adapter,
	                                    final Class<T> returnCls) {
		try {
			final HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestProperty(ACCEPT_HEADER, ACCEPT_VALUE);
			Optional.ofNullable(this.authentication).ifPresent(token ->
				conn.setRequestProperty(AUTHORIZATION_HEADER, token)
			);
			conn.setRequestProperty(USER_AGENT_HEADER, this.userAgent);
			
			adapter.accept(conn);
			
			switch (conn.getResponseCode()) {
				case HttpURLConnection.HTTP_FORBIDDEN:
					return HttpResponseImpl.forbidden();
				
				case HttpURLConnection.HTTP_NOT_FOUND:
					return HttpResponseImpl.notFound();
				
				case HttpURLConnection.HTTP_UNAUTHORIZED: {
					if (this.authentication != null) {
						return HttpResponseImpl.unauthorized(
							AuthenticationException.invalid()
						);
					}
					return HttpResponseImpl.unauthorized(
						AuthenticationException.missing()
					);
				}
				
				case HTTP_UNPROCESSABLE_ENTITY:
					return HttpResponseImpl.unprocessable();
				
				default:
					return HttpResponseImpl.of(
						mapper.readValue(conn.getInputStream(), returnCls)
					);
			}
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Nonnull
	@Override
	public HttpClient userAgent(final String userAgent) {
		this.userAgent = userAgent;
		return this;
	}
}
