/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.SubmissionStatusNotFoundException.
 */
public class SubmissionStatusNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests SubmissionStatusNotFoundException#getStatus().
	 */
	@Test
	public void testGetStatus() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SubmissionStatusNotFoundException exception = new SubmissionStatusNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getStatus(), is(randomcharacters));
	}
	
	/**
	 * Tests SubmissionStatusNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SubmissionStatusNotFoundException exception = new SubmissionStatusNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(SubmissionStatusNotFoundException.class.getSimpleName()));
	}
}