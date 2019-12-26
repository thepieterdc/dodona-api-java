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
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Tests io.github.thepieterdc.dodona.impl.managers.SeriesManagerImpl.
 */
public class SeriesManagerImplTest extends IntegrationTest {
	/**
	 * Tests SeriesManagerImpl#getAll(Course).
	 */
	@Test
	public void testGetAll() {
		final Course first = this.zeusClient.courses().get(1L);
		Assert.assertNotNull(first);
		
		final List<Series> series = this.zeusClient.series().getAll(first);
		Assert.assertNotNull(series);
		Assert.assertFalse(series.isEmpty());
	}
}