/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.resources;

import javax.annotation.Nonnull;

/**
 * A resource on Dodona.
 */
public interface Resource {
	/**
	 * Gets the id of this resource.
	 *
	 * @return the id
	 */
	long getId();
	
	/**
	 * Gets the url of this resource.
	 *
	 * @return the url
	 */
	@Nonnull
	String getUrl();
}
