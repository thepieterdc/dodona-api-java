/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests be.ugent.piedcler.dodona.exceptions.accessdenied.RootAccessDeniedException.
 */
public class RootAccessDeniedExceptionTest {
	/**
	 * Tests RootAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final RootAccessDeniedException exception = new RootAccessDeniedException();
		Assert.assertThat(exception, notNullValue());
		Assert.assertThat(exception.toString(), notNullValue());
		Assert.assertThat(exception.toString(), containsString(RootAccessDeniedException.class.getSimpleName()));
	}
}