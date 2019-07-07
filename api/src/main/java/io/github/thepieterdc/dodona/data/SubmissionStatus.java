/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import io.github.thepieterdc.dodona.exceptions.SubmissionStatusNotFoundException;

import java.util.stream.Stream;

/**
 * The status of a submission.
 */
public enum SubmissionStatus {
	COMPILATION_ERROR("compilation error"),
	CORRECT("correct"),
	INTERNAL_ERROR("internal error"),
	MEMORY_LIMIT_EXCEEDED("memory limit exceeded"),
	QUEUED("queued"),
	RUNNING("running"),
	RUNTIME_ERROR("runtime error"),
	TIME_LIMIT_EXCEEDED("time limit exceeded"),
	UNKNOWN("unknown"),
	WRONG("wrong");
	
	private final String name;
	
	/**
	 * SubmissionStatus constructor.
	 *
	 * @param name the name of the status
	 */
	SubmissionStatus(final String name) {
		this.name = name;
	}
	
	/**
	 * Finds a SubmissionStatus given its name.
	 *
	 * @param name the name to find
	 * @return the submission status to find
	 */
	public static SubmissionStatus byName(final String name) {
		return Stream.of(SubmissionStatus.values())
			.filter(status -> status.name.equals(name))
			.findAny()
			.orElseThrow(() -> new SubmissionStatusNotFoundException(name));
	}
	
	/**
	 * Gets the name of the status.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}
