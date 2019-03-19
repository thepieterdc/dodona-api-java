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
import java.util.Optional;

/**
 * A submission on Dodona.
 */
public interface Submission extends Resource {
	/**
	 * Gets the code from the submission.
	 *
	 * @return the code
	 */
	@Nonnull
	String getCode();
	
	/**
	 * Gets the url of the course of this submission.
	 *
	 * @return the course url
	 */
	@Nonnull
	Optional<String> getCourseUrl();
	
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
	 * Gets the summary of the submission.
	 *
	 * @return the summary
	 */
	@Nonnull
	String getSummary();
	
	/**
	 * Gets whether this submission was accepted or not.
	 *
	 * @return true if it was accepted
	 */
	boolean isAccepted();
}
