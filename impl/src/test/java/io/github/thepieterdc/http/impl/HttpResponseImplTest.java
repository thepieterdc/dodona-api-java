/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.http.impl;

import io.github.thepieterdc.dodona.exceptions.AuthenticationException;
import io.github.thepieterdc.http.HttpResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.annotation.Nonnull;

/**
 * Tests io.github.thepieterdc.http.impl.HttpResponseImpl.
 */
public class HttpResponseImplTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/**
	 * Tests HttpResponseImpl.unauthorized().
	 */
	@Test
	public void testUnauthorized() {
		exception.expect(AuthenticationException.class);
		exception.expectMessage("invalid");
		HttpResponseImpl.unauthorized(AuthenticationException.invalid())
			.resolve();
		
		exception.expect(AuthenticationException.class);
		exception.expectMessage("np");
		HttpResponseImpl.unauthorized(AuthenticationException.missing())
			.resolve();
	}
	
	/**
	 * Encodes the given object in a http response.
	 *
	 * @param object the object to wrap
	 * @param <T>    type class of the object
	 * @return wrapped object
	 */
	@Nonnull
	public static <T> HttpResponse<T> wrap(final T object) {
		return HttpResponseImpl.of(object);
	}
}