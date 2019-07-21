/*
 * Copyright (c) 2018-2019. All rights reserved.
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
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.SeriesAccessDeniedException.
 */
public class SeriesAccessDeniedExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests SeriesAccessDeniedException#getSeriesUrl().
	 */
	@Test
	public void testGetSeriesUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesAccessDeniedException exception = new SeriesAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getSeriesUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests SeriesAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final SeriesAccessDeniedException exception = new SeriesAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(SeriesAccessDeniedException.class.getSimpleName()));
	}
}