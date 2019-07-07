/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import io.github.thepieterdc.dodona.exceptions.SubmissionStatusNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Tests be.ugent.piedcler.dodona.data.SubmissionStatus.
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
			Assert.assertEquals(status, byName);
		});
	}
	
	/**
	 * Tests SubmissionStatus.byName(String) using a non-existing color.
	 */
	@Test(expected = SubmissionStatusNotFoundException.class)
	public void testByNameNonExisting() {
		SubmissionStatus.byName("non-existing-status");
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
		
		Assert.assertNotNull(names);
		Assert.assertEquals(amount, names.size());
		names.forEach(Assert::assertNotNull);
	}
}