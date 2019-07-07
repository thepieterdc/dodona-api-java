/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/ugent-dodona/
 */
package io.github.thepieterdc.dodona.impl.requestbodies;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A solution to submit to Dodona.
 */
@JsonRootName("submission")
public final class SubmissionCreateRequestBody {
	@JsonProperty("code")
	private final String code;
	
	@JsonProperty("course_id")
	private final Long courseId;
	
	@JsonProperty("series_id")
	private final Long seriesId;
	
	@JsonProperty("exercise_id")
	private final Long exerciseId;
	
	/**
	 * SubmissionCreateRequestBody constructor.
	 *
	 * @param courseId   the course id
	 * @param seriesId   the series id
	 * @param exerciseId the exercise id
	 * @param code       the solution
	 */
	public SubmissionCreateRequestBody(@Nullable final Long courseId,
	                                   @Nullable final Long seriesId,
	                                   final Long exerciseId,
	                                   final String code) {
		this.code = code;
		this.courseId = courseId;
		this.exerciseId = exerciseId;
		this.seriesId = seriesId;
	}
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	@Nonnull
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Gets the courseId.
	 *
	 * @return the courseId
	 */
	@Nullable
	public Long getCourseId() {
		return this.courseId;
	}
	
	/**
	 * Gets the exerciseId.
	 *
	 * @return the exerciseId
	 */
	@Nonnull
	public Long getExerciseId() {
		return this.exerciseId;
	}
	
	/**
	 * Gets the seriesId.
	 *
	 * @return the seriesId
	 */
	@Nullable
	public Long getSeriesId() {
		return this.seriesId;
	}
}