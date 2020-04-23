/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Tests io.github.thepieterdc.dodona.data.SubmissionStatus.
 */
public class SubmissionStatusTest {
	/**
	 * Tests SubmissionStatus.byName(String) using the status name.
	 */
	@Test
	public void testByName() {
		Arrays.stream(SubmissionStatus.values()).forEach(status -> {
			final SubmissionStatus byName = SubmissionStatus.byName(status.getName());
			Assert.assertNotNull(byName);
			Assert.assertEquals(byName, status);
		});
	}
	
	/**
	 * Tests SubmissionStatus.byName(String) using a non-existing status.
	 */
	public void testByNameNonExisting() {
		final SubmissionStatus nonExisting = SubmissionStatus.byName("non-existing-status");
		Assert.assertEquals(SubmissionStatus.UNKNOWN, nonExisting);
	}
	
	/**
	 * Tests SubmissionStatus#getName().
	 */
	@Test
	public void testGetName() {
		final int amount = SubmissionStatus.values().length;
		
		final Collection<String> names = Arrays.stream(SubmissionStatus.values())
			.map(SubmissionStatus::getName)
			.collect(Collectors.toSet());
		
		Assert.assertThat(names, notNullValue());
		names.forEach(Assert::assertNotNull);
		Assert.assertThat(names.size(), is(amount));
	}
}