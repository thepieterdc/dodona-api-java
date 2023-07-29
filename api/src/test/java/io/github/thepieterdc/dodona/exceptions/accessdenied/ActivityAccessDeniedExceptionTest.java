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
 * Tests io.github.thepieterdc.dodona.exceptions.accessdenied.ActivityAccessDeniedException
 */
public class ActivityAccessDeniedExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests ActivityAccessDeniedException#getActivityUrl().
	 */
	@Test
	public void testGetExerciseUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ActivityAccessDeniedException exception = new ActivityAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getActivityUrl());
	}

	/**
	 * Tests ActivityAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ActivityAccessDeniedException exception = new ActivityAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(ActivityAccessDeniedException.class.getSimpleName()));
	}
}
