/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.resources;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests io.github.thepieterdc.dodona.impl.resources.ProgrammingLanguageImpl.
 */
public class ProgrammingLanguageImplTest {
	/**
	 * Tests the getters.
	 */
	@Test
	void getters() {
		final ProgrammingLanguageImpl lang = new ProgrammingLanguageImpl("py", 5L, "Python");
		assertEquals("py", lang.getExtension());
		assertEquals(5L, lang.getId());
		assertEquals("Python", lang.getName());
		assertEquals("https://dodona.be/en/programming_languages/5.json", lang.getUrl());
	}

	/**
	 * Tests that languages are ordered by name, ignoring case.
	 */
	@Test
	void compareToIgnoresCase() {
		final ProgrammingLanguageImpl a = new ProgrammingLanguageImpl("a", 1L, "alpha");
		final ProgrammingLanguageImpl b = new ProgrammingLanguageImpl("b", 2L, "Beta");
		final ProgrammingLanguageImpl a2 = new ProgrammingLanguageImpl("a", 3L, "ALPHA");
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
		assertEquals(0, a.compareTo(a2));
	}

	/**
	 * Tests equals and hashCode, which are based on the id only.
	 */
	@Test
	void equalsAndHashCode() {
		final ProgrammingLanguageImpl lang = new ProgrammingLanguageImpl("py", 5L, "Python");
		final ProgrammingLanguageImpl same = new ProgrammingLanguageImpl("x", 5L, "Other");
		final ProgrammingLanguageImpl diff = new ProgrammingLanguageImpl("py", 6L, "Python");

		assertEquals(lang, lang);
		assertEquals(lang, same);
		assertEquals(lang.hashCode(), same.hashCode());
		assertNotEquals(lang, diff);
		assertNotEquals(lang, null);
		assertNotEquals(lang, "Python");
	}

	/**
	 * Tests the string representation.
	 */
	@Test
	void toStringContainsIdAndName() {
		assertEquals("ProgrammingLanguage{id=5, name=Python}",
			new ProgrammingLanguageImpl("py", 5L, "Python").toString());
	}
}
