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
 * A submission that can not be found.
 */
public final class SubmissionNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -5007531677210087562L;
	
	private final String url;
	
	/**
	 * SubmissionNotFoundException constructor.
	 *
	 * @param url the url of the submission that was not found
	 */
	public SubmissionNotFoundException(final String url) {
		super(String.format("No submission was found at the given url: %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the submission that can not be found.
	 *
	 * @return the url
	 */
	public String getSubmissionUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("SubmissionNotFoundException{url=%s}", this.url);
	}
}