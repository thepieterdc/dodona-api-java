/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.data;

import tools.jackson.core.JsonParser;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.DeserializationConfig;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.deser.ValueDeserializerModifier;
import io.github.thepieterdc.dodona.data.SeriesVisibility;
import io.github.thepieterdc.dodona.data.SubmissionStatus;

/**
 * Maps json submission statuses to SubmissionStatus instances.
 */
public final class EnumDeserializer extends ValueDeserializerModifier {

	@Override
	@SuppressWarnings("unchecked")
	public ValueDeserializer<?> modifyEnumDeserializer(final DeserializationConfig config,
	                                                  final JavaType type,
	                                                  final BeanDescription.Supplier beanDesc,
	                                                  final ValueDeserializer<?> deserializer) {
		final Class<? extends Enum<?>> enumClass = (Class<Enum<?>>) type.getRawClass();

		if (enumClass.equals(SeriesVisibility.class)) {
			return new SeriesVisibilityDeserializer();
		} else if (enumClass.equals(SubmissionStatus.class)) {
			return new SubmissionStatusDeserializer();
		}

		return super.modifyEnumDeserializer(config, type, beanDesc, deserializer);
	}

	/**
	 * Deserializer for SeriesVisibilities.
	 */
	private static class SeriesVisibilityDeserializer extends ValueDeserializer<SeriesVisibility> {
		@Override
		public SeriesVisibility deserialize(final JsonParser p, final DeserializationContext ctx) {
			return SeriesVisibility.byName(p.getValueAsString());
		}
	}

	/**
	 * Deserializer for SubmissionStatuses.
	 */
	private static class SubmissionStatusDeserializer extends ValueDeserializer<SubmissionStatus> {
		@Override
		public SubmissionStatus deserialize(final JsonParser p, final DeserializationContext ctx) {
			return SubmissionStatus.byName(p.getValueAsString());
		}
	}
}
