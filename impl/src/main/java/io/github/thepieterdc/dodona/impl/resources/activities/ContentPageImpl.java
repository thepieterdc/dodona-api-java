/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources.activities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.resources.activities.ContentPage;

/**
 * A content page on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ContentPageImpl extends ActivityImpl implements ContentPage {
	private final boolean hasRead;
	
	/**
	 * ContentPageImpl constructor.
	 *
	 * @param descriptionFormat the description format
	 * @param descriptionUrl    the description url
	 * @param hasRead           the read state
	 * @param id                the id
	 * @param name              the name
	 * @param url               the url
	 */
	public ContentPageImpl(@JsonProperty("description_format") final String descriptionFormat,
	                       @JsonProperty("description_url") final String descriptionUrl,
	                       @JsonProperty("has_read") final boolean hasRead,
	                       @JsonProperty("id") final long id,
	                       @JsonProperty("name") final String name,
	                       @JsonProperty("url") final String url) {
		super(descriptionFormat, descriptionUrl, id, name, url);
		this.hasRead = hasRead;
	}
	
	@Override
	public int compareTo(final ContentPage o) {
		return this.getName().compareToIgnoreCase(o.getName());
	}
	
	@Override
	public boolean hasRead() {
		return this.hasRead;
	}
	
	@Override
	public String toString() {
		return String.format("ContentPage{id=%d, name=%s, read=%s}", this.getId(), this.getName(), this.hasRead);
	}
}
