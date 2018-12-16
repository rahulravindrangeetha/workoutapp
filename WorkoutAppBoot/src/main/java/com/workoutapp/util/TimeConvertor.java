package com.workoutapp.util;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

@Converter(autoApply=true)
public class TimeConvertor implements AttributeConverter<LocalTime, Time> 
{
	public Time convertToDatabaseColumn(LocalTime localTime) 
	{
		if(localTime==null)
		{
			return null;
		}
		else
		{
			return Time.valueOf(localTime);
		}
	}

	public LocalTime convertToEntityAttribute(Time time)
	{
		if(time!=null)
		{
			return time.toLocalTime();
		}
		else
		{
			return null;
		}
		
	}


}
