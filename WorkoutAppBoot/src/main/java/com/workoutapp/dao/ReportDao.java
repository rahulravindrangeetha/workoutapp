package com.workoutapp.dao;

import com.workoutapp.model.CalorieBurntMonth;
import com.workoutapp.model.CalorieBurntWeek;
import com.workoutapp.model.CalorieBurntYear;

public interface ReportDao 
{

	double getWorkoutMinDay();

	double getWorkoutMinWeek();

	double getWorkoutMinMonth();

	CalorieBurntWeek getCalorieBurntWeek();

	CalorieBurntMonth getCalorieBurntMonth();

	CalorieBurntYear getCalorieBurntYear();

}
