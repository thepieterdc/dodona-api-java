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
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.User;
import io.github.thepieterdc.dodona.resources.submissions.Submission;
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import io.github.thepieterdc.random.collection.RandomCollectionGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * Tests io.github.thepieterdc.dodona.impl.managers.SubmissionManagerImpl.
 */
public class SubmissionManagerImplTest extends IntegrationTest {
	/**
	 * Tests SubmissionManager#create(long, long, long, String).
	 */
	@Test
	public void testCreate() {
		final long id = this.zeusClient.submissions().create(8L, null, 8L, "some solution");
		Assert.assertNotEquals(0L, id);
		
		final Submission submission = this.zeusClient.submissions().get(id);
		Assert.assertNotNull(submission);
		Assert.assertEquals(SubmissionStatus.QUEUED, submission.getStatus());
		Assert.assertEquals("some solution", submission.getCode());
	}
	
	/**
	 * Tests SubmissionManagerImpl#getAllByMe().
	 */
	@Test
	public void testGetAllByMe() {
		final Collection<SubmissionInfo> submissions = this.zeusClient.submissions().getAllByMe();
		Assert.assertNotNull(submissions);
		Assert.assertFalse(submissions.isEmpty());
	}
	
	/**
	 * Tests SubmissionManagerImpl#getAllByMe(Exercise).
	 */
	@Test
	public void testGetAllByMeExerciseScoped() {
		final Collection<SubmissionInfo> submissions = this.zeusClient.submissions().getAllByMe();
		Assert.assertNotNull(submissions);
		Assert.assertFalse(submissions.isEmpty());
		
		final SubmissionInfo random = RandomCollectionGenerator.of(submissions).generate();
		Assert.assertNotNull(random);
		
		final Exercise exercise = this.zeusClient.exercises().get(random);
		Assert.assertNotNull(exercise);
		
		final Collection<SubmissionInfo> exerciseSubmissions = this.zeusClient.submissions().getAllByMe(exercise);
		Assert.assertNotNull(exerciseSubmissions);
		Assert.assertFalse(exerciseSubmissions.isEmpty());
		for (SubmissionInfo info : exerciseSubmissions) {
			Assert.assertNotNull(info);
			Assert.assertEquals(exercise.getId(), (long) Exercise.getId(info.getExerciseUrl()).orElse(-1L));
		}
	}
	
	/**
	 * Tests SubmissionManagerImpl#getAll(User).
	 */
	@Test
	public void testGetAllByUser() {
		final User me = this.zeusClient.me();
		Assert.assertNotNull(me);
		
		final Collection<SubmissionInfo> submissions = this.zeusClient.submissions().getAll(me);
		Assert.assertNotNull(submissions);
		Assert.assertFalse(submissions.isEmpty());
	}
	
	/**
	 * Tests SubmissionManagerImpl#get(long).
	 */
	@Test
	public void testGetById() {
		final Submission submission = this.zeusClient.submissions().get(1L);
		Assert.assertNotNull(submission);
	}
	
	/**
	 * Tests SubmissionManagerImpl#get(SubmissionInfo).
	 */
	@Test
	public void testGetByInfo() {
		final Submission submission = this.zeusClient.submissions().get(1L);
		Assert.assertNotNull(submission);
		
		final Submission submission2 = this.zeusClient.submissions().get(submission.getInfo());
		Assert.assertNotNull(submission2);
		
		Assert.assertEquals(submission.getCode(), submission2.getCode());
	}
}