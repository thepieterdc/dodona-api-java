/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests io.github.thepieterdc.dodona.data.ActivityType.
 */
public class ActivityTypeTest {
	/**
	 * Tests ActivityType#getType().
	 */
	@Test
	public void testGetType() {
		assertEquals(ActivityType.CONTENT_PAGE_TYPE, ActivityType.CONTENT_PAGE.getType());
		assertEquals(ActivityType.EXERCISE_TYPE, ActivityType.EXERCISE.getType());
	}
}
