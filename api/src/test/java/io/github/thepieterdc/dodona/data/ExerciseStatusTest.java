/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests io.github.thepieterdc.dodona.data.ExerciseStatus.
 */
public class ExerciseStatusTest {
	/**
	 * Tests ExerciseStatus.fromValues(boolean, boolean, boolean) using the status name.
	 */
	@Test
	public void testFromValues() {
		Assert.assertEquals(ExerciseStatus.CORRECT, ExerciseStatus.fromValues(true, true, true));
		Assert.assertEquals(ExerciseStatus.HAS_BEEN_CORRECT, ExerciseStatus.fromValues(true, true, false));
		Assert.assertEquals(ExerciseStatus.INCORRECT, ExerciseStatus.fromValues(false, true, true));
		Assert.assertEquals(ExerciseStatus.INCORRECT, ExerciseStatus.fromValues(false, true, false));
		Assert.assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(true, false, true));
		Assert.assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(true, false, false));
		Assert.assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(false, false, true));
		Assert.assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(false, false, false));
	}
}