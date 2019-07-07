/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.exceptions.notfound;

import io.github.thepieterdc.dodona.exceptions.DodonaException;

import javax.annotation.Nonnull;

/**
 * A requested resource could not be found.
 */
public abstract class ResourceNotFoundException extends DodonaException {
	private static final long serialVersionUID = 1542260234920522551L;
	
	/**
	 * ResourceNotFoundException constructor.
	 */
	ResourceNotFoundException(final String message) {
		super(message.replace(".json", ""));
	}
	
	@Override
	@Nonnull
	public abstract String toString();
}