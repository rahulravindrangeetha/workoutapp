package com.workoutapp.service;

import java.util.List;

import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCollection;

public interface WorkoutService 
{
	public List<Object[]> getAllWorkout();

	public void createNewWorkout(WorkoutCollection workout);

	public void editWorkout(WorkoutCollection workout);

	public WorkoutCollection getWorkout(int workoutId);

	public void deleteWorkout(int workoutId);

	public void startWorkout(WorkoutActive workoutActive, int workoutId);

	public WorkoutActive getActiveWorkoutRec(int workoutId);

	public void updateActiveWorkout(WorkoutActive workoutActiveDB, int workoutId);
}
