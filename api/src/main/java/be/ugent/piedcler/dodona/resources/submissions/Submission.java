/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.resources.submissions;

import javax.annotation.Nonnull;

/**
 * A submission on Dodona.
 */
public interface Submission extends Comparable<Submission>, PartialSubmission {
	/**
	 * Gets the code from the submission.
	 *
	 * @return the code
	 */
	@Nonnull
	String getCode();
}
