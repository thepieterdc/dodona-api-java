/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.token;

import be.ugent.piedcler.dodona.exceptions.DodonaException;

import javax.annotation.Nonnull;

/**
 * An exception occurred because of the used API token.
 */
public abstract class ApiTokenException extends DodonaException {
	private static final long serialVersionUID = 2685303628741503240L;
	
	/**
	 * ApiTokenException constructor.
	 */
	ApiTokenException(final String message) {
		super(message);
	}
	
	@Override
	@Nonnull
	public abstract String toString();
}
