/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl;

import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * Tests io.github.thepieterdc.dodona.impl.DodonaClientImpl.
 */
public class DodonaClientImplTest extends IntegrationTest {
	/**
	 * Tests: DodonaClientImpl#deadlines().
	 */
	@Test
	public void testDeadlines() {
		final Collection<Series> deadlines = this.studentClient.deadlines();
		Assert.assertNotNull(deadlines);
		Assert.assertTrue(deadlines.isEmpty());
	}
	
	/**
	 * Tests: DodonaClientImpl#getMe().
	 */
	@Test
	public void testMe() {
		final User me = this.studentClient.me();
		Assert.assertNotNull(me);
		Assert.assertEquals(3L, me.getId());
		Assert.assertEquals("Jelix", me.getFirstName());
		Assert.assertEquals("Vanderfeught", me.getLastName());
	}
}