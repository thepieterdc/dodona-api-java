/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.resources;

import be.ugent.piedcler.dodona.data.SubmissionStatus;
import be.ugent.piedcler.dodona.resources.Submission;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;

/**
 * A submission on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class SubmissionImpl implements Submission {
	private final boolean accepted;
	private final String code;
	private final String courseUrl;
	private final String exerciseUrl;
	private final long id;
	private final SubmissionStatus status;
	private final String summary;
	private final String url;
	
	/**
	 * SubmissionImpl constructor.
	 *
	 * @param accepted the acceptance status
	 * @param code     the code
	 * @param course   the course url
	 * @param exercise the exercise url
	 * @param id       the id
	 * @param status   the status
	 * @param summary  the summary
	 * @param url      the url
	 */
	public SubmissionImpl(@JsonProperty("accepted") final boolean accepted,
	                      @JsonProperty("code") final String code,
	                      @JsonProperty("course") final String course,
	                      @JsonProperty("exercise") final String exercise,
	                      @JsonProperty("id") final long id,
	                      @JsonProperty("status") final SubmissionStatus status,
	                      @JsonProperty("summary") final String summary,
	                      @JsonProperty("url") final String url) {
		this.accepted = accepted;
		this.code = code;
		this.courseUrl = course;
		this.exerciseUrl = exercise;
		this.id = id;
		this.status = status;
		this.summary = summary;
		this.url = url;
	}
	
	@Override
	@Nonnull
	public String getCode() {
		return this.code;
	}
	
	@Override
	@Nonnull
	public String getCourseUrl() {
		return this.courseUrl;
	}
	
	@Override
	@Nonnull
	public String getExerciseUrl() {
		return this.exerciseUrl;
	}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	@Override
	@Nonnull
	public SubmissionStatus getStatus() {
		return this.status;
	}
	
	@Override
	@Nonnull
	public String getSummary() {
		return this.summary;
	}
	
	@Override
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}
	
	@Override
	public boolean isAccepted() {
		return this.accepted;
	}
	
	@Override
	public String toString() {
		return String.format("Submission{id=%d, status=%s}", this.id, this.status);
	}
}
