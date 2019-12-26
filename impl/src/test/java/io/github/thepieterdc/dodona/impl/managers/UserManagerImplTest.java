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
import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertNotNull(jelix);
		Assert.assertEquals(3L, jelix.getId());
		Assert.assertEquals("Jelix", jelix.getFirstName());
		
		final User zeus = this.zeusClient.users().get(1L);
		Assert.assertNotNull(zeus);
		Assert.assertEquals(1L, zeus.getId());
		Assert.assertFalse(zeus.getSubscribedCourses().isEmpty());
	}
}