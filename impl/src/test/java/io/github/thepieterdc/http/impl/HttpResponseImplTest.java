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
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests io.github.thepieterdc.http.impl.HttpResponseImpl.
 */
public class HttpResponseImplTest {
	/**
	 * Tests HttpResponseImpl.unauthorized().
	 */
	@Test
	public void testUnauthorized() {
		final AuthenticationException thrown1 = assertThrows(AuthenticationException.class, () -> HttpResponseImpl.unauthorized(AuthenticationException.invalid())
			.resolve());
		assertTrue(thrown1.getMessage().contains("invalid"));

		final AuthenticationException thrown2 = assertThrows(AuthenticationException.class, () -> HttpResponseImpl.unauthorized(AuthenticationException.missing())
			.resolve());
		assertTrue(thrown2.getMessage().contains("provided"));
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
