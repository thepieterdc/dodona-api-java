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

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.UserAccessDeniedException.
 */
public class UserAccessDeniedExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests UserAccessDeniedException#getUserUrl().
	 */
	@Test
	public void testGetUserUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserAccessDeniedException exception = new UserAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getUserUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests UserAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final UserAccessDeniedException exception = new UserAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(UserAccessDeniedException.class.getSimpleName()));
	}
}