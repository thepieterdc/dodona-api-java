/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package be.ugent.piedcler.dodona.impl.responsebodies;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;

/**
 * Response from creating a submission.
 */
public final class SubmissionCreatedResponseBody {
	private final long id;
	private final String status;
	private final String url;
	
	/**
	 * SubmissionCreatedResponseBody constructor.
	 *
	 * @param id     the id of the submission
	 * @param status the submission status
	 * @param url    the url
	 */
	public SubmissionCreatedResponseBody(@JsonProperty("id") final long id,
	                                     @JsonProperty("status") final String status,
	                                     @JsonProperty("url") final String url) {
		this.id = id;
		this.status = status;
		this.url = url;
	}
	
	/**
	 * Gets the id of the submission.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets the status of the submission.
	 *
	 * @return the status
	 */
	@Nonnull
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Gets the url of the submission.
	 *
	 * @return the url
	 */
	@Nonnull
	public String getUrl() {
		return this.url;
	}
	
	@Override
	public String toString() {
		return String.format("SubmissionCreatedResponseBody{id=%d}", this.id);
	}
}