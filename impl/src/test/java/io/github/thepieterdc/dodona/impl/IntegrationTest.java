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
import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.thepieterdc.random.numerical.RandomLongGenerator.above;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class IntegrationTest {
	protected static final RandomLongGenerator fakeIds = above(1_000_000L);

	protected DodonaClient guestClient;
	protected DodonaClient studentClient;
	protected DodonaClient zeusClient;

	/**
	 * Set-up the test environment.
	 */
	@BeforeEach
	public void setUp() {
		this.guestClient = DodonaBuilder.builder()
			.setHost("http://localhost:3000")
			.setUserAgent("Integration Test - Guest")
			.build();
		this.studentClient = DodonaBuilder.builder()
			.setHost("http://localhost:3000")
			.setUserAgent("Integration Test - Student")
			.authenticate("student")
			.build();
		this.zeusClient = DodonaBuilder.builder()
			.setHost("http://localhost:3000")
			.setUserAgent("Integration Test - Zeus")
			.authenticate("zeus")
			.build();
	}

	/**
	 * Tear-down the test environment.
	 */
	@AfterEach
	public void tearDown() {
		this.guestClient = null;
		this.studentClient = null;
		this.zeusClient = null;
	}

	/**
	 * Tests whether the clients are valid.
	 */
	@Test
	public void testClients() {
		assertNotNull(this.guestClient);
		assertNotNull(this.studentClient);
		assertNotNull(this.zeusClient);
	}
}
