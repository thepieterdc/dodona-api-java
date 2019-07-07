/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import io.github.thepieterdc.dodona.exceptions.CourseColorNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Tests be.ugent.piedcler.dodona.data.CourseColor.
 */
public class CourseColorTest {
	/**
	 * Tests CourseColor.byName(String) using the color name.
	 */
	@Test
	public void testByName() {
		Arrays.stream(CourseColor.values()).forEach(color -> {
			final CourseColor byName = CourseColor.byName(color.getName());
			Assert.assertNotNull(byName);
			Assert.assertEquals(color, byName);
		});
	}
	
	/**
	 * Tests CourseColor.byName(String) using a non-existing color.
	 */
	@Test(expected = CourseColorNotFoundException.class)
	public void testByNameNonExisting() {
		CourseColor.byName("non-existing-color");
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
		
		Assert.assertNotNull(colors);
		Assert.assertEquals(amount, colors.size());
		colors.forEach(Assert::assertNotNull);
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
		
		Assert.assertNotNull(names);
		Assert.assertEquals(amount, names.size());
		names.forEach(Assert::assertNotNull);
	}
}