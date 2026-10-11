/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.http;

import javax.annotation.Nonnull;
import java.util.Locale;

/**
 * Sends HTTP calls.
 */
public interface HttpClient {
	/**
	 * Sets the api token to include in every request.
	 *
	 * @param apiToken the api token
	 * @return fluent setter
	 */
	@Nonnull
	HttpClient authenticate(String apiToken);

	/**
	 * Performs a HTTP GET request to the given url.
	 *
	 * @param url       the url to call
	 * @param returnCls the class of the response
	 * @param <T>       type of the response
	 * @return the response parsed as T
	 */
	@Nonnull
	<T> HttpResponse<T> get(String url, Class<T> returnCls);

	/**
	 * Sets the locale to request localized responses in. This is sent both as
	 * the Accept-Language header and as the locale query parameter, as Dodona
	 * gives the latter precedence over the language stored on the user account.
	 *
	 * @param locale the locale
	 * @return fluent setter
	 */
	@Nonnull
	HttpClient locale(Locale locale);

	/**
	 * Performs a HTTP POST request to the given url.
	 *
	 * @param url       the url to call
	 * @param body      the post body
	 * @param returnCls the class of the response
	 * @param <R>       type of the request body
	 * @param <T>       type of the response
	 * @return the response parsed as T
	 */
	@Nonnull
	<R, T> HttpResponse<T> post(String url, R body, Class<T> returnCls);

	/**
	 * Sets the user agent.
	 *
	 * @param userAgent the user agent to set
	 * @return fluent setter
	 */
	@Nonnull
	HttpClient userAgent(String userAgent);
}
