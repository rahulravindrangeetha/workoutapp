package com.workoutapp.model;

public class WorkOutGraphModel
{
	private double workoutMinDay;
	
	private double workoutMinWeek;
	
	private double workoutMinMonth;
	
	private CalorieBurntWeek calorieBurntWeek;
	
	private CalorieBurntMonth calorieBurntMonth;
	
	public double getWorkoutMinDay() {
		return workoutMinDay;
	}

	public void setWorkoutMinDay(double workoutMinDay) {
		this.workoutMinDay = workoutMinDay;
	}

	public double getWorkoutMinWeek() {
		return workoutMinWeek;
	}

	public void setWorkoutMinWeek(double workoutMinWeek) {
		this.workoutMinWeek = workoutMinWeek;
	}

	public double getWorkoutMinMonth() {
		return workoutMinMonth;
	}

	public void setWorkoutMinMonth(double workoutMinMonth) {
		this.workoutMinMonth = workoutMinMonth;
	}

	public CalorieBurntWeek getCalorieBurntWeek() {
		return calorieBurntWeek;
	}

	public void setCalorieBurntWeek(CalorieBurntWeek calorieBurntWeek) {
		this.calorieBurntWeek = calorieBurntWeek;
	}

	public CalorieBurntMonth getCalorieBurntMonth() {
		return calorieBurntMonth;
	}

	public void setCalorieBurntMonth(CalorieBurntMonth calorieBurntMonth) {
		this.calorieBurntMonth = calorieBurntMonth;
	}

	public CalorieBurntYear getCalorieBurntYear() {
		return calorieBurntYear;
	}

	public void setCalorieBurntYear(CalorieBurntYear calorieBurntYear) {
		this.calorieBurntYear = calorieBurntYear;
	}

	private CalorieBurntYear calorieBurntYear;

}
