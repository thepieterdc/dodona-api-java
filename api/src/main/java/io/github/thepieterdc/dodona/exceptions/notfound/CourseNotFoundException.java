/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.exceptions.notfound;

import javax.annotation.Nonnull;

/**
 * A course that can not be found.
 */
public final class CourseNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -3355820962747777048L;
	
	private final String url;
	
	/**
	 * CourseNotFoundException constructor.
	 *
	 * @param url the url of the course that was not found
	 */
	public CourseNotFoundException(final String url) {
		super(String.format("No course was found at the given url: %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the course that can not be found.
	 *
	 * @return the url
	 */
	public String getCourseUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("CourseNotFoundException{url=%s}", this.url);
	}
}