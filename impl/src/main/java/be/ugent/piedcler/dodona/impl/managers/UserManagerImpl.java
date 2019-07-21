/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.managers;

import be.ugent.piedcler.dodona.DodonaClient;
import be.ugent.piedcler.dodona.exceptions.accessdenied.UserAccessDeniedException;
import be.ugent.piedcler.dodona.exceptions.notfound.UserNotFoundException;
import be.ugent.piedcler.dodona.impl.http.HttpWrapper;
import be.ugent.piedcler.dodona.impl.resources.UserImpl;
import be.ugent.piedcler.dodona.managers.UserManager;
import be.ugent.piedcler.dodona.resources.User;

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
