/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.exceptions;

import javax.annotation.Nonnull;

/**
 * A required course color was not found.
 */
public final class CourseColorNotFoundException extends DodonaException {
	private static final long serialVersionUID = -4335785034385436696L;
	
	private final String color;
	
	/**
	 * CourseColorNotFoundException constructor.
	 *
	 * @param color the name of the color that was not found
	 */
	public CourseColorNotFoundException(final String color) {
		super(String.format("No color was found for \"%s\".", color));
		this.color = color;
	}
	
	/**
	 * Gets the name of the color that was not found.
	 *
	 * @return the color
	 */
	@Nonnull
	public String getColor() {
		return this.color;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("CourseColorNotFoundException{color=%s}", this.color);
	}
}
