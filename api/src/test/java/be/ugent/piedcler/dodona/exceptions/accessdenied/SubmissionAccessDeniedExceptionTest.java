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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.SubmissionAccessDeniedException.
 */
public class SubmissionAccessDeniedExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests SubmissionAccessDeniedException#getSubmissionUrl().
	 */
	@Test
	public void testGetSubmissionUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SubmissionAccessDeniedException exception = new SubmissionAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getSubmissionUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests SubmissionAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SubmissionAccessDeniedException exception = new SubmissionAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(SubmissionAccessDeniedException.class.getSimpleName()));
	}
}