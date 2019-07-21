/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.data;

import be.ugent.piedcler.dodona.exceptions.CourseColorNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

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
			Assert.assertThat(byName, notNullValue());
			Assert.assertThat(byName, is(color));
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
		
		Assert.assertThat(colors, notNullValue());
		colors.forEach(Assert::assertNotNull);
		Assert.assertThat(colors.size(), is(amount));
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
		
		Assert.assertThat(names, notNullValue());
		names.forEach(Assert::assertNotNull);
		Assert.assertThat(names.size(), is(amount));
	}
}