/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.impl.IntegrationTest;
import io.github.thepieterdc.dodona.resources.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.impl.managers.UserManagerImpl.
 */
public class UserManagerImplTest extends IntegrationTest {
	/**
	 * Tests UserManagerImpl#get(long).
	 */
	@Test
	public void testGetByIdValid() {
		final User jelix = this.zeusClient.users().get(3L);
		assertNotNull(jelix);
		assertEquals(3L, jelix.getId());
		assertEquals("Jelix", jelix.getFirstName());

		final User zeus = this.zeusClient.users().get(1L);
		assertNotNull(zeus);
		assertEquals(1L, zeus.getId());
		assertFalse(zeus.getSubscribedCourses().isEmpty());
	}
}
