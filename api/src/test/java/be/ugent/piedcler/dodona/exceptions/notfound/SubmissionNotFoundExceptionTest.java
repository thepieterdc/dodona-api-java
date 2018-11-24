/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.notfound;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.notFound.SubmissionNotFoundException.
 */
public class SubmissionNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests SubmissionNotFoundException#getSubmissionUrl().
	 */
	@Test
	public void testGetSubmissionUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SubmissionNotFoundException exception = new SubmissionNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getSubmissionUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests SubmissionNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SubmissionNotFoundException exception = new SubmissionNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(SubmissionNotFoundException.class.getSimpleName()));
	}
}