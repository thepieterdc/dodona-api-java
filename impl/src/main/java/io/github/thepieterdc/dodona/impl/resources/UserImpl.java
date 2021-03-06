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

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A user on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserImpl implements User {
	private final long correctExercises;
	private final String email;
	private final String firstName;
	private final long id;
	private final String lastName;
	private final long submissionCount;
	private final String submissionsUrl;
	private final List<CourseImpl> subscribedCourses;
	private final String url;
	
	/**
	 * UserImpl constructor.
	 *
	 * @param correctExercises  amount of correct solved exercises
	 * @param email             the email address
	 * @param firstName         first name
	 * @param id                id
	 * @param lastName          last name
	 * @param submissionCount   amount of submitted exercises
	 * @param submissionsUrl    url to fetch submissions
	 * @param subscribedCourses list of subscribed courses
	 * @param url               url
	 */
	public UserImpl(@JsonProperty("correct_exercises") final long correctExercises,
	                @JsonProperty("email") final String email,
	                @JsonProperty("first_name") final String firstName,
	                @JsonProperty("id") final long id,
	                @JsonProperty("last_name") final String lastName,
	                @JsonProperty("submission_count") final long submissionCount,
	                @JsonProperty("submissions") final String submissionsUrl,
	                @JsonProperty("subscribed_courses") final List<CourseImpl> subscribedCourses,
	                @JsonProperty("url") final String url) {
		this.correctExercises = correctExercises;
		this.email = email;
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.submissionCount = submissionCount;
		this.submissionsUrl = submissionsUrl;
		this.subscribedCourses = subscribedCourses;
		this.url = url;
	}
	
	@Override
	public int compareTo(final User o) {
		final int compareLast = this.lastName.compareToIgnoreCase(o.getLastName());
		return compareLast != 0 ? compareLast : this.firstName.compareToIgnoreCase(o.getFirstName());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof User) {
			return this.id == ((User) o).getId();
		}
		return false;
	}
	
	@Override
	public long getCorrectExercises() {
		return this.correctExercises;
	}
	
	@Nonnull
	@Override
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
	public int hashCode() {
		return Objects.hash(this.id);
	}
	
	@Override
	public String toString() {
		return String.format("User{id=%d, firstName=%s, lastName=%s}", this.id, this.firstName, this.lastName);
	}
}
