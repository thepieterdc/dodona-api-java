/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources;

import io.github.thepieterdc.dodona.resources.activities.Activity;
import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.resources.Exercise.
 */
public class ExerciseTest {
	private static final RandomLongGenerator rng = RandomLongGenerator.positive();

	private static final String urlPattern = "https://dodona.be/courses/%d/series/%d/activities/%d";

	/**
	 * Tests Course.getId().
	 */
	@Test
	public void testGetId() {
		final Optional<Long> test1 = Activity.getId(String.format(urlPattern, 1, 2, 3));
		assertNotNull(test1);
		assertEquals(3L, (long) test1.orElseThrow(AssertionError::new));

		final Long randomId = rng.generate();
		assertNotNull(randomId);
		final Optional<Long> randomTest = Activity.getId(String.format(urlPattern, 1, 2, randomId));
		assertNotNull(randomTest);
		assertEquals(randomId, randomTest.orElseThrow(AssertionError::new));
	}

	/**
	 * Tests Course.getId() using an invalid url.
	 */
	@Test
	public void testGetIdInvalid() {
		final Optional<Long> randomTest = Course.getId("https://invalid.url/");
		assertNotNull(randomTest);
		assertFalse(randomTest.isPresent());
	}
}
