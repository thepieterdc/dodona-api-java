/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.resources.Course;
import io.github.thepieterdc.dodona.resources.User;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;


/**
 * A user on Dodona.
 *
 * @param correctExercises amount of correct solved exercises
 * @param email the email address
 * @param firstName first name
 * @param id id
 * @param lastName last name
 * @param submissionCount amount of submitted exercises
 * @param submissionsUrl url to fetch submissions
 * @param subscribedCourses list of subscribed courses
 * @param url url
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserImpl(
	@JsonProperty("correct_exercises") long correctExercises,
	@JsonProperty("email") String email,
	@JsonProperty("first_name") String firstName,
	@JsonProperty("id") long id,
	@JsonProperty("last_name") String lastName,
	@JsonProperty("submission_count") long submissionCount,
	@JsonProperty("submissions") String submissionsUrl,
	@JsonProperty("subscribed_courses") List<CourseImpl> subscribedCourses,
	@JsonProperty("url") String url
) implements User {
	@Override
	public int compareTo(final User o) {
		final int compareLast = this.lastName.compareToIgnoreCase(o.getLastName());
		return compareLast != 0 ? compareLast : this.firstName.compareToIgnoreCase(o.getFirstName());
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		return o instanceof User other && this.id == other.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}

	@Override
	public long getCorrectExercises() {
		return this.correctExercises;
	}

	@Override
	@Nonnull
	public String getEmail() {
		return this.email;
	}

	@Override
	@Nonnull
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	@Nonnull
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public long getSubmissionCount() {
		return this.submissionCount;
	}

	@Override
	@Nonnull
	public String getSubmissionsUrl() {
		return this.submissionsUrl;
	}

	@Override
	@Nonnull
	public List<Course> getSubscribedCourses() {
		return Collections.unmodifiableList(this.subscribedCourses);
	}

	@Override
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}

	@Override
	public String toString() {
		return String.format("User{id=%d, firstName=%s, lastName=%s}", this.id, this.firstName, this.lastName);
	}
}
