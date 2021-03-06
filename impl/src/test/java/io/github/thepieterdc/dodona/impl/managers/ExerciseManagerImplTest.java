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
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Tests io.github.thepieterdc.dodona.impl.managers.ExerciseManagerImpl.
 */
public class ExerciseManagerImplTest extends IntegrationTest {
	/**
	 * Tests ExerciseManagerImpl#getAll(Series).
	 */
	@Test
	public void testGetAllStatuses() {
		final Course statusTest = this.zeusClient.courses().get(8L);
		Assert.assertNotNull(statusTest);
		Assert.assertEquals("Status Test", statusTest.getName());
		
		final List<Series> firstSeries = this.zeusClient.series().getAll(statusTest);
		Assert.assertNotNull(firstSeries);
		
		for (Series series : firstSeries) {
			final List<Exercise> exercises = this.zeusClient.exercises().getAll(series);
			Assert.assertFalse(exercises.isEmpty());
		}
	}
	
	/**
	 * Tests ExerciseManagerImpl#get(long, long).
	 */
	@Test
	public void testGetByIdCourseScopedValid() {
		// Get an exercise.
		final Course course = this.zeusClient.courses().get(1L);
		Assert.assertNotNull(course);
		
		final Series series = this.zeusClient.series().getAll(course)
			.stream()
			.findAny().orElse(null);
		Assert.assertNotNull(series);
		
		final Exercise exercise = this.zeusClient.exercises().getAll(series)
			.stream()
			.findAny().orElse(null);
		Assert.assertNotNull(exercise);
		
		final Exercise same = this.zeusClient.exercises().get(course.getId(), exercise.getId());
		Assert.assertNotNull(same);
		Assert.assertEquals(exercise, same);
	}
	
	/**
	 * Tests ExerciseManagerImpl#get(long).
	 */
	@Test(expected = Exception.class)
	public void testGetByIdNonExisting() {
		this.guestClient.exercises().get(fakeIds.generate());
	}
	
	/**
	 * Tests ExerciseManagerImpl#get(long).
	 */
	@Test
	public void testGetAllInSeriesById() {
		final Course course = this.guestClient.courses().get(1L);
		Assert.assertNotNull(course);
		
		final Series series = this.zeusClient.series().getAll(course)
			.stream()
			.filter(s -> s.getVisibility() == SeriesVisibility.OPEN)
			.findAny()
			.orElseThrow(AssertionError::new);
		Assert.assertNotNull(series);
		
		final List<Exercise> exercises = this.guestClient.exercises().getAll(series);
		Assert.assertFalse(exercises.isEmpty());
		
		for (Exercise ex : exercises) {
			final Exercise ex2 = this.zeusClient.exercises().get(ex.getId());
			Assert.assertNotNull(ex2);
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
		Assert.assertNotNull(submission);
		
		final Exercise exercise = this.zeusClient.exercises().get(submission);
		Assert.assertNotNull(exercise);
		Assert.assertNotEquals(0L, exercise.getId());
	}
}
