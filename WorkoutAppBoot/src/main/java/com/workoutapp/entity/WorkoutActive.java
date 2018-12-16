package com.workoutapp.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.workoutapp.util.LocalDateDeserializer;
import com.workoutapp.util.LocalTimeDeserializer;
import com.workoutapp.util.TimeConvertor;
import com.workoutapp.util.DateConvertor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="WORKOUT_ACTIVE")
public class WorkoutActive implements Serializable
{
	
	@Id
	@Column(name="START_TIME")
	@JsonDeserialize(using=LocalTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	//@Convert(converter=TimeConvertor.class)
	private LocalTime startTime;
	
	@Column(name="END_TIME")
	@JsonDeserialize(using=LocalTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	//@Convert(converter=TimeConvertor.class)
	private LocalTime endTime;
	
	@Column(name="START_DATE")
	@JsonDeserialize(using=LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@Convert(converter=DateConvertor.class)
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	@JsonDeserialize(using=LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@Convert(converter=DateConvertor.class)
	private LocalDate endDate;
	
	private String status;
	
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="WORKOUT_ID")
	private WorkoutCollection workout;
	
	public WorkoutCollection getWorkout() 
	{
		return workout;
	}

	public void setWorkout(WorkoutCollection workout)
	{
		this.workout = workout;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String isStatus()
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	@Override
	public String toString() 
	{
		return "WorkoutActive [startTime=" + startTime + ", endTime=" + endTime + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + ", comment=" + comment + ", workout=" + workout + "]";
	}
	
	

	
	
	

}
