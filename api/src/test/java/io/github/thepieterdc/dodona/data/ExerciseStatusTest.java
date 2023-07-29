/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests io.github.thepieterdc.dodona.data.ExerciseStatus.
 */
public class ExerciseStatusTest {
	/**
	 * Tests ExerciseStatus.fromValues(boolean, boolean, boolean) using the status name.
	 */
	@Test
	public void testFromValues() {
		assertEquals(ExerciseStatus.CORRECT, ExerciseStatus.fromValues(true, true, true));
		assertEquals(ExerciseStatus.HAS_BEEN_CORRECT, ExerciseStatus.fromValues(true, true, false));
		assertEquals(ExerciseStatus.INCORRECT, ExerciseStatus.fromValues(false, true, true));
		assertEquals(ExerciseStatus.INCORRECT, ExerciseStatus.fromValues(false, true, false));
		assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(true, false, true));
		assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(true, false, false));
		assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(false, false, true));
		assertEquals(ExerciseStatus.NOT_ATTEMPTED, ExerciseStatus.fromValues(false, false, false));
	}
}
