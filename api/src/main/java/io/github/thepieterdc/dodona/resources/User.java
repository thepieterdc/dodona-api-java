/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * A user on Dodona.
 */
public interface User extends Comparable<User>, Resource {
	/**
	 * Gets the amount of correct exercises.
	 *
	 * @return the amount of correct exercises
	 */
	long getCorrectExercises();
	
	/**
	 * Gets the email address of the user.
	 *
	 * @return the email address
	 */
	@Nonnull
	String getEmail();
	
	/**
	 * Gets the first name of the user.
	 *
	 * @return the first name
	 */
	@Nonnull
	String getFirstName();
	
	/**
	 * Gets the last name of the user.
	 *
	 * @return the last name
	 */
	@Nonnull
	String getLastName();
	
	/**
	 * Gets the amount of submissions made by the user.
	 *
	 * @return the amount of submissions
	 */
	long getSubmissionCount();
	
	/**
	 * Gets the url to fetch the submissions of the user.
	 *
	 * @return the submissions url
	 */
	@Nonnull
	String getSubmissionsUrl();
	
	/**
	 * Gets the subscribed courses of the user.
	 *
	 * @return the subscribed courses
	 */
	@Nonnull
	List<Course> getSubscribedCourses();
}
