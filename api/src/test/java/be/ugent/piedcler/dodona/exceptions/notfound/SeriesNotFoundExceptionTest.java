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
 * Tests be.ugent.piedcler.dodona.exceptions.notFound.SeriesNotFoundException.
 */
public class SeriesNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests SeriesNotFoundException#getSeriesUrl().
	 */
	@Test
	public void testGetSeriesUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesNotFoundException exception = new SeriesNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getSeriesUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests SeriesNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesNotFoundException exception = new SeriesNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(SeriesNotFoundException.class.getSimpleName()));
	}
}