/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.accessdenied;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A course that may not be accessed.
 */
public final class CourseAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = -1181457174387507111L;

	private final String url;

	/**
	 * CourseAccessDeniedException constructor.
	 *
	 * @param url the url of the course that may not be accessed
	 */
	public CourseAccessDeniedException(final String url, final @Nullable String reason) {
		super(reason != null ? reason : String.format("You may not access the course at url %s.", url));
		this.url = url;
	}

	/**
	 * Gets the url of the course that may not be accessed.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getCourseUrl() {
		return this.url;
	}

	@Override
	@Nonnull
	public String toString() {
		return String.format("CourseAccessDeniedException{url=%s}", this.url);
	}

}
