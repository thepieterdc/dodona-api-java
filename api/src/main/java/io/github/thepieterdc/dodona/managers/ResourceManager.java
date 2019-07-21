/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.Resource;

import javax.annotation.Nonnull;

/**
 * Manager for resources
 *
 * @param <R> type class of the resource
 */
@FunctionalInterface
public interface ResourceManager<R extends Resource> {
	/**
	 * Gets the resource at the given url.
	 *
	 * @param url the url
	 * @return the resource
	 */
	@Nonnull
	R get(String url);
}
