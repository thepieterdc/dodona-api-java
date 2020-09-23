/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.SeriesVisibilityNotFoundException.
 */
public class SeriesVisibilityNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests SeriesVisibilityNotFoundException#getVisibility().
	 */
	@Test
	public void testGetVisibility() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesVisibilityNotFoundException exception = new SeriesVisibilityNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getVisibility(), is(randomcharacters));
	}
	
	/**
	 * Tests SeriesVisibilityNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesVisibilityNotFoundException exception = new SeriesVisibilityNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(SeriesVisibilityNotFoundException.class.getSimpleName()));
	}
}