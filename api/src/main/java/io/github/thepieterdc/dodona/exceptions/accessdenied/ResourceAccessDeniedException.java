/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.exceptions.accessdenied;

import io.github.thepieterdc.dodona.exceptions.DodonaException;

import javax.annotation.Nonnull;

/**
 * A requested resource may not be accessed.
 */
public abstract class ResourceAccessDeniedException extends DodonaException {
	private static final long serialVersionUID = 4889624262213829194L;
	
	/**
	 * ResourceAccessDeniedException constructor.
	 */
	ResourceAccessDeniedException(final String message) {
		super(message.replace(".json", ""));
	}
	
	@Override
	@Nonnull
	public abstract String toString();
}
