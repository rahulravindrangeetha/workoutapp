package com.workoutapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workoutapp.dao.WorkoutDao;
import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCollection;
import com.workoutapp.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService 
{
	@Autowired
	private WorkoutDao workoutDao;

	public List<Object[]> getAllWorkout() 
	{
		// TODO Auto-generated method stub
		return workoutDao.getAllWorkout();
	}

	public void createNewWorkout(WorkoutCollection workout)
	{
		workoutDao.createNewWorkout(workout);
		
	}

	public void editWorkout(WorkoutCollection workout) 
	{
		workoutDao.editWorkout(workout);
		
	}

	public WorkoutCollection getWorkout(int workoutId)
	{
		return workoutDao.getWorkout(workoutId);
		 
	}

	public void deleteWorkout(int workoutId) 
	{
		workoutDao.deleteWorkout(workoutId);
		
	}

	public void startWorkout(WorkoutActive activeWorkout,int workoutId)
	{
		WorkoutCollection collection = getWorkout(workoutId);
		activeWorkout.setWorkout(collection);
		workoutDao.addActiveWorkout(activeWorkout);
		
	}

	public WorkoutActive getActiveWorkoutRec(int workoutId)
	{
		return workoutDao.getActiveWorkoutRec(workoutId);
	}

	public void updateActiveWorkout(WorkoutActive workoutActiveDB,int workoutId)
	{
		workoutDao.updateActiveWorkout(workoutActiveDB,workoutId);
		
	}

}
