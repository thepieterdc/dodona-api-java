/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl.resources;

import io.github.thepieterdc.dodona.impl.IntegrationTest;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.random.numerical.RandomLongGenerator;
import io.github.thepieterdc.random.textual.RandomStringGenerator;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.util.Collections;

import static io.github.thepieterdc.random.numerical.RandomLongGenerator.between;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests io.github.thepieterdc.dodona.impl.UserImpl.
 */
public class UserImplTest extends IntegrationTest {
	private static final RandomLongGenerator correctExercises = between(0L, 200L);
	private static final RandomStringGenerator strings = new RandomStringGenerator(10);
	private static final RandomLongGenerator submissionCounts = between(0L, 5000L);

	/**
	 * Creates a random user with a given uid.
	 *
	 * @param uid the id of the user
	 * @return the user
	 */
	@Nonnull
	public static UserImpl random(long uid) {
		final String first = strings.generate();
		final String last = strings.generate();
		return new UserImpl(
			correctExercises.generate(),
			String.format("%s.%s@ugent.be", first, last),
			first,
			uid,
			last,
			submissionCounts.generate(),
			strings.generate(),
			Collections.emptyList(),
			strings.generate()
		);
	}

	/**
	 * Tests UserImpl#getUrl().
	 */
	@Test
	public void testGetUrl() {
		final User user = this.zeusClient.me();
		assertNotNull(user);
		assertFalse(user.getUrl().contains("json"));
	}
}
