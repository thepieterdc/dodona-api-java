/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.http;

import be.ugent.piedcler.dodona.exceptions.AuthenticationException;
import be.ugent.piedcler.dodona.impl.data.EnumDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.annotation.Nonnull;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Wrapper for http calls.
 */
public final class HttpWrapper {
	private static final String ACCEPT_HEADER = "Accept";
	private static final String ACCEPT_VALUE = "application/json";
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String CONTENT_TYPE_HEADER = "Content-Type";
	private static final String CONTENT_TYPE_VALUE = "application/json";
	private static final String USER_AGENT_HEADER = "User-Agent";
	
	private static final ObjectMapper mapper = new ObjectMapper()
		.enable(SerializationFeature.WRAP_ROOT_VALUE)
		.registerModule(new SimpleModule().setDeserializerModifier(new EnumDeserializer()));
	
	private Function<String, RuntimeException> accessDeniedHandler;
	private Function<String, RuntimeException> notFoundHandler;
	
	/**
	 * HttpWrapper constructor.
	 */
	public HttpWrapper() {
		this.accessDeniedHandler = (url) -> new RuntimeException("Access denied.");
		this.notFoundHandler = (url) -> new RuntimeException("Not found.");
	}
	
	/**
	 * Performs a HTTP GET request to the given url.
	 *
	 * @param endpoint  the endpoint to call
	 * @param apiToken  the api token
	 * @param returnCls the class of the response
	 * @return the response parsed as T
	 */
	@Nonnull
	public <T> T get(final String endpoint, final String apiToken, final String ua, final Class<T> returnCls) {
		return this.request(endpoint, apiToken, ua, connection -> {
		}, returnCls);
		
	}
	
	/**
	 * Performs a HTTP POST request to the given url.
	 *
	 * @param endpoint  the endpoint to call
	 * @param apiToken  the api token
	 * @param ua        the user agent
	 * @param body      the post body
	 * @param returnCls the class of the response
	 * @return the response parsed as T
	 */
	@Nonnull
	public <R, T> T post(final String endpoint, final String apiToken, final String ua, final R body,
	                     final Class<T> returnCls) {
		return this.request(endpoint, apiToken, ua, connection -> {
			try {
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setRequestProperty(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE);
				
				try (final OutputStream out = connection.getOutputStream()) {
					mapper.writeValue(out, body);
				}
			} catch (final IOException ex) {
				throw new RuntimeException(ex);
			}
		}, returnCls);
	}
	
	/**
	 * Performs a HTTP POST request to the given url.
	 *
	 * @param endpoint  the endpoint to call
	 * @param apiToken  the api token
	 * @param ua        the user agent
	 * @param modifier  additional modifications to the connection
	 * @param returnCls the class of the response
	 * @return the response parsed as T
	 */
	@Nonnull
	private <T> T request(final String endpoint, final String apiToken, final String ua,
	                      final Consumer<HttpsURLConnection> modifier,
	                      final Class<T> returnCls) {
		if (apiToken.isEmpty()) {
			throw new AuthenticationException(apiToken);
		}
		
		try {
			final URL url = new URL(endpoint);
			
			final HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestProperty(ACCEPT_HEADER, ACCEPT_VALUE);
			connection.setRequestProperty(AUTHORIZATION_HEADER, apiToken);
			connection.setRequestProperty(USER_AGENT_HEADER, ua);
			
			modifier.accept(connection);
			
			if (connection.getResponseCode() == StatusCode.HTTP_UNAUTHORIZED) {
				throw new AuthenticationException(apiToken);
			}
			
			if (connection.getResponseCode() == StatusCode.HTTP_FORBIDDEN) {
				throw this.accessDeniedHandler.apply(endpoint);
			}
			
			if (connection.getResponseCode() == StatusCode.HTTP_NOT_FOUND) {
				throw this.notFoundHandler.apply(endpoint);
			}
			
			return mapper.readValue(connection.getInputStream(), returnCls);
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Sets the handler for HTTP/403 errors.
	 *
	 * @param handler the handler to execute
	 * @return fluent
	 */
	@Nonnull
	public HttpWrapper setAccessDeniedHandler(final Function<String, RuntimeException> handler) {
		this.accessDeniedHandler = handler;
		return this;
	}
	
	/**
	 * Sets the handler for HTTP/404 errors.
	 *
	 * @param handler the handler to execute
	 * @return fluent
	 */
	@Nonnull
	public HttpWrapper setNotFoundHandler(final Function<String, RuntimeException> handler) {
		this.notFoundHandler = handler;
		return this;
	}
}
