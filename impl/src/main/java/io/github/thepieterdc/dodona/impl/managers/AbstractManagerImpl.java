/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.exceptions.accessdenied.ResourceAccessDeniedException;
import io.github.thepieterdc.dodona.exceptions.notfound.ResourceNotFoundException;
import io.github.thepieterdc.dodona.managers.ResourceManager;
import io.github.thepieterdc.dodona.resources.Resource;
import io.github.thepieterdc.http.HttpClient;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * Abstract implementation of a ResourceManager.
 *
 * @param <T> type class of the resource
 */
public abstract class AbstractManagerImpl<T extends Resource> implements ResourceManager<T> {
	private final String host;
	final HttpClient http;
	private final Class<? extends T> impl;
	
	private final Function<String, ResourceAccessDeniedException> forbidden;
	private final Function<String, ResourceNotFoundException> notFound;
	
	/**
	 * AbstractManagerImpl constructor.
	 *
	 * @param host      the host
	 * @param http      the http client
	 * @param impl      resource implementation
	 * @param forbidden 403 exception
	 * @param notFound  404 exception
	 */
	AbstractManagerImpl(final String host, final HttpClient http,
	                    final Class<? extends T> impl,
	                    final Function<String, ResourceAccessDeniedException> forbidden,
	                    final Function<String, ResourceNotFoundException> notFound) {
		this.forbidden = forbidden;
		this.host = host;
		this.http = http;
		this.impl = impl;
		this.notFound = notFound;
	}
	
	/**
	 * Gets a custom response.
	 *
	 * @param url the url to get
	 * @param cls the class of the response
	 * @param <R> the type of the response
	 * @return the resolved response
	 */
	@Nonnull
	<R> R get(final String url, final Class<R> cls) {
		return this.http.get(url, cls)
			.forbidden(this.forbidden.apply(url))
			.notFound(this.notFound.apply(url))
			.resolve();
	}
	
	@Override
	@Nonnull
	public T get(final String url) {
		return this.get(url, this.impl);
	}
	
	/**
	 * Prepends the host to the given endpoint.
	 *
	 * @param endpoint the endpoint
	 * @return the complete url
	 */
	@Nonnull
	String url(final String endpoint) {
		return this.host + endpoint;
	}
}
