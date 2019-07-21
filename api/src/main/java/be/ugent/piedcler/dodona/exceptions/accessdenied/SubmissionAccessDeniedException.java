/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import javax.annotation.Nonnull;

/**
 * A submission that may not be accessed.
 */
public final class SubmissionAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = -7786597404979494205L;
	
	private final String url;
	
	/**
	 * SubmissionAccessDeniedException constructor.
	 *
	 * @param url the url of the submission that may not be accessed
	 */
	public SubmissionAccessDeniedException(final String url) {
		super(String.format("You may not access the submission at url %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the submission that may not be accessed.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getSubmissionUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("SubmissionAccessDeniedException{url=%s}", this.url);
	}
	
}
