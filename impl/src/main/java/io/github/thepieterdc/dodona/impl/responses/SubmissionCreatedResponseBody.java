/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from creating a submission.
 *
 * @param courseId   the id of the course
 * @param exerciseId the id of the exercise
 * @param id         the id of the submission
 * @param status     the submission status
 * @param url        the url
 */
public record SubmissionCreatedResponseBody(@JsonProperty("course_id") long courseId,
                                            @JsonProperty("exercise_id") long exerciseId,
                                            @JsonProperty("id") long id,
                                            @JsonProperty("status") String status,
                                            @JsonProperty("url") String url) {
	/**
	 * Gets the id of the course.
	 *
	 * @return the id
	 */
	public long getCourseId() {
		return this.courseId;
	}

	/**
	 * Gets the id of the exercise.
	 *
	 * @return the id
	 */
	public long getExerciseId() {
		return this.exerciseId;
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
	public String getStatus() {
		return this.status;
	}

	/**
	 * Gets the url of the submission.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	@Override
	public String toString() {
		return String.format("SubmissionCreatedResponseBody{id=%d}", this.id);
	}
}
