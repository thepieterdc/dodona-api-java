/*
 * Copyright (c) 2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-plugin-jetbrains
 */
package be.ugent.piedcler.dodona.impl;

import be.ugent.piedcler.dodona.DodonaBuilder;
import be.ugent.piedcler.dodona.DodonaClient;
import be.ugent.piedcler.dodona.resources.Submission;

public class Main {
	public static void main(String[] args) {
		final DodonaClient client = DodonaBuilder.builder()
			.setApiToken("PQi_tA5oKTVOYrkAlfgbXj2NQrjTh8LnFplQw4a52Lo")
			.build();
		
		final Submission withoutCourse = client.submissions().get(3367452);
		final Submission withCourse = client.submissions().get(3367276);
		
		System.out.println(client.exercises().get(withoutCourse));
		System.out.println(client.exercises().get(withCourse));
	}
}
