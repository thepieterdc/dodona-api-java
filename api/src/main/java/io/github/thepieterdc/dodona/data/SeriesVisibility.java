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
import io.github.thepieterdc.dodona.exceptions.SeriesVisibilityNotFoundException;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.stream.Stream;

/**
 * The visibility status of a series.
 */
public enum SeriesVisibility {
	CLOSED("closed"),
	HIDDEN("hidden"),
	OPEN("open");
	
	private final String name;
	
	/**
	 * SeriesVisibility constructor.
	 *
	 * @param name the name of the visiblity status
	 */
	SeriesVisibility(final String name) {
		this.name = name;
	}
	
	/**
	 * Finds a SeriesVisibility given its name.
	 *
	 * @param name the name to find
	 * @return the course color to find
	 */
	public static SeriesVisibility byName(final String name) {
		return Stream.of(SeriesVisibility.values())
			.filter(visibility -> visibility.name.equals(name))
			.findAny()
			.orElseThrow(() -> new SeriesVisibilityNotFoundException(name));
	}
	
	/**
	 * Gets the name of the visibility status.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}
