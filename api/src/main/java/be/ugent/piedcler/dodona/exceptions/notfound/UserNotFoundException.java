/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.exceptions.notfound;

import javax.annotation.Nonnull;

/**
 * A user that can not be found.
 */
public final class UserNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -5657758818250445087L;
	
	private final String url;
	
	/**
	 * UserNotFoundException constructor.
	 *
	 * @param url the url of the user that was not found
	 */
	public UserNotFoundException(final String url) {
		super(String.format("No user was found at the given url: %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the user that can not be found.
	 *
	 * @return the url
	 */
	public String getUserUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("UserNotFoundException{url=%s}", this.url);
	}
}