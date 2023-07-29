/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import io.github.thepieterdc.dodona.exceptions.CourseColorNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.data.CourseColor.
 */
public class CourseColorTest {
	/**
	 * Tests CourseColor.byName(String) using the color name.
	 */
	@Test
	public void testByName() {
		Arrays.stream(CourseColor.values()).forEach(color -> {
			final CourseColor byName = CourseColor.byName(color.getName());
			assertNotNull(byName);
			assertEquals(byName, color);
		});
	}

	/**
	 * Tests CourseColor.byName(String) using a non-existing color.
	 */
	@Test
	public void testByNameNonExisting() {
		assertThrows(CourseColorNotFoundException.class, () ->
			CourseColor.byName("non-existing-color")
		);
	}

	/**
	 * Tests CourseColor#getColor().
	 */
	@Test
	public void testGetColor() {
		final int amount = CourseColor.values().length;

		final Collection<Color> colors = Arrays.stream(CourseColor.values())
			.map(CourseColor::getColor)
			.collect(Collectors.toSet());

		assertNotNull(colors);
		colors.forEach(Assertions::assertNotNull);
		assertEquals(amount, colors.size());
	}

	/**
	 * Tests CourseColor#getName().
	 */
	@Test
	public void testGetName() {
		final int amount = CourseColor.values().length;

		final Collection<String> names = Arrays.stream(CourseColor.values())
			.map(CourseColor::getName)
			.collect(Collectors.toSet());

		assertNotNull(names);
		names.forEach(Assertions::assertNotNull);
		assertEquals(amount, names.size());
	}
}
