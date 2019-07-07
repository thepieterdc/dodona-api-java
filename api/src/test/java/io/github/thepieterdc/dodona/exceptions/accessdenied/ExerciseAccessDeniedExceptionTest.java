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
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.ExerciseAccessDeniedException.
 */
public class ExerciseAccessDeniedExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests ExerciseAccessDeniedException#getExerciseUrl().
	 */
	@Test
	public void testGetExerciseUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ExerciseAccessDeniedException exception = new ExerciseAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getExerciseUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests ExerciseAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ExerciseAccessDeniedException exception = new ExerciseAccessDeniedException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(ExerciseAccessDeniedException.class.getSimpleName()));
	}
}