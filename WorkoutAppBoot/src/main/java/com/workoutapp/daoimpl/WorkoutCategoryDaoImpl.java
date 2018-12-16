package com.workoutapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.workoutapp.dao.WorkoutCategoryDao;
import com.workoutapp.entity.WorkoutCategory;
import com.workoutapp.util.HibernateConnector;

@Repository
public class WorkoutCategoryDaoImpl implements WorkoutCategoryDao
{

	public void addNewWorkoutCategory(WorkoutCategory newWorkoutCategory)
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        sessionOne.persist(newWorkoutCategory);
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void updateWorkoutCategory(WorkoutCategory newWorkoutCategory)
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        sessionOne.update(newWorkoutCategory);
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public List<WorkoutCategory> getAllWorkoutCategories() 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        List<WorkoutCategory> workoutCategories=sessionOne.createQuery("from WorkoutCategory").list();
	        sessionOne.getTransaction().commit();
	        return workoutCategories;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void deleteWorkoutCategory(int workoutCategoryId)
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        WorkoutCategory category = sessionOne.get(WorkoutCategory.class, workoutCategoryId);
	        sessionOne.delete(category);
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
