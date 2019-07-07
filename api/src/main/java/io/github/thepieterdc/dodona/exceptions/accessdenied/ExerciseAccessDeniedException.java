/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.accessdenied;

import javax.annotation.Nonnull;

/**
 * A exercise that may not be accessed.
 */
public final class ExerciseAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = 2651415973629085605L;
	
	private final String url;
	
	/**
	 * ExerciseAccessDeniedException constructor.
	 *
	 * @param url the url of the exercise that may not be accessed
	 */
	public ExerciseAccessDeniedException(final String url) {
		super(String.format("You may not access the exercise at url %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the exercise that may not be accessed.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getExerciseUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("ExerciseAccessDeniedException{url=%s}", this.url);
	}
	
}
