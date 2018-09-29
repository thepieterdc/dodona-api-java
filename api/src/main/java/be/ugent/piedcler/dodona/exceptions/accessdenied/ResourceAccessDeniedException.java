/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import be.ugent.piedcler.dodona.exceptions.DodonaException;

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
