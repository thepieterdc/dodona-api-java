/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.AuthenticationException.
 */
public class AuthenticationExceptionTest {
	/**
	 * Tests AuthenticationException.invalid().
	 */
	@Test
	public void testInvalid() {
		assertThrows(AuthenticationException.class, () -> {
			throw AuthenticationException.invalid();
		});
	}

	/**
	 * Tests AuthenticationException.missing().
	 */
	@Test
	public void testMissing() {
		assertThrows(AuthenticationException.class, () -> {
			throw AuthenticationException.missing();
		});
	}

	/**
	 * Tests AuthenticationException#toString().
	 */
	@Test
	public void testToString() {
		final AuthenticationException invalid = AuthenticationException.invalid();
		assertNotNull(invalid);
		assertNotNull(invalid.toString());
		assertTrue(invalid.toString().contains(AuthenticationException.INVALID));

		final AuthenticationException missing = AuthenticationException.missing();
		assertNotNull(missing);
		assertNotNull(missing.toString());
		assertTrue(missing.toString().contains(AuthenticationException.MISSING));
	}
}
