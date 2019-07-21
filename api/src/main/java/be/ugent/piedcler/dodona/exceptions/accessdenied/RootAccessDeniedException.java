/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import javax.annotation.Nonnull;

/**
 * The root may not be accessed. This exception should normally never be thrown.
 */
public final class RootAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = -2002665274643743129L;
	
	/**
	 * RootAccessDeniedException constructor.
	 */
	public RootAccessDeniedException() {
		super("The root could not be queried. You should never receive this error, please report this.");
	}
	
	@Override
	@Nonnull
	public String toString() {
		return "RootAccessDeniedException{}";
	}
	
}
