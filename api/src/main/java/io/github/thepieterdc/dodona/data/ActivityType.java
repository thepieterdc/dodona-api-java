/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

/**
 * The type of an activity.
 */
public enum ActivityType {
	/**
	 * A reading activity.
	 */
	CONTENT_PAGE("ContentPage"),
	/**
	 * An exercise.
	 */
	EXERCISE("Exercise");
	
	public static final String CONTENT_PAGE_TYPE = "ContentPage";
	public static final String EXERCISE_TYPE = "Exercise";
	
	private final String type;
	
	/**
	 * ActivityType constructor.
	 *
	 * @param type the type
	 */
	ActivityType(final String type) {
		this.type = type;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}
}
