/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.exceptions.accessdenied.UserAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.UserNotFoundException;
import io.github.thepieterdc.dodona.impl.resources.UserImpl;
import io.github.thepieterdc.dodona.managers.UserManager;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;

/**
 * Implementation of UserManager.
 */
public final class UserManagerImpl extends AbstractManagerImpl<User> implements UserManager {
	private static final String ENDPOINT_USERS = "/users/%d";
	
	/**
	 * UserManagerImpl constructor.
	 *
	 * @param host the host
	 * @param http the http client
	 */
	public UserManagerImpl(final String host, final HttpClient http) {
		super(host, http, UserImpl.class, UserAccessDeniedException::new, UserNotFoundException::new);
	}
	
	@Override
	@Nonnull
	public User get(final long id) {
		return this.get(this.url(String.format(ENDPOINT_USERS, id)));
	}
}
