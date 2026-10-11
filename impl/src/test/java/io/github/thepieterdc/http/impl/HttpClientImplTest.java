/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests HttpClientImpl locale handling.
 */
public class HttpClientImplTest {
	private final AtomicReference<String> acceptLanguage = new AtomicReference<>();
	private final AtomicReference<String> query = new AtomicReference<>();
	private HttpServer server;

	@BeforeEach
	public void setUp() throws IOException {
		this.server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
		this.server.createContext("/", exchange -> {
			this.acceptLanguage.set(exchange.getRequestHeaders().getFirst("Accept-Language"));
			this.query.set(exchange.getRequestURI().getRawQuery());
			final byte[] body = "{}".getBytes();
			exchange.sendResponseHeaders(200, body.length);
			exchange.getResponseBody().write(body);
			exchange.close();
		});
		this.server.start();
	}

	@AfterEach
	public void tearDown() {
		this.server.stop(0);
	}

	private String url(final String path) {
		return "http://127.0.0.1:" + this.server.getAddress().getPort() + path;
	}

	@Test
	public void testNoLocale() {
		new HttpClientImpl(new ObjectMapper()).get(this.url("/a?x=1"), Object.class);
		assertNull(this.acceptLanguage.get());
		assertEquals("x=1", this.query.get());
	}

	@Test
	public void testLocaleWithoutQuery() {
		new HttpClientImpl(new ObjectMapper()).locale(Locale.forLanguageTag("nl"))
			.get(this.url("/a"), Object.class);
		assertEquals("nl", this.acceptLanguage.get());
		assertEquals("locale=nl", this.query.get());
	}

	@Test
	public void testLocaleWithQuery() {
		new HttpClientImpl(new ObjectMapper()).locale(Locale.forLanguageTag("en-GB"))
			.get(this.url("/a?x=1"), Object.class);
		assertEquals("en-GB", this.acceptLanguage.get());
		assertEquals("x=1&locale=en-GB", this.query.get());
	}
}
