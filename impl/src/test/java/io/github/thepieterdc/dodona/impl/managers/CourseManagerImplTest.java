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
import io.github.thepieterdc.dodona.resources.submissions.SubmissionInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests io.github.thepieterdc.dodona.impl.CourseManagerImpl.
 */
public class CourseManagerImplTest extends IntegrationTest {
	/**
	 * Tests CourseManagerImpl#get(long).
	 */
	@Test
	public void testGetByIdValid() {
		final Course openForAll = this.zeusClient.courses().get(1L);
		Assert.assertNotNull(openForAll);
		
		Assert.assertEquals(1L, openForAll.getId());
		Assert.assertEquals("Open for All Test Course", openForAll.getName());
		Assert.assertTrue(openForAll.getTeacher().isPresent());
		Assert.assertEquals("Prof. Gobelijn", openForAll.getTeacher().get());
		Assert.assertNotNull(openForAll.getColor());
	}
	
	/**
	 * Tests CourseManagerImpl#get(SubmissionInfo).
	 */
	@Test
	public void testGetBySubmission() {
		final SubmissionInfo submission = this.zeusClient
			.submissions()
			.get(1L)
			.getInfo();
		Assert.assertNotNull(submission);
		
		final Course course = this.zeusClient.courses().get(submission).orElse(null);
		Assert.assertNotNull(course);
		Assert.assertNotEquals(0L, course.getId());
	}
}