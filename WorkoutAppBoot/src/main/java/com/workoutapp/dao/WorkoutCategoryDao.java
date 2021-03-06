package com.workoutapp.dao;

import java.util.List;

import com.workoutapp.entity.WorkoutCategory;

public interface WorkoutCategoryDao 
{

	void addNewWorkoutCategory(WorkoutCategory newWorkoutCategory);
	
	void updateWorkoutCategory(WorkoutCategory newWorkoutCategory);

	List<WorkoutCategory> getAllWorkoutCategories();

	void deleteWorkoutCategory(int workoutCategoryId);

}
