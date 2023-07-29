/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.notfound;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.notFound.RootNotFoundException.
 */
public class RootNotFoundExceptionTest {
	/**
	 * Tests RootNotFoundException#toString().
	 */
	@Test
	public void testToString() {
		final RootNotFoundException exception = new RootNotFoundException();
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(RootNotFoundException.class.getSimpleName()));
	}
}
