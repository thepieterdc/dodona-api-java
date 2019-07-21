/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.notfound;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.notFound.RootNotFoundException.
 */
public class RootNotFoundExceptionTest {
	/**
	 * Tests RootNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final RootNotFoundException exception = new RootNotFoundException();
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(RootNotFoundException.class.getSimpleName()));
	}
}