/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.accessdenied;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.accessdenied.UserAccessDeniedException.
 */
public class UserAccessDeniedExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests UserAccessDeniedException#getUserUrl().
	 */
	@Test
	public void testGetUserUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserAccessDeniedException exception = new UserAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getUserUrl());
	}

	/**
	 * Tests UserAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserAccessDeniedException exception = new UserAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(UserAccessDeniedException.class.getSimpleName()));
	}
}
