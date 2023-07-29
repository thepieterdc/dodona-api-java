/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.data.SeriesVisibility;
import io.github.thepieterdc.dodona.impl.IntegrationTest;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.impl.managers.ExerciseManagerImpl.
 */
public class ExerciseManagerImplTest extends IntegrationTest {
	/**
	 * Tests ExerciseManagerImpl#getAll(Series).
	 */
	@Test
	public void testGetAllStatuses() {
		final Course featuredCourse = this.zeusClient.courses().get(8L);
		assertNotNull(featuredCourse);
		assertEquals("Featured course", featuredCourse.getName());

		final List<Series> firstSeries = this.zeusClient.series().getAll(featuredCourse);
		assertNotNull(firstSeries);

		for (Series series : firstSeries) {
			final List<Exercise> exercises = this.zeusClient.exercises().getAll(series);
			assertFalse(exercises.isEmpty());
		}
	}

	/**
	 * Tests ExerciseManagerImpl#get(long, long).
	 */
	@Test
	public void testGetByIdCourseScopedValid() {
		// Get an exercise.
		final Course course = this.zeusClient.courses().get(1L);
		assertNotNull(course);

		final Series series = this.zeusClient.series().getAll(course)
			.stream()
			.findAny().orElse(null);
		assertNotNull(series);

		final Exercise exercise = this.zeusClient.exercises().getAll(series)
			.stream()
			.findAny().orElse(null);
		assertNotNull(exercise);

		final Exercise same = this.zeusClient.exercises().get(course.getId(), exercise.getId());
		assertNotNull(same);
		assertEquals(exercise, same);
	}

	/**
	 * Tests ExerciseManagerImpl#get(long).
	 */
	@Test
	public void testGetByIdNonExisting() {
		assertThrows(Exception.class, () ->
			this.guestClient.exercises().get(fakeIds.generate())
		);
	}

	/**
	 * Tests ExerciseManagerImpl#get(long).
	 */
	@Test
	public void testGetAllInSeriesById() {
		final Course course = this.guestClient.courses().get(1L);
		assertNotNull(course);

		final Series series = this.zeusClient.series().getAll(course)
			.stream()
			.filter(s -> s.getVisibility() == SeriesVisibility.OPEN)
			.findAny()
			.orElseThrow(AssertionError::new);
		assertNotNull(series);

		final List<Exercise> exercises = this.guestClient.exercises().getAll(series);
		assertFalse(exercises.isEmpty());

		for (Exercise ex : exercises) {
			final Exercise ex2 = this.zeusClient.exercises().get(ex.getId());
			assertNotNull(ex2);
		}
	}

	/**
	 * Tests ExerciseManagerImpl#get(SubmissionInfo).
	 */
	@Test
	public void testGetBySubmission() {
		final SubmissionInfo submission = this.zeusClient
			.submissions()
			.get(1L)
			.getInfo();
		assertNotNull(submission);

		final Exercise exercise = this.zeusClient.exercises().get(submission);
		assertNotNull(exercise);
		assertNotEquals(0L, exercise.getId());
	}
}
