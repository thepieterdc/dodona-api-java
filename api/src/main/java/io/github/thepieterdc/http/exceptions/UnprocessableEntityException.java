/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.http.exceptions;

import io.github.thepieterdc.dodona.exceptions.DodonaException;

/**
 * A requested resource may not be accessed.
 */
public final class UnprocessableEntityException extends DodonaException {
	private static final long serialVersionUID = -2066370516837975536L;
	
	/**
	 * UnprocessableEntityException constructor.
	 */
	public UnprocessableEntityException(final String message) {
		super(message);
	}
}
