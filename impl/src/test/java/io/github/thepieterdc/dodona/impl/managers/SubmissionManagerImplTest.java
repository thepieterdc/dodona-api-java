/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains/
 */
package io.github.thepieterdc.dodona.impl.managers;

import io.github.thepieterdc.dodona.data.SubmissionStatus;
import io.github.thepieterdc.dodona.impl.IntegrationTest;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.Series;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.resources.activities.Activity;
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.submissions.Submission;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import io.github.thepieterdc.http.exceptions.UnprocessableEntityException;
import io.github.thepieterdc.random.collection.RandomCollectionGenerator;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.impl.managers.SubmissionManagerImpl.
 */
public class SubmissionManagerImplTest extends IntegrationTest {
	private static final String CODE = "answer();";

	/**
	 * Tests SubmissionManager#create(long, long, long, String).
	 */
	@Test
	public void testCreateCourseScoped() throws Exception {
		final Course course = this.zeusClient.courses().get(1L);
		assertNotNull(course);

		final Series series = this.zeusClient.series().getAll(course).get(0);
		assertNotNull(series);

		final Exercise exercise = this.zeusClient.exercises().getAll(series).get(0);
		assertNotNull(exercise);

		long id = -1;
		do {
			try {
				id = this.zeusClient.submissions().create(course, series, exercise, CODE);
			} catch (final UnprocessableEntityException ex) {
				Thread.sleep(1000L);
			}
		} while (id <= 0L);

		final Submission submission = this.zeusClient.submissions().get(id);
		assertNotNull(submission);
		assertEquals(SubmissionStatus.QUEUED, submission.getStatus());
		assertEquals(CODE, submission.getCode());
	}

	/**
	 * Tests SubmissionManager#create(long, String).
	 */
	@Test
	public void testCreate() throws Exception {
		final Exercise exercise = this.zeusClient.exercises().getAll().get(0);

		long id = -1;
		do {
			try {
				id = this.zeusClient.submissions().create(null, null, exercise, CODE);
			} catch (final UnprocessableEntityException ex) {
				Thread.sleep(1000L);
			}
		} while (id <= 0L);

		final Submission submission = this.zeusClient.submissions().get(id);
		assertNotNull(submission);
		assertEquals(SubmissionStatus.QUEUED, submission.getStatus());
		assertEquals(CODE, submission.getCode());
	}

	/**
	 * Tests SubmissionManagerImpl#getAllByMe().
	 */
	@Test
	public void testGetAllByMe() {
		final Collection<SubmissionInfo> submissions = this.zeusClient.submissions().getAllByMe();
		assertNotNull(submissions);
		assertFalse(submissions.isEmpty());
	}

	/**
	 * Tests SubmissionManagerImpl#getAllByMe(Exercise).
	 */
	@Test
	public void testGetAllByMeExerciseScoped() {
		final Collection<SubmissionInfo> submissions = this.zeusClient.submissions().getAllByMe();
		assertNotNull(submissions);
		assertFalse(submissions.isEmpty());

		final SubmissionInfo random = RandomCollectionGenerator.of(submissions).generate();
		assertNotNull(random);

		final Exercise exercise = this.zeusClient.exercises().get(random);
		assertNotNull(exercise);

		final Collection<SubmissionInfo> exerciseSubmissions = this.zeusClient.submissions().getAllByMe(exercise);
		assertNotNull(exerciseSubmissions);
		assertFalse(exerciseSubmissions.isEmpty());
		for (SubmissionInfo info : exerciseSubmissions) {
			assertNotNull(info);
			assertEquals(exercise.getId(), (long) Activity.getId(info.getExerciseUrl()).orElse(-1L));
		}
	}

	/**
	 * Tests SubmissionManagerImpl#getAll(User).
	 */
	@Test
	public void testGetAllByUser() {
		final User me = this.zeusClient.me();
		assertNotNull(me);

		final Collection<SubmissionInfo> submissions = this.zeusClient.submissions().getAll(me);
		assertNotNull(submissions);
		assertFalse(submissions.isEmpty());
	}

	/**
	 * Tests SubmissionManagerImpl#get(long).
	 */
	@Test
	public void testGetById() {
		final Submission submission = this.zeusClient.submissions().get(1L);
		assertNotNull(submission);
	}

	/**
	 * Tests SubmissionManagerImpl#get(SubmissionInfo).
	 */
	@Test
	public void testGetByInfo() {
		final Submission submission = this.zeusClient.submissions().get(1L);
		assertNotNull(submission);

		final Submission submission2 = this.zeusClient.submissions().get(submission.getInfo());
		assertNotNull(submission2);

		assertEquals(submission.getCode(), submission2.getCode());
	}
}
