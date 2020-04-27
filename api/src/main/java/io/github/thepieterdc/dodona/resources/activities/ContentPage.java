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

import javax.annotation.Nonnull;

/**
 * A content page on Dodona.
 */
public interface ContentPage extends Comparable<ContentPage>, Activity {
	@Nonnull
	@Override
	default ActivityType getType() {
		return ActivityType.CONTENT_PAGE;
	}
	
	/**
	 * Gets the read status.
	 *
	 * @return true if the content page has been read
	 */
	boolean hasRead();
}
