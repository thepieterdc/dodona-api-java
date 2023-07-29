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
 * Tests io.github.thepieterdc.dodona.exceptions.notfound.ActivityNotFoundException.
 */
public class ActivityNotFoundExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests ActivityNotFoundException#getExerciseUrl().
	 */
	@Test
	public void testGetActivityUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ActivityNotFoundException exception = new ActivityNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getActivityUrl());
	}

	/**
	 * Tests ActivityNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ActivityNotFoundException exception = new ActivityNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(ActivityNotFoundException.class.getSimpleName()));
	}
}
