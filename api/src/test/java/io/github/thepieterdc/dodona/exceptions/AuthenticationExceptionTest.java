/*
 * Copyright (c) 2019. All rights reserved.
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
 * Tests be.ugent.piedcler.dodona.exceptions.AuthenticationException.
 */
public class AuthenticationExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests AuthenticationException#getToken().
	 */
	@Test
	public void testGetToken() {
		final String randomCharacters = String.valueOf(random.nextLong());
		final AuthenticationException exception = new AuthenticationException(randomCharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getToken(), is(randomCharacters));
	}
	
	/**
	 * Tests AuthenticationException#toString().
	 */
	@Test
	public void testToString() {
		final String randomCharacters = String.valueOf(random.nextLong());
		final AuthenticationException exception = new AuthenticationException(randomCharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(AuthenticationException.class.getSimpleName()));
	}
}