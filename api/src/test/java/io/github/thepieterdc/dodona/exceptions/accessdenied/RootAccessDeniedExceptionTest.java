/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.accessdenied;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests io.github.thepieterdc.dodona.exceptions.accessdenied.RootAccessDeniedException.
 */
public class RootAccessDeniedExceptionTest {
	/**
	 * Tests RootAccessDeniedException#toString().
	 */
	@Test
	public void testToString() {
		final RootAccessDeniedException exception = new RootAccessDeniedException();
		assertNotNull(exception);
		assertNotNull(exception.toString());
		assertTrue(exception.toString().contains(RootAccessDeniedException.class.getSimpleName()));
	}
}
