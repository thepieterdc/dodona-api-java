/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.exceptions.notfound;

import javax.annotation.Nonnull;

/**
 * The root can not be found. This exception should normally never be thrown.
 */
public final class RootNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = 9122563357642441749L;
	
	/**
	 * RootNotFoundException constructor.
	 */
	public RootNotFoundException() {
		super("The root could not be queried. You should never receive this error, please report this.");
	}
	
	@Override
	@Nonnull
	public String toString() {
		return "RootNotFoundException{}";
	}
}