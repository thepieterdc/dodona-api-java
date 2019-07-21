/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.DodonaClient;
import io.github.thepieterdc.dodona.exceptions.accessdenied.UserAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.UserNotFoundException;
import io.github.thepieterdc.dodona.impl.http.HttpWrapper;
import io.github.thepieterdc.dodona.impl.resources.UserImpl;
import io.github.thepieterdc.dodona.managers.UserManager;
import io.github.thepieterdc.dodona.resources.User;

import javax.annotation.Nonnull;

/**
 * Implementation of UserManager.
 */
public class UserManagerImpl implements UserManager {
	private static final String ENDPOINT_USERS = "/users/%d";
	
	private static final HttpWrapper http = new HttpWrapper()
		.setAccessDeniedHandler(UserAccessDeniedException::new)
		.setNotFoundHandler(UserNotFoundException::new);
	
	private final DodonaClient client;
	
	/**
	 * UserManager implementation.
	 *
	 * @param client client
	 */
	public UserManagerImpl(final DodonaClient client) {
		this.client = client;
	}
	
	@Override
	@Nonnull
	public User get(final long id) {
		return this.get(this.client.getHost() + String.format(ENDPOINT_USERS, id));
	}
	
	@Override
	@Nonnull
	public User get(final String url) {
		return http.get(url, this.client.getApiToken(), this.client.getUserAgent(), UserImpl.class);
	}
}
