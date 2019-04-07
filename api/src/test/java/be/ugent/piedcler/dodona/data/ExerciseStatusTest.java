/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests be.ugent.piedcler.dodona.data.ExerciseStatus.
 */
public class ExerciseStatusTest {
	/**
	 * Tests ExerciseStatus.fromValues(boolean, boolean, boolean) using the status name.
	 */
	@Test
	public void testFromValues() {
		Assert.assertEquals(ExerciseStatus.CORRECT, ExerciseStatus.fromValues(true, true, true));
		Assert.assertEquals(ExerciseStatus.INCORRECT, ExerciseStatus.fromValues(false, true, true));
	}
}