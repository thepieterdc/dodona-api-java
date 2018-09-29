/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.managers;

import be.ugent.piedcler.dodona.resources.User;

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
