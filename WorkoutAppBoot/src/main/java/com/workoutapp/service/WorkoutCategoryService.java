package com.workoutapp.service;

import java.util.List;
import com.workoutapp.entity.WorkoutCategory;

public interface WorkoutCategoryService 
{

	void addNewWorkoutCategory(WorkoutCategory newWorkoutCategory);
	void updateWorkoutCategory(WorkoutCategory newWorkoutCategory);
	List<WorkoutCategory> getAllWorkoutCategories();
	void deleteWorkoutCategory(int workoutCategoryId);

}
