/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */

package io.github.thepieterdc.dodona.exceptions;

/**
 * Marker class for all exceptions.
 */
public abstract class DodonaException extends RuntimeException {
	private static final long serialVersionUID = 8570830182829176477L;
	
	/**
	 * DodonaException constructor.
	 *
	 * @param message the exception message
	 */
	protected DodonaException(final String message) {
		super(message);
	}
}
