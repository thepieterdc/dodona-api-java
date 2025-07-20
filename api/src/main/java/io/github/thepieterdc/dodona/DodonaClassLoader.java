/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

/**
 * Loads implementation classes without having to add the implementation
 * library as a dependency (since this would cause circular dependencies).
 */
final class DodonaClassLoader {
	/**
	 * DodonaClassLoader constructor.
	 */
	private DodonaClassLoader() {
	}

	/**
	 * Gets a new instance of the given class.
	 *
	 * @param fqcn the class to instance
	 * @param <T>  type class
	 * @return the instance, throws exception upon failure
	 */
	@Nonnull
	@SuppressWarnings("unchecked")
	public static <T> T instance(final String fqcn) {
		try {
			return (T) load(fqcn).getDeclaredConstructor().newInstance();
		} catch (final InstantiationException | IllegalAccessException |
					   InvocationTargetException | NoSuchMethodException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Loads the given class.
	 *
	 * @param fqcn the class name, throws exception on fail
	 * @return the loaded class
	 */
	@Nonnull
	@SuppressWarnings("unchecked")
	private static <T> Class<T> load(final String fqcn) {
		return (Class<T>) loadThread(fqcn).orElseGet(() -> loadLocal(fqcn)
			.orElseGet(() -> loadSystem(fqcn)
				.orElseThrow(() -> new RuntimeException(String.format("Couldn't load %s", fqcn)))
			)
		);
	}

	/**
	 * Loads the given class using the given classloader.
	 *
	 * @param fqcn   the class name
	 * @param loader the class loader
	 * @return the loaded class if found, empty on fail
	 */
	@Nonnull
	@SuppressWarnings("unchecked")
	private static <T> Optional<Class<T>> load(final String fqcn, final ClassLoader loader) {
		try {
			return Optional.ofNullable((Class<T>) loader.loadClass(fqcn));
		} catch (final ClassNotFoundException e) {
			return Optional.empty();
		}
	}

	/**
	 * Loads the given class using the class loader of this class.
	 *
	 * @param fqcn the class name
	 * @return the loaded class if found, empty on fail
	 */
	@Nonnull
	@SuppressWarnings("unchecked")
	private static <T> Optional<Class<T>> loadLocal(final String fqcn) {
		return load(fqcn, DodonaClassLoader.class.getClassLoader());
	}

	/**
	 * Loads the given class using the system class loader.
	 *
	 * @param fqcn the class name
	 * @return the loaded class if found, empty on fail
	 */
	@Nonnull
	@SuppressWarnings("unchecked")
	private static <T> Optional<Class<T>> loadSystem(final String fqcn) {
		return load(fqcn, ClassLoader.getSystemClassLoader());
	}

	/**
	 * Loads the given class using the class loader of the current thread.
	 *
	 * @param fqcn the class name
	 * @return the loaded class if found, empty on fail
	 */
	@Nonnull
	@SuppressWarnings("unchecked")
	private static <T> Optional<Class<T>> loadThread(final String fqcn) {
		return load(fqcn, Thread.currentThread().getContextClassLoader());
	}
}
