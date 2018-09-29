/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.resources;

import be.ugent.piedcler.dodona.resources.Exercise;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private final long id;
	private final boolean lastSolutionCorrect;
	private final String name;
	
	@Nullable
	private final String programmingLanguage;
	
	private final String url;
	
	/**
	 * ExerciseImpl constructor.
	 *
	 * @param boilerplate         the boilerplate code
	 * @param hasCorrectSolution  true if the exercise has a correct submission
	 * @param id                  the id
	 * @param lastSolutionCorrect true if the last submission was correct
	 * @param name                the name
	 * @param programmingLanguage the programming language
	 * @param url                 the url
	 */
	public ExerciseImpl(@Nullable @JsonProperty("boilerplate") final String boilerplate,
	                    @JsonProperty("has_correct_solution") final boolean hasCorrectSolution,
	                    @JsonProperty("id") final long id,
	                    @JsonProperty("last_solution_correct") final boolean lastSolutionCorrect,
	                    @JsonProperty("name") final String name,
	                    @Nullable @JsonProperty("programming_language") final String programmingLanguage,
	                    @JsonProperty("url") final String url) {
		this.boilerplate = boilerplate;
		this.hasCorrectSolution = hasCorrectSolution;
		this.id = id;
		this.lastSolutionCorrect = lastSolutionCorrect;
		this.name = name;
		this.programmingLanguage = programmingLanguage;
		this.url = url;
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
	public Optional<String> getProgrammingLanguage() {
		return Optional.ofNullable(this.programmingLanguage);
	}
	
	@Override
	@Nonnull
	public String getUrl() {
		return this.url.replace(".json", "");
	}
	
	@Override
	public boolean isLastSolutionCorrect() {
		return this.lastSolutionCorrect;
	}
	
	@Override
	public String toString() {
		return String.format("Exercise{id=%d, name=%s}", this.id, this.name);
	}
}
