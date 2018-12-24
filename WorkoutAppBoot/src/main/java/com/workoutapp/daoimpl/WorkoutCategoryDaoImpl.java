package com.workoutapp.daoimpl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.workoutapp.dao.WorkoutCategoryDao;
import com.workoutapp.entity.WorkoutCategory;

@Repository
public class WorkoutCategoryDaoImpl implements WorkoutCategoryDao
{
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void addNewWorkoutCategory(WorkoutCategory newWorkoutCategory)
	{
		try
		{
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
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
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
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
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
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
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
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
