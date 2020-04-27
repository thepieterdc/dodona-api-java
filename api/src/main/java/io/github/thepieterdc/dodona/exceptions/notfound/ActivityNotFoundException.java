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
 * A activity that can not be found.
 */
public final class ActivityNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -7563952852777465712L;
	
	private final String url;
	
	/**
	 * ActivityNotFoundException constructor.
	 *
	 * @param url the url of the activity that was not found
	 */
	public ActivityNotFoundException(final String url) {
		super(String.format("No activity was found at the given url: %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the activity that can not be found.
	 *
	 * @return the url
	 */
	public String getActivityUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("ActivityNotFoundException{url=%s}", this.url);
	}
}