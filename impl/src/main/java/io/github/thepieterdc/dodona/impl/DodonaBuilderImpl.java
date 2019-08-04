/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.thepieterdc.dodona.DodonaBuilder;
import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.impl.data.EnumDeserializer;
import io.github.thepieterdc.http.HttpClient;
import io.github.thepieterdc.http.impl.HttpClientImpl;

import javax.annotation.Nonnull;

import static io.github.thepieterdc.dodona.DodonaClient.DEFAULT_HOST;

/**
 * Implementation of DodonaBuilder.
 */
public final class DodonaBuilderImpl implements DodonaBuilder {
	private String apiToken = "";
	private String host = DEFAULT_HOST;
	private HttpClient http;
	private String userAgent = "DodonaApi/" + getClass().getPackage().getImplementationVersion();
	
	private static final ObjectMapper mapper = new ObjectMapper()
		.enable(SerializationFeature.WRAP_ROOT_VALUE)
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		.registerModule(new JavaTimeModule())
		.registerModule(new SimpleModule().setDeserializerModifier(new EnumDeserializer()));
	
	/**
	 * DodonaBuilderImpl constructor.
	 */
	public DodonaBuilderImpl() {
		this.http = new HttpClientImpl(mapper);
	}
	
	@Override
	@Nonnull
	public DodonaBuilder authenticate(final String token) {
		this.apiToken = token;
		return this;
	}
	
	@Override
	@Nonnull
	public DodonaClient build() {
		return new DodonaClientImpl(
			this.host,
			this.http.authenticate(apiToken).userAgent(this.userAgent)
		);
	}
	
	@Override
	@Nonnull
	public DodonaBuilder setHost(final String url) {
		this.host = url;
		return this;
	}
	
	@Override
	@Nonnull
	public DodonaBuilder setHttpClient(final HttpClient http) {
		this.http = http;
		return this;
	}
	
	@Override
	@Nonnull
	public DodonaBuilder setUserAgent(final String userAgent) {
		this.userAgent = userAgent;
		return this;
	}
}
