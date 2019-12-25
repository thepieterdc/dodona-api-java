/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.data;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * The status of an exercise.
 */
public enum ExerciseStatus {
	/**
	 * The exercise is correct.
	 */
	CORRECT(b -> ((b & Masks.MASK_CORRECT) == Masks.MASK_CORRECT)),
	/**
	 * The exercise was solved correctly before, but afterwards another
	 * incorrect solution was made.
	 */
	HAS_BEEN_CORRECT(b -> (b & Masks.MASK_HAS_BEEN_CORRECT) == Masks.MASK_HAS_BEEN_CORRECT),
	/**
	 * The exercise has not yet been solved correctly.
	 */
	INCORRECT(b -> ((b & Masks.MASK_INCORRECT) == Masks.MASK_INCORRECT)),
	/**
	 * The exercise has not yet been attempted.
	 */
	NOT_ATTEMPTED(b -> false);
	
	private final Predicate<Byte> mask;
	
	/**
	 * Masks used in the exercise statuses.
	 */
	private static class Masks {
		// Parts.
		private static final byte HAS_CORRECT_SOLUTION = 1 << 2;
		private static final byte HAS_SOLUTION = 1 << 1;
		private static final byte LAST_SOLUTION_IS_BEST = 1;
		
		// Masks.
		private static final byte MASK_CORRECT = (HAS_CORRECT_SOLUTION | HAS_SOLUTION | LAST_SOLUTION_IS_BEST);
		private static final byte MASK_HAS_BEEN_CORRECT = (HAS_CORRECT_SOLUTION | HAS_SOLUTION);
		private static final byte MASK_INCORRECT = HAS_SOLUTION;
	}
	
	/**
	 * ExerciseStatus constructor.
	 *
	 * @param mask the mask to validate
	 */
	ExerciseStatus(final Predicate<Byte> mask) {
		this.mask = mask;
	}
	
	/**
	 * Finds an ExerciseStatus given the values of the exercise.
	 *
	 * @param hasCorrectSolution value for has_correct_solution
	 * @param hasSolution        value for has_solution
	 * @param lastSolutionIsBest value for last_solution_is_best
	 * @return the matching exercise status
	 */
	public static ExerciseStatus fromValues(final boolean hasCorrectSolution,
	                                        final boolean hasSolution,
	                                        final boolean lastSolutionIsBest) {
		// Build the mask.
		final byte mask = (byte) ((hasCorrectSolution ? Masks.HAS_CORRECT_SOLUTION : 0)
			| (hasSolution ? Masks.HAS_SOLUTION : 0)
			| (lastSolutionIsBest ? Masks.LAST_SOLUTION_IS_BEST : 0));
		
		return Arrays.stream(ExerciseStatus.values())
			.filter(status -> status.mask.test(mask))
			.findAny()
			.orElse(NOT_ATTEMPTED);
	}
}
