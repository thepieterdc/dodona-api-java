/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources;

import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Tests io.github.thepieterdc.dodona.resources.Series.
 */
public class SeriesTest {
	private static final RandomLongGenerator rng = RandomLongGenerator.positive();
	
	private static final String urlPattern = "https://dodona.ugent.be/courses/%d/series/%d/exercise/%d";
	
	/**
	 * Tests Series.getId().
	 */
	@Test
	public void testGetId() {
		final Optional<Long> test1 = Series.getId(String.format(urlPattern, 1, 2, 3));
		Assert.assertNotNull(test1);
		Assert.assertEquals(2L, (long) test1.orElseThrow(AssertionError::new));
		
		final Long randomId = rng.generate();
		Assert.assertNotNull(randomId);
		final Optional<Long> randomTest = Series.getId(String.format(urlPattern, 1, randomId, 3));
		Assert.assertNotNull(randomTest);
		Assert.assertEquals(randomId, randomTest.orElseThrow(AssertionError::new));
	}
	
	/**
	 * Tests Series.getId() using an invalid url.
	 */
	@Test
	public void testGetIdInvalid() {
		final Optional<Long> randomTest = Series.getId("https://invalid.url/");
		Assert.assertNotNull(randomTest);
		Assert.assertFalse(randomTest.isPresent());
	}
}