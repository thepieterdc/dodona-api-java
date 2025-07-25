/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import io.github.thepieterdc.dodona.data.SeriesVisibility;
import io.github.thepieterdc.dodona.data.SubmissionStatus;

import java.io.IOException;

/**
 * Maps json submission statuses to SubmissionStatus instances.
 */
public final class EnumDeserializer extends BeanDeserializerModifier {
	
	@Override
	@SuppressWarnings("unchecked")
	public JsonDeserializer<?> modifyEnumDeserializer(final DeserializationConfig config,
	                                                  final JavaType type,
	                                                  final BeanDescription beanDesc,
	                                                  final JsonDeserializer<?> deserializer) {
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
	private static class SeriesVisibilityDeserializer extends JsonDeserializer<SeriesVisibility> {
		@Override
		public SeriesVisibility deserialize(final JsonParser p, final DeserializationContext ctx) throws IOException {
			return SeriesVisibility.byName(p.getValueAsString());
		}
	}
	
	/**
	 * Deserializer for SubmissionStatuses.
	 */
	private static class SubmissionStatusDeserializer extends JsonDeserializer<SubmissionStatus> {
		@Override
		public SubmissionStatus deserialize(final JsonParser p, final DeserializationContext ctx) throws IOException {
			return SubmissionStatus.byName(p.getValueAsString());
		}
	}
}
