/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.impl.IntegrationTest;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Exercise;
import io.github.thepieterdc.dodona.resources.Series;
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
	public void testGetAll() {
		final Course first = this.zeusClient.courses().get(1L);
		Assert.assertNotNull(first);
		
		final List<Series> firstSeries = this.zeusClient.series().getAll(first);
		Assert.assertNotNull(firstSeries);
		
		final Series series22 = firstSeries.stream()
			.filter(series -> series.getId() == 22L)
			.findAny().orElse(null);
		Assert.assertNotNull(series22);
		
		final List<Exercise> exercises = this.zeusClient.exercises().getAll(series22);
		Assert.assertNotNull(exercises);
		Assert.assertFalse(exercises.isEmpty());
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
	public void testGetByIdValid() {
		final long id = 3L;
		
		final Exercise exercise = this.guestClient.exercises().get(id);
		Assert.assertNotNull(exercise);
		Assert.assertEquals(id, exercise.getId());
		Assert.assertTrue(exercise.getProgrammingLanguage().isPresent());
		Assert.assertFalse(exercise.getBoilerplate().isPresent());
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
