/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.notfound;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.notFound.UserNotFoundException.
 */
public class UserNotFoundExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests UserNotFoundException#getUserUrl().
	 */
	@Test
	public void testGetUserUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserNotFoundException exception = new UserNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertEquals(exception.getUserUrl(), randomcharacters);
	}

	/**
	 * Tests UserNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserNotFoundException exception = new UserNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(UserNotFoundException.class.getSimpleName()));
	}
}
