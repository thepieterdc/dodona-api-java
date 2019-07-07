/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.thepieterdc.dodona.data.ExerciseStatus;
import io.github.thepieterdc.dodona.resources.Exercise;
import io.github.thepieterdc.dodona.resources.ProgrammingLanguage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * A exercise on Dodona.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ExerciseImpl implements Exercise {
	@Nullable
	private final String boilerplate;
	
	private final boolean hasCorrectSolution;
	private final boolean hasSolution;
	private final boolean lastSolutionIsBest;
	
	private final long id;
	
	private final String description;
	private final String descriptionFormat;
	private final String name;
	
	@Nullable
	private final ProgrammingLanguageImpl programmingLanguage;
	
	private final ExerciseStatus status;
	
	private final String url;
	
	/**
	 * ExerciseImpl constructor.
	 *
	 * @param boilerplate         the boilerplate code
	 * @param description         the description
	 * @param descriptionFormat   the description format
	 * @param hasCorrectSolution  true if the exercise has a correct submission
	 * @param hasSolution         true if the exercise has a submission
	 * @param id                  the id
	 * @param lastSolutionIsBest  true if the last submission was correct
	 * @param name                the name
	 * @param programmingLanguage the programming language
	 * @param url                 the url
	 */
	public ExerciseImpl(@Nullable @JsonProperty("boilerplate") final String boilerplate,
	                    @JsonProperty("description") final String description,
	                    @JsonProperty("description_format") final String descriptionFormat,
	                    @JsonProperty("has_correct_solution") final boolean hasCorrectSolution,
	                    @JsonProperty("has_solution") final boolean hasSolution,
	                    @JsonProperty("id") final long id,
	                    @JsonProperty("last_solution_is_best") final boolean lastSolutionIsBest,
	                    @JsonProperty("name") final String name,
	                    @Nullable @JsonProperty("programming_language") final ProgrammingLanguageImpl programmingLanguage,
	                    @JsonProperty("url") final String url) {
		this.boilerplate = boilerplate;
		this.description = description;
		this.descriptionFormat = descriptionFormat;
		this.hasCorrectSolution = hasCorrectSolution;
		this.hasSolution = hasSolution;
		this.id = id;
		this.lastSolutionIsBest = lastSolutionIsBest;
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.status = ExerciseStatus.fromValues(hasCorrectSolution, hasSolution, lastSolutionIsBest);
		this.url = url;
	}
	
	@Override
	public int compareTo(final Exercise o) {
		return this.name.compareToIgnoreCase(o.getName());
	}
	
	@Override
	@Nonnull
	public Optional<String> getBoilerplate() {
		return Optional.ofNullable(this.boilerplate);
	}
	
	@Nonnull
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Nonnull
	@Override
	public String getDescriptionFormat() {
		return this.descriptionFormat;
	}
	
	@Override
	public boolean hasCorrectSolution() {
		return this.hasCorrectSolution;
	}
	
	@Override
	public boolean hasSolution() {
		return this.hasSolution;
	}
	
	@Override
	public long getId() {
		return this.id;
	}
	
	@Override
	@Nonnull
	public String getName() {
		return this.name;
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
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}
	
	@Override
	public boolean lastSolutionIsBest() {
		return this.lastSolutionIsBest;
	}
	
	@Override
	public String toString() {
		return String.format("Exercise{id=%d, name=%s, status=%s}", this.id, this.name, this.status);
	}
}
