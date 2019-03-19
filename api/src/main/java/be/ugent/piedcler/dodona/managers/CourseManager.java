/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.managers;

import be.ugent.piedcler.dodona.resources.Course;
import be.ugent.piedcler.dodona.resources.Submission;

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
	 * @param submission the submission
	 * @return the course, if any
	 */
	@Nonnull
	default Optional<Course> get(@Nonnull final Submission submission) {
		return submission.getCourseUrl().map(this::get);
	}
}
