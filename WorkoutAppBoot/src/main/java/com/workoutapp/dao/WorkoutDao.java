package com.workoutapp.dao;

import java.util.List;

import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCollection;

public interface WorkoutDao
{

	List<Object[]> getAllWorkout();

	void createNewWorkout(WorkoutCollection workout);

	void editWorkout(WorkoutCollection workout);

	WorkoutCollection getWorkout(int workoutId);

	void deleteWorkout(int workoutId);

	WorkoutActive getActiveWorkoutRec(int workoutId);

	void updateActiveWorkout(WorkoutActive workoutActiveDB, int workoutId);

	void addActiveWorkout(WorkoutActive activeWorkout);


}
