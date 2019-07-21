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

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.stream.Stream;

/**
 * The color of a course.
 */
public enum CourseColor {
	BLUE_GREY("blue-grey", Color.decode("#607D8B")),
	BROWN("brown", Color.decode("#795548")),
	DEEP_PURPLE("deep-purple", Color.decode("#673AB7")),
	INDIGO("indigo", Color.decode("#3F51B5")),
	ORANGE("orange", Color.decode("#FF5722")),
	PINK("pink", Color.decode("#E91E63")),
	PURPLE("purple", Color.decode("#9C27B0")),
	RED("red", Color.decode("#F44336")),
	TEAL("teal", Color.decode("#009688"));
	
	private final Color color;
	private final String name;
	
	/**
	 * CourseColor constructor.
	 *
	 * @param name  the name of the color
	 * @param color the hexadecimal color
	 */
	CourseColor(final String name, final Color color) {
		this.color = color;
		this.name = name;
	}
	
	/**
	 * Finds a CourseColor given its name.
	 *
	 * @param name the name to find
	 * @return the course color to find
	 */
	public static CourseColor byName(final String name) {
		return Stream.of(CourseColor.values())
			.filter(col -> col.name.equals(name))
			.findAny()
			.orElseThrow(() -> new CourseColorNotFoundException(name));
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	@Nonnull
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Gets the name of the color.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}
