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
 * Tests io.github.thepieterdc.dodona.exceptions.accessdenied.CourseAccessDeniedException.
 */
public class CourseAccessDeniedExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests CourseAccessDeniedException#getCourseUrl().
	 */
	@Test
	public void testGetCourseUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseAccessDeniedException exception = new CourseAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getCourseUrl());
	}

	/**
	 * Tests CourseAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseAccessDeniedException exception = new CourseAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(CourseAccessDeniedException.class.getSimpleName()));
	}
}
