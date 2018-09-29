/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import javax.annotation.Nonnull;

/**
 * A user that may not be accessed.
 */
public final class UserAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = -3860301633730107420L;
	
	private final String url;
	
	/**
	 * UserAccessDeniedException constructor.
	 *
	 * @param url the url of the user that may not be accessed
	 */
	public UserAccessDeniedException(final String url) {
		super(String.format("You may not access the user at url %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the user that may not be accessed.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getUserUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("UserAccessDeniedException{url=%s}", this.url);
	}
	
}
