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
 * Tests io.github.thepieterdc.dodona.exceptions.notfound.CourseNotFoundException.
 */
public class CourseNotFoundExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests CourseNotFoundException#getCourseUrl().
	 */
	@Test
	public void testGetCourseUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseNotFoundException exception = new CourseNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getCourseUrl());
	}

	/**
	 * Tests CourseNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseNotFoundException exception = new CourseNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(CourseNotFoundException.class.getSimpleName()));
	}
}
