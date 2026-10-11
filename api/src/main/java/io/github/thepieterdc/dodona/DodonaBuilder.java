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
import java.util.Locale;
import java.util.ServiceLoader;

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
		return ServiceLoader.load(DodonaBuilder.class).findFirst().orElseThrow(() ->
			new IllegalStateException("No DodonaBuilder implementation found on the classpath, add the dodona-api impl artifact.")
		);
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
	 * Sets the locale in which Dodona should respond (e.g. for error messages
	 * and translated content). Dodona currently supports "en" and "nl" and falls
	 * back to its default locale for other languages. If not set, Dodona uses the
	 * language of the authenticated user.
	 *
	 * @param locale the locale to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setLocale(Locale locale);

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
