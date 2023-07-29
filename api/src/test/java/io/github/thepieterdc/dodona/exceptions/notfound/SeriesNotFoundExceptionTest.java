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
 * Tests io.github.thepieterdc.dodona.exceptions.notFound.SeriesNotFoundException.
 */
public class SeriesNotFoundExceptionTest {
	private static final Random random = new Random();

	/**
	 * Tests SeriesNotFoundException#getSeriesUrl().
	 */
	@Test
	public void testGetSeriesUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesNotFoundException exception = new SeriesNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertEquals(randomcharacters, exception.getSeriesUrl());
	}

	/**
	 * Tests SeriesNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesNotFoundException exception = new SeriesNotFoundException(randomcharacters);
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(SeriesNotFoundException.class.getSimpleName()));
	}
}
