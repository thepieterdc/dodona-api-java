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
 * Tests be.ugent.piedcler.dodona.exceptions.notFound.ExerciseNotFoundException.
 */
public class ExerciseNotFoundExceptionTest {
	private static final Random random = new Random();
	
	/**
	 * Tests ExerciseNotFoundException#getExerciseUrl().
	 */
	@Test
	public void testGetExerciseUrl() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ExerciseNotFoundException exception = new ExerciseNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.getExerciseUrl(), is(randomcharacters));
	}
	
	/**
	 * Tests ExerciseNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final String randomcharacters = String.valueOf(random.nextLong());
		final ExerciseNotFoundException exception = new ExerciseNotFoundException(randomcharacters);
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(ExerciseNotFoundException.class.getSimpleName()));
	}
}