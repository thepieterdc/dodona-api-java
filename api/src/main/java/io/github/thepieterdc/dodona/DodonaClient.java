/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona;

import io.github.thepieterdc.dodona.managers.CourseManager;
import io.github.thepieterdc.dodona.managers.ExerciseManager;
import io.github.thepieterdc.dodona.managers.SeriesManager;
import io.github.thepieterdc.dodona.managers.SubmissionManager;
import io.github.thepieterdc.dodona.managers.UserManager;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.responses.RootResponse;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * API client to interface with Dodona.
 */
public interface DodonaClient {
	/**
	 * The default Dodona host.
	 */
	String DEFAULT_HOST = "https://dodona.be";
	
	/**
	 * Gets a resource manager for courses.
	 *
	 * @return courses manager
	 */
	@Nonnull
	CourseManager courses();
	
	/**
	 * Gets the deadlines for the authenticated user.
	 *
	 * @return the deadlines
	 */
	@Nonnull
	Collection<Series> deadlines();
	
	/**
	 * Gets a resource manager for exercises.
	 *
	 * @return exercises manager
	 */
	@Nonnull
	ExerciseManager exercises();
	
	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	@Nonnull
	User me();
	
	/**
	 * Gets the response from querying the root.
	 *
	 * @return the root response
	 */
	@Nonnull
	RootResponse root();
	
	/**
	 * Gets a resource manager for series.
	 *
	 * @return series manager
	 */
	@Nonnull
	SeriesManager series();
	
	/**
	 * Gets a resource manager for submissions.
	 *
	 * @return submissions manager
	 */
	@Nonnull
	SubmissionManager submissions();
	
	/**
	 * Gets a resource manager for users.
	 *
	 * @return users manager
	 */
	@Nonnull
	UserManager users();
}
