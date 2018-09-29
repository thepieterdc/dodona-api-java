/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.impl.managers;

import be.ugent.piedcler.dodona.DodonaClient;
import be.ugent.piedcler.dodona.exceptions.accessdenied.ExerciseAccessDeniedException;
import be.ugent.piedcler.dodona.exceptions.notfound.ExerciseNotFoundException;
import be.ugent.piedcler.dodona.impl.http.HttpWrapper;
import be.ugent.piedcler.dodona.impl.resources.ExerciseImpl;
import be.ugent.piedcler.dodona.managers.ExerciseManager;
import be.ugent.piedcler.dodona.resources.Exercise;
import be.ugent.piedcler.dodona.resources.Series;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of ExerciseManager.
 */
public class ExerciseManagerImpl implements ExerciseManager {
	private static final HttpWrapper http = new HttpWrapper()
		.setAccessDeniedHandler(ExerciseAccessDeniedException::new)
		.setNotFoundHandler(ExerciseNotFoundException::new);
	
	private final DodonaClient client;
	
	/**
	 * ExerciseManager implementation.
	 *
	 * @param client client
	 */
	public ExerciseManagerImpl(final DodonaClient client) {
		this.client = client;
	}
	
	@Override
	@Nonnull
	public List<Exercise> getAll(final Series series) {
		return Arrays.asList(http.get(
			series.getExercisesUrl(), this.client.getApiToken(), this.client.getUserAgent(), ExerciseImpl[].class
		));
	}
	
	@Override
	@Nonnull
	public Exercise get(final String url) {
		return http.get(url, this.client.getApiToken(), this.client.getUserAgent(), ExerciseImpl.class);
	}
}
