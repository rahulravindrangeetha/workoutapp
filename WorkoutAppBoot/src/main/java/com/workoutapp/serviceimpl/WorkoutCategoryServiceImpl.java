package com.workoutapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workoutapp.dao.WorkoutCategoryDao;
import com.workoutapp.entity.WorkoutCategory;
import com.workoutapp.service.WorkoutCategoryService;

@Service
public class WorkoutCategoryServiceImpl implements WorkoutCategoryService 
{
	@Autowired
	private WorkoutCategoryDao  workoutCategoryDao;

	public void addNewWorkoutCategory(WorkoutCategory newWorkoutCategory) 
	{
		workoutCategoryDao.addNewWorkoutCategory(newWorkoutCategory);
		
	}

	public void updateWorkoutCategory(WorkoutCategory newWorkoutCategory) 
	{
		workoutCategoryDao.updateWorkoutCategory(newWorkoutCategory);
		
	}

	public List<WorkoutCategory> getAllWorkoutCategories()
	{
		// TODO Auto-generated method stub
		return workoutCategoryDao.getAllWorkoutCategories();
	}

	public void deleteWorkoutCategory(int workoutCategoryId) 
	{
		workoutCategoryDao.deleteWorkoutCategory(workoutCategoryId);
	}

}
