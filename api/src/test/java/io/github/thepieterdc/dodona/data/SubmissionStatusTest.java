/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
			assertNotNull(byName);
			assertEquals(byName, status);
		});
	}

	/**
	 * Tests SubmissionStatus.byName(String) using a non-existing status.
	 */
	@Test
	public void testByNameNonExisting() {
		final SubmissionStatus nonExisting = SubmissionStatus.byName("non-existing-status");
		assertEquals(SubmissionStatus.UNKNOWN, nonExisting);
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

		assertNotNull(names);
		names.forEach(Assertions::assertNotNull);
		assertEquals(amount, names.size());
	}
}
