/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions;

import be.ugent.piedcler.dodona.exceptions.accessdenied.RootAccessDeniedException;
import be.ugent.piedcler.dodona.exceptions.accessdenied.UserAccessDeniedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.CourseColorNotFoundException.
 */
public class CourseColorNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests CourseColorNotFoundException#getColor().
	 */
	@Test
	public void testGetColor() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseColorNotFoundException exception = new CourseColorNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getColor(), is(randomcharacters));
	}
	
	/**
	 * Tests CourseColorNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseColorNotFoundException exception = new CourseColorNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(CourseColorNotFoundException.class.getSimpleName()));
	}
}