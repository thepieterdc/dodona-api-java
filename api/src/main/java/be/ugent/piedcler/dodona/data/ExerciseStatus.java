/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.data;

import be.ugent.piedcler.dodona.exceptions.SubmissionStatusNotFoundException;

import javax.annotation.Nullable;
import java.util.stream.Stream;

/**
 * The status of an exercise.
 */
public enum ExerciseStatus {
	/**
	 * The exercise is correct.
	 */
	CORRECT(true, true, true),
	/**
	 * The exercise was solved correctly before, but afterwards another
	 * incorrect solution was made.
	 */
	HAS_BEEN_CORRECT(true, true, false),
	/**
	 * The exercise has not yet been solved correctly.
	 */
	INCORRECT(false, true, null),
	/**
	 * The exercise has not yet been attempted.
	 */
	NOT_ATTEMPTED(null, false, null);
	
	private final Boolean hasCorrectSolution;
	private final Boolean hasSolution;
	private final Boolean lastSolutionIsBest;
	
	/**
	 * ExerciseStatus constructor.
	 *
	 * @param hasCorrectSolution matching value for has_correct_solution
	 * @param hasSolution        matching value for has_solution
	 * @param lastSolutionIsBest matching value for last_solution_is_best
	 */
	ExerciseStatus(@Nullable final Boolean hasCorrectSolution,
	               @Nullable final Boolean hasSolution,
	               @Nullable final Boolean lastSolutionIsBest) {
		this.hasCorrectSolution = hasCorrectSolution;
		this.hasSolution = hasSolution;
		this.lastSolutionIsBest = lastSolutionIsBest;
	}
	
	/**
	 * Finds an ExerciseStatus given the values of the exercise.
	 *
	 * @param hasCorrectSolution value for has_correct_solution
	 * @param hasSolution        value for has_solution
	 * @param lastSolutionIsBest value for last_solution_is_best
	 */
	public static ExerciseStatus fromValues(final boolean hasCorrectSolution,
	                                        final boolean hasSolution,
	                                        final boolean lastSolutionIsBest) {
		return Stream.of(ExerciseStatus.values())
			.filter(status ->
				(status.hasCorrectSolution == null || status.hasCorrectSolution == hasCorrectSolution)
					&& (status.hasSolution == null || status.hasSolution == hasSolution)
					&& (status.lastSolutionIsBest == null || status.lastSolutionIsBest == lastSolutionIsBest)
			)
			.findAny()
			.orElse(INCORRECT);
	}
}
