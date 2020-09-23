/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.exceptions;

import javax.annotation.Nonnull;

/**
 * A required series visibility was not found.
 */
public final class SeriesVisibilityNotFoundException extends DodonaException {
	private static final long serialVersionUID = -4569955034385436696L;
	
	private final String visibility;
	
	/**
	 * SeriesVisibilityNotFoundException constructor.
	 *
	 * @param visibility the name of the visibility that was not found
	 */
	public SeriesVisibilityNotFoundException(final String visibility) {
		super(String.format("No visibility was found for \"%s\".", visibility));
		this.visibility = visibility;
	}
	
	/**
	 * Gets the name of the visibility that was not found.
	 *
	 * @return the visibility
	 */
	@Nonnull
	public String getVisibility() {
		return this.visibility;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("SeriesVisibilityNotFoundException{visibility=%s}", this.visibility);
	}
}
