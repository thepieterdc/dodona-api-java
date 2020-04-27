/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources.activities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.data.ExerciseStatus;
import io.github.thepieterdc.dodona.impl.resources.ProgrammingLanguageImpl;
import io.github.thepieterdc.dodona.resources.activities.Exercise;
import io.github.thepieterdc.dodona.resources.ProgrammingLanguage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

/**
 * A exercise on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ExerciseImpl extends ActivityImpl implements Exercise {
	@Nullable
	private final String boilerplate;
	
	private final boolean hasCorrectSolution;
	private final boolean hasSolution;
	private final boolean lastSolutionIsBest;
	
	@Nullable
	private final ProgrammingLanguageImpl programmingLanguage;
	
	private final ExerciseStatus status;
	
	/**
	 * ExerciseImpl constructor.
	 *
	 * @param boilerplate         the boilerplate code
	 * @param descriptionFormat   the description format
	 * @param descriptionUrl    the description url
	 * @param hasCorrectSolution  true if the exercise has a correct submission
	 * @param hasSolution         true if the exercise has a submission
	 * @param id                  the id
	 * @param lastSolutionIsBest  true if the last submission was correct
	 * @param name                the name
	 * @param programmingLanguage the programming language
	 * @param url                 the url
	 */
	public ExerciseImpl(@Nullable @JsonProperty("boilerplate") final String boilerplate,
	                    @JsonProperty("description_format") final String descriptionFormat,
	                    @JsonProperty("description_url") final String descriptionUrl,
	                    @JsonProperty("has_correct_solution") final boolean hasCorrectSolution,
	                    @JsonProperty("has_solution") final boolean hasSolution,
	                    @JsonProperty("id") final long id,
	                    @JsonProperty("last_solution_is_best") final boolean lastSolutionIsBest,
	                    @JsonProperty("name") final String name,
	                    @Nullable @JsonProperty("programming_language") final ProgrammingLanguageImpl programmingLanguage,
	                    @JsonProperty("url") final String url) {
		super(descriptionFormat, descriptionUrl, id, name, url);
		this.boilerplate = boilerplate;
		this.hasCorrectSolution = hasCorrectSolution;
		this.hasSolution = hasSolution;
		this.lastSolutionIsBest = lastSolutionIsBest;
		this.programmingLanguage = programmingLanguage;
		this.status = ExerciseStatus.fromValues(hasCorrectSolution, hasSolution, lastSolutionIsBest);
	}
	
	@Override
	public int compareTo(final Exercise o) {
		return this.getName().compareToIgnoreCase(o.getName());
	}
	
	@Override
	@Nonnull
	public Optional<String> getBoilerplate() {
		return Optional.ofNullable(this.boilerplate);
	}
	
	@Override
	public boolean hasCorrectSolution() {
		return this.hasCorrectSolution;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
	
	@Override
	public boolean hasSolution() {
		return this.hasSolution;
	}
	
	@Override
	@Nonnull
	public Optional<ProgrammingLanguage> getProgrammingLanguage() {
		return Optional.ofNullable(this.programmingLanguage);
	}
	
	@Nonnull
	@Override
	public ExerciseStatus getStatus() {
		return this.status;
	}
	
	@Override
	public boolean lastSolutionIsBest() {
		return this.lastSolutionIsBest;
	}
	
	@Override
	public String toString() {
		return String.format("Exercise{id=%d, name=%s, status=%s}", this.getId(), this.getName(), this.status);
	}
}
