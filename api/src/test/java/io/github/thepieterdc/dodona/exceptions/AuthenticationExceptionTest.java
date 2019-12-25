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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.AuthenticationException.
 */
public class AuthenticationExceptionTest {
	/**
	 * Tests AuthenticationException.invalid().
	 */
	@Test(expected = AuthenticationException.class)
	public void testInvalid() {
		throw AuthenticationException.invalid();
	}
	
	/**
	 * Tests AuthenticationException.missing().
	 */
	@Test(expected = AuthenticationException.class)
	public void testMissing() {
		throw AuthenticationException.missing();
	}
	
	/**
	 * Tests AuthenticationException#toString().
	 */
	@Test
	public void testToString() {
		final AuthenticationException invalid = AuthenticationException.invalid();
		Assert.assertThat(invalid, notNullValue());
		Assert.assertThat(invalid.toString(), notNullValue());
		Assert.assertThat(invalid.toString(), containsString(AuthenticationException.INVALID));
		
		final AuthenticationException missing = AuthenticationException.missing();
		Assert.assertThat(missing, notNullValue());
		Assert.assertThat(missing.toString(), notNullValue());
		Assert.assertThat(missing.toString(), containsString(AuthenticationException.MISSING));
	}
}