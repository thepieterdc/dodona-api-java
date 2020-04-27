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

/**
 * An activity that may not be accessed.
 */
public final class ActivityAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = 2651415973629085605L;
	
	private final String url;
	
	/**
	 * ActivityAccessDeniedException constructor.
	 *
	 * @param url the url of the activity that may not be accessed
	 */
	public ActivityAccessDeniedException(final String url) {
		super(String.format("You may not access the activity at url %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the activity that may not be accessed.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getActivityUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("ActivityAccessDeniedException{url=%s}", this.url);
	}
	
}
