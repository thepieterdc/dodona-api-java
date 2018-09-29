/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.exceptions.accessdenied;

import javax.annotation.Nonnull;

/**
 * A series that may not be accessed.
 */
public final class SeriesAccessDeniedException extends ResourceAccessDeniedException {
	private static final long serialVersionUID = -8938590537905268890L;
	
	private final String url;
	
	/**
	 * SeriesAccessDeniedException constructor.
	 *
	 * @param url the url of the series that may not be accessed
	 */
	public SeriesAccessDeniedException(final String url) {
		super(String.format("You may not access the series at url %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the series that may not be accessed.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getSeriesUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("SeriesAccessDeniedException{url=%s}", this.url);
	}
	
}
