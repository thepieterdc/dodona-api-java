/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.resources;

import be.ugent.piedcler.dodona.data.SubmissionStatus;

import javax.annotation.Nonnull;

/**
 * A submission on Dodona.
 */
public interface Submission extends Resource {
	/**
	 * Gets the url of the course of this submission.
	 *
	 * @return the course url
	 */
	@Nonnull
	String getCourseUrl();
	
	/**
	 * Gets the url of the exercise of this submission.
	 * 
	 * @return the exercise url
	 */
	@Nonnull
	String getExerciseUrl();
	
	/**
	 * Gets the status of the submission.
	 *
	 * @return the submission status
	 */
	@Nonnull
	SubmissionStatus getStatus();
	
	/**
	 * Gets whether this submission was accepted or not.
	 *
	 * @return true if it was accepted
	 */
	boolean isAccepted();
}
