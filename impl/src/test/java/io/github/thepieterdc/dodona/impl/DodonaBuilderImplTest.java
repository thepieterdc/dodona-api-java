/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl;

import io.github.thepieterdc.dodona.DodonaBuilder;
import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.impl.resources.UserImpl;
import io.github.thepieterdc.dodona.impl.resources.UserImplTest;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.http.HttpClient;
import io.github.thepieterdc.http.impl.HttpResponseImplTest;
import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests io.github.thepieterdc.dodona.impl.DodonaBuilderImpl.
 */
public class DodonaBuilderImplTest {
	private static final RandomLongGenerator userIds = RandomLongGenerator.between(1L, 1000L);
	
	/**
	 * Tests DodonaBuilderImpl#setHttpClient().
	 */
	@Test
	public void testSetHttpClient() {
		// Create a user.
		final long uid = userIds.generate();
		final UserImpl user = UserImplTest.random(uid);
		Assert.assertNotNull(user);
		
		// Mock the http client.
		final HttpClient http = mock(HttpClient.class);
		when(http.authenticate(anyString())).thenReturn(http);
		when(http.userAgent(anyString())).thenReturn(http);
		when(http.get(anyString(), eq(UserImpl.class))).thenReturn(
			HttpResponseImplTest.wrap(user)
		);
		
		final DodonaClient custom = DodonaBuilder.builder()
			.setHttpClient(http)
			.build();
		Assert.assertNotNull(custom);
		
		// Fetch the user profile.
		final User result = custom.users().get(uid);
		Assert.assertNotNull(result);
		Assert.assertEquals(user, result);
	}
}