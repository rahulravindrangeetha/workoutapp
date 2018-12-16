package com.workoutapp.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime>
{
		@Override
		public LocalTime deserialize(JsonParser parser, DeserializationContext arg1)
				throws IOException, JsonProcessingException 
		{
			// TODO Auto-generated method stub
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		      LocalTime localTime = null;
		      localTime = LocalTime.parse(parser.getText(), formatter);
		      return localTime;
		}
}


