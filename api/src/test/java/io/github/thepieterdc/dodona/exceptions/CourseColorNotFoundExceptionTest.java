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

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.CourseColorNotFoundException.
 */
public class CourseColorNotFoundExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests CourseColorNotFoundException#getColor().
	 */
	@Test
	public void testGetColor() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseColorNotFoundException exception = new CourseColorNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getColor());
	}

	/**
	 * Tests CourseColorNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseColorNotFoundException exception = new CourseColorNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(CourseColorNotFoundException.class.getSimpleName()));
	}
}
