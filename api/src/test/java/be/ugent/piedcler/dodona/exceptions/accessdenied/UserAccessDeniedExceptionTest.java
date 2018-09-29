/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.UserAccessDeniedException.
 */
public class UserAccessDeniedExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests UserAccessDeniedException#getUserId().
	 */
	@Test
	public void testGetUserUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserAccessDeniedException exception = new UserAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getUserUrl(), is(randomcharacters));
	}
}