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
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * The info of a submission on Dodona.
 *
 * @param accepted the acceptance status
 * @param courseUrl the course url
 * @param createdAt the creation timestamp
 * @param exerciseUrl the exercise url
 * @param id the id
 * @param status the status
 * @param summary the summary
 * @param url the url
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SubmissionInfoImpl(
	@JsonProperty("accepted") boolean accepted,
	@JsonProperty("course") @Nullable String courseUrl,
	@JsonProperty("created_at") ZonedDateTime createdAt,
	@JsonProperty("exercise") String exerciseUrl,
	@JsonProperty("id") long id,
	@JsonProperty("status") SubmissionStatus status,
	@JsonProperty("summary") String summary,
	@JsonProperty("url") String url
) implements SubmissionInfo {
	@Override
	public int compareTo(final SubmissionInfo o) {
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
		return String.format("SubmissionInfo{id=%d, status=%s}", this.id, this.status);
	}
}
