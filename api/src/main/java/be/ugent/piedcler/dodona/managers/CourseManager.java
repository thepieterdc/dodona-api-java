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
	 * Gets the course of a given submission.
	 *
	 * @param submission the submission
	 * @return the course
	 */
	@Nonnull
	default Course get(final Submission submission) {
		return this.get(submission.getCourseUrl());
	}
}
