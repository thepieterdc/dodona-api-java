/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona;

import javax.annotation.Nonnull;

/**
 * A builder for Dodona clients.
 */
public interface DodonaBuilder {
	@Nonnull
	static DodonaBuilder builder() {
		return ClassLoader.instance("io.github.thepieterdc.dodona.impl.DodonaBuilderImpl");
	}
	
	/**
	 * Finalizes the construction.
	 *
	 * @return the constructed client
	 */
	@Nonnull
	DodonaClient build();
	
	/**
	 * Sets the api token.
	 *
	 * @param token the token to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setApiToken(final String token);
	
	/**
	 * Sets the host url.
	 *
	 * @param host the host url to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setHost(final String host);
	
	/**
	 * Sets the user agent.
	 *
	 * @param userAgent the user agent to set
	 * @return fluent
	 */
	@Nonnull
	DodonaBuilder setUserAgent(final String userAgent);
}
