/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona;

import javax.annotation.Nonnull;

/**
 * A builder for Dodona clients.
 */
public interface DodonaBuilder {
	@Nonnull
	static DodonaBuilder builder() {
		return ClassLoader.instance("be.ugent.piedcler.dodona.impl.DodonaBuilderImpl");
	}
	
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
	
	/**
	 * Finalizes the construction.
	 *
	 * @return the constructed client
	 */
	@Nonnull
	DodonaClient build();
}
