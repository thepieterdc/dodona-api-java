/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.data;

import be.ugent.piedcler.dodona.exceptions.SubmissionStatusNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

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