/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.notfound;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

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
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getActivityUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests ActivityNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ActivityNotFoundException exception = new ActivityNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(ActivityNotFoundException.class.getSimpleName()));
	}
}