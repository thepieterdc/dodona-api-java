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
 * Tests io.github.thepieterdc.dodona.exceptions.accessdenied.SeriesAccessDeniedException.
 */
public class SeriesAccessDeniedExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests SeriesAccessDeniedException#getSeriesUrl().
	 */
	@Test
	public void testGetSeriesUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesAccessDeniedException exception = new SeriesAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getSeriesUrl());
	}

	/**
	 * Tests SeriesAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesAccessDeniedException exception = new SeriesAccessDeniedException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(SeriesAccessDeniedException.class.getSimpleName()));
	}
}
