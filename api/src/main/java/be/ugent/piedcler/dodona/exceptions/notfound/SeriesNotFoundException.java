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
 * A series that can not be found.
 */
public final class SeriesNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = 5273010323095798802L;
	
	private final String url;
	
	/**
	 * SeriesNotFoundException constructor.
	 *
	 * @param url the url of the series that was not found
	 */
	public SeriesNotFoundException(final String url) {
		super(String.format("No series was found at the given url: %s.", url));
		this.url = url;
	}
	
	/**
	 * Gets the url of the series that can not be found.
	 *
	 * @return the url
	 */
	public String getSeriesUrl() {
		return this.url;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("SeriesNotFoundException{url=%s}", this.url);
	}
}