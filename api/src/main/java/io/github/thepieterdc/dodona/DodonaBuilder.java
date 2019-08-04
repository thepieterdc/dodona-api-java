/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona;

import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;

/**
 * A builder for Dodona clients.
 */
public interface DodonaBuilder {
	/**
	 * Sets the api token.
	 *
	 * @param token the token to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder authenticate(String token);
	
	@Nonnull
	static DodonaBuilder builder() {
		return ClassLoader.instance("io.github.thepieterdc.dodona.impl.DodonaBuilderImpl");
	}
	
	/**
	 * Changes the used HTTP client, to aid testing.
	 *
	 * @param http the HTTP client
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setHttpClient(HttpClient http);
	
	/**
	 * Sets the host url.
	 *
	 * @param host the host url to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setHost(String host);
	
	/**
	 * Sets the user agent.
	 *
	 * @param userAgent the user agent to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setUserAgent(String userAgent);
	
	/**
	 * Finalizes the construction.
	 *
	 * @return the constructed client
	 */
	@Nonnull
	DodonaClient build();
}
