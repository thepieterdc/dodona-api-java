/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.token;

import be.ugent.piedcler.dodona.exceptions.accessdenied.CourseAccessDeniedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.token.ApiTokenNotSetException.
 */
public class ApiTokenNotSetExceptionTest {
	/**
	 * Tests ApiTokenNotSetException#toString().
	 */
	@Test
	public void testToString() {
		final ApiTokenNotSetException exception = new ApiTokenNotSetException();
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(ApiTokenNotSetException.class.getSimpleName()));
	}
}