/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl;

import be.ugent.piedcler.dodona.DodonaBuilder;
import be.ugent.piedcler.dodona.DodonaClient;

import javax.annotation.Nonnull;

/**
 * Implementation of DodonaBuilder.
 */
public class DodonaBuilderImpl implements DodonaBuilder {
	private final DodonaClientImpl client;
	
	/**
	 * DodonaBuilderImpl constructor.
	 */
	public DodonaBuilderImpl() {
		this.client = new DodonaClientImpl();
	}
	
	@Override
	@Nonnull
	public DodonaClient build() {
		return this.client;
	}
	
	@Override
	@Nonnull
	public DodonaBuilder setApiToken(final String token) {
		this.client.setApiToken(token);
		return this;
	}
	
	@Override
	@Nonnull
	public DodonaBuilder setHost(final String url) {
		this.client.setHost(url);
		return this;
	}
	
	@Override
	@Nonnull
	public DodonaBuilder setUserAgent(final String userAgent) {
		this.client.setUserAgent(userAgent);
		return this;
	}
}
