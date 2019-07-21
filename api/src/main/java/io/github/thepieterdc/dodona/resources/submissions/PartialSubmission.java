/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.resources.submissions;

import io.github.thepieterdc.dodona.data.SubmissionStatus;
import io.github.thepieterdc.dodona.resources.Resource;

import javax.annotation.Nonnull;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * A partial submission (a submission without code) on Dodona.
 */
public interface PartialSubmission extends Resource {
	/**
	 * Gets the url of the course of this submission.
	 *
	 * @return the course url
	 */
	@Nonnull
	Optional<String> getCourseUrl();
	
	/**
	 * Gets the creation (submission) timestamp.
	 *
	 * @return the timestamp at which this submission was created
	 */
	@Nonnull
	ZonedDateTime getCreatedAt();
	
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
