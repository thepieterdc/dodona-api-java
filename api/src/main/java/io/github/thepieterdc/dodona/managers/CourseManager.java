/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.managers;

import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * Manager for courses.
 */
public interface CourseManager extends ResourceManager<Course> {
	/**
	 * Gets the course with the given id.
	 *
	 * @param id the id of the course
	 * @return the course
	 */
	@Nonnull
	Course get(long id);
	
	/**
	 * Gets the course of a given submission, if the submission contains a
	 * course.
	 *
	 * @param submission the submission info
	 * @return the course, if any
	 */
	@Nonnull
	Optional<Course> get(SubmissionInfo submission);
}
