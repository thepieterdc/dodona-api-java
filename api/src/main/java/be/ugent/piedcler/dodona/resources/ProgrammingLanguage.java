/*
 * Copyright (c) 2018. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package be.ugent.piedcler.dodona.resources;

import javax.annotation.Nonnull;

/**
 * A programming language on Dodona.
 */
public interface ProgrammingLanguage extends Comparable<ProgrammingLanguage>, Resource {
	/**
	 * Gets the extension of the files.
	 *
	 * @return the extension
	 */
	@Nonnull
	String getExtension();
	
	/**
	 * Gets the name of the programming language.
	 *
	 * @return the name
	 */
	@Nonnull
	String getName();
}
