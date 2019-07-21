/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.exceptions;

import javax.annotation.Nonnull;

/**
 * A required submission status was not found.
 */
public final class SubmissionStatusNotFoundException extends DodonaException {
	private static final long serialVersionUID = 3486708018079301919L;
	
	private final String status;
	
	/**
	 * SubmissionStatusNotFoundException constructor.
	 *
	 * @param status the name of the status that was not found
	 */
	public SubmissionStatusNotFoundException(final String status) {
		super(String.format("No submission status was found for \"%s\".", status));
		this.status = status;
	}
	
	/**
	 * Gets the name of the status that was not found.
	 *
	 * @return the status
	 */
	@Nonnull
	public String getStatus() {
		return this.status;
	}
	
	@Override
	@Nonnull
	public String toString() {
		return String.format("SubmissionStatusNotFoundException{status=%s}", this.status);
	}
}
