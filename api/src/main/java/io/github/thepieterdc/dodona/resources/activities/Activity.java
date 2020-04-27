/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources.activities;

import io.github.thepieterdc.dodona.data.ActivityType;
import io.github.thepieterdc.dodona.resources.Resource;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An activity on Dodona.
 */
public interface Activity extends Resource {
	/**
	 * Gets the format of the activity description.
	 *
	 * @return the format of the activity description
	 */
	@Nonnull
	String getDescriptionFormat();
	
	/**
	 * Gets the description url.
	 *
	 * @return the activity description
	 */
	@Nonnull
	String getDescriptionUrl();
	
	/**
	 * Parses the id of an activity from the url.
	 *
	 * @param url the url to the activity
	 * @return the activity id
	 */
	@Nonnull
	static Optional<Long> getId(final String url) {
		final Pattern urlPattern = Pattern.compile(
			"https?://.*/activities/(\\d+)",
			Pattern.CASE_INSENSITIVE
		);
		
		return Optional.of(urlPattern.matcher(url))
			.filter(Matcher::find)
			.map(matcher -> matcher.group(1))
			.map(Long::parseLong);
	}
	
	/**
	 * Gets the name of the activity.
	 *
	 * @return the name of the activity
	 */
	@Nonnull
	String getName();
	
	/**
	 * Gets the type of the activity.
	 *
	 * @return the type
	 */
	@Nonnull
	ActivityType getType();
}
