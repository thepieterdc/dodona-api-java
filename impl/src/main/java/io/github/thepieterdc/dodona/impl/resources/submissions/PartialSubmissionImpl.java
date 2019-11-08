/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources.submissions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.data.SubmissionStatus;
import io.github.thepieterdc.dodona.resources.submissions.PartialSubmission;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * A partal submission on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PartialSubmissionImpl implements PartialSubmission {
	private final boolean accepted;
	private final ZonedDateTime createdAt;
	
	@Nullable
	private final String courseUrl;
	
	private final String exerciseUrl;
	private final long id;
	private final SubmissionStatus status;
	private final String summary;
	private final String url;
	
	/**
	 * PartialSubmissionImpl constructor.
	 *
	 * @param accepted  the acceptance status
	 * @param course    the course url
	 * @param createdAt the creation timestamp
	 * @param exercise  the exercise url
	 * @param id        the id
	 * @param status    the status
	 * @param summary   the summary
	 * @param url       the url
	 */
	public PartialSubmissionImpl(@JsonProperty("accepted") final boolean accepted,
	                             @Nullable @JsonProperty("course") final String course,
	                             @JsonProperty("created_at") final ZonedDateTime createdAt,
	                             @JsonProperty("exercise") final String exercise,
	                             @JsonProperty("id") final long id,
	                             @JsonProperty("status") final SubmissionStatus status,
	                             @JsonProperty("summary") final String summary,
	                             @JsonProperty("url") final String url) {
		this.accepted = accepted;
		this.courseUrl = course;
		this.createdAt = createdAt;
		this.exerciseUrl = exercise;
		this.id = id;
		this.status = status;
		this.summary = summary;
		this.url = url;
	}
	
	@Override
	public int compareTo(final PartialSubmission o) {
		return this.createdAt.compareTo(o.getCreatedAt());
	}
	
	@Override
	@Nonnull
	public Optional<String> getCourseUrl() {
		return Optional.ofNullable(this.courseUrl);
	}
	
	@Override
	@Nonnull
	public ZonedDateTime getCreatedAt() {
		return this.createdAt;
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
