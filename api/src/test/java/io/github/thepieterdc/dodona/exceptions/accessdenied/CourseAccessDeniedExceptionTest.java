/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.accessdenied;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.CourseAccessDeniedException.
 */
public class CourseAccessDeniedExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests CourseAccessDeniedException#getCourseUrl().
	 */
	@Test
	public void testGetCourseUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseAccessDeniedException exception = new CourseAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getCourseUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests CourseAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final CourseAccessDeniedException exception = new CourseAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(CourseAccessDeniedException.class.getSimpleName()));
	}
}