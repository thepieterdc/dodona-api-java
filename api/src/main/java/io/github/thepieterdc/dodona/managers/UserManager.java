/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.User;

import javax.annotation.Nonnull;

/**
 * Manager for users.
 */
public interface UserManager extends ResourceManager<User> {
	/**
	 * Gets the user with the given id.
	 *
	 * @param id the id of the user
	 * @return the user
	 */
	@Nonnull
	User get(long id);
}
