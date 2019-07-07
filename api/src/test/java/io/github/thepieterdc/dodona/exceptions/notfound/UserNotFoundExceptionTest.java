/*
 * Copyright (c) 2019. All rights reserved.
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

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.notFound.UserNotFoundException.
 */
public class UserNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests UserNotFoundException#getUserUrl().
	 */
	@Test
	public void testGetUserUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserNotFoundException exception = new UserNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getUserUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests UserNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserNotFoundException exception = new UserNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(UserNotFoundException.class.getSimpleName()));
	}
}