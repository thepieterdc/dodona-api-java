/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.requestbodies;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.annotation.Nullable;

/**
 * A solution to submit to Dodona.
 *
 * @param courseId   the course id
 * @param seriesId   the series id
 * @param exerciseId the exercise id
 * @param code       the solution
 */
@JsonRootName("submission")
public record SubmissionCreateRequestBody(@Nullable @JsonProperty("course_id") Long courseId,
                                          @Nullable @JsonProperty("series_id") Long seriesId,
                                          @JsonProperty("exercise_id") Long exerciseId,
                                          @JsonProperty("code") String code) {
}
