/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.exceptions.notfound;

import javax.annotation.Nonnull;

/**
 * A exercise that can not be found.
 */
public final class ExerciseNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -7563952852777465712L;
	
	private final String url;
	
	/**
	 * ExerciseNotFoundException constructor.
	 *
	 * @param url the url of the exercise that was not found
	 */
	public ExerciseNotFoundException(final String url) {
		super(String.format("No exercise was found at the given url: %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the exercise that can not be found.
	 *
	 * @return the url
	 */
	public String getExerciseUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("ExerciseNotFoundException{url=%s}", this.url);
	}
}