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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.thepieterdc.dodona.data.ActivityType;
import io.github.thepieterdc.dodona.resources.activities.Activity;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * An activity on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = ContentPageImpl.class, name = ActivityType.CONTENT_PAGE_TYPE),
	@JsonSubTypes.Type(value = ExerciseImpl.class, name = ActivityType.EXERCISE_TYPE)
})
public abstract class ActivityImpl implements Activity {
	private final long id;
	
	private final String descriptionFormat;
	private final String descriptionUrl;
	private final String name;
	
	private final String url;
	
	/**
	 * ActivityImpl constructor.
	 *
	 * @param descriptionFormat the description format
	 * @param descriptionUrl    the description url
	 * @param id                the id
	 * @param name              the name
	 * @param url               the url
	 */
	public ActivityImpl(@JsonProperty("description_format") final String descriptionFormat,
	                    @JsonProperty("description_url") final String descriptionUrl,
	                    @JsonProperty("id") final long id,
	                    @JsonProperty("name") final String name,
	                    @JsonProperty("url") final String url) {
		this.descriptionFormat = descriptionFormat;
		this.descriptionUrl = descriptionUrl;
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Activity) {
			return this.id == ((Activity) o).getId();
		}
		return false;
	}
	
	@Nonnull
	@Override
	public String getDescriptionFormat() {
		return this.descriptionFormat;
	}
	
	@Nonnull
	@Override
	public String getDescriptionUrl() {
		return this.descriptionUrl;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	@Override
	@Nonnull
	public String getName() {
		return this.name;
	}
	
	@Override
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}
	
	@Override
	public String toString() {
		return String.format("Activity{id=%d, name=%s}", this.id, this.name);
	}
}
