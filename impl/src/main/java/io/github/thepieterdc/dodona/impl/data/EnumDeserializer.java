/*
 * Copyright (c) 2018-2019. All rights reserved.
 *
 * @author Pieter De Clercq
 * @author Tobiah Lissens
 *
 * https://github.com/thepieterdc/dodona-api-java/
 */
package io.github.thepieterdc.dodona.impl.data;

import io.github.thepieterdc.dodona.data.CourseColor;
import io.github.thepieterdc.dodona.data.SubmissionStatus;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

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
		
		if (enumClass.equals(CourseColor.class)) {
			return new CourseColorDeserializer();
		} else if (enumClass.equals(SubmissionStatus.class)) {
			return new SubmissionStatusDeserializer();
		}
		
		return super.modifyEnumDeserializer(config, type, beanDesc, deserializer);
	}
	
	/**
	 * Deserializer for CourseColors.
	 */
	private static class CourseColorDeserializer extends JsonDeserializer<CourseColor> {
		@Override
		public CourseColor deserialize(final JsonParser p, final DeserializationContext ctx) throws IOException {
			return CourseColor.byName(p.getValueAsString());
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
