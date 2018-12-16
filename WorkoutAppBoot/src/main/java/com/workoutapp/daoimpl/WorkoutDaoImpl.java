package com.workoutapp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.workoutapp.util.HibernateConnector;
import com.workoutapp.dao.WorkoutDao;
import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCollection;

@Repository
public class WorkoutDaoImpl implements WorkoutDao 
{

	public List<Object[]> getAllWorkout() 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        List<Object[]> workouts=sessionOne.createQuery("select WC,AW from WorkoutCollection WC left outer join WC.activeWorkouts as AW with AW.status='TRUE'").list();
	        sessionOne.getTransaction().commit();
	        return workouts;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void createNewWorkout(WorkoutCollection workout) 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
			WorkoutCollection workoutt= new WorkoutCollection();
			workoutt.setCalBurnPerMin(workout.getCalBurnPerMin());
			workoutt.setWorkoutCategory(workout.getWorkoutCategory());
			workoutt.setWorkoutNote(workout.getWorkoutNote());
			workoutt.setWorkoutTitle(workout.getWorkoutTitle());
			sessionOne.beginTransaction();
	        sessionOne.persist(workout);
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public void editWorkout(WorkoutCollection workout)
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        WorkoutCollection dbWorkout=sessionOne.load(WorkoutCollection.class, workout.getWorkoutId());
	        editWorkout(dbWorkout,workout);
	        sessionOne.clear();
	        sessionOne.update(workout);
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

	private void editWorkout(WorkoutCollection workoutDBRec, WorkoutCollection workout) 
	{
		workoutDBRec.setCalBurnPerMin(workout.getCalBurnPerMin());
		workoutDBRec.setWorkoutCategory(workout.getWorkoutCategory());
		workoutDBRec.setWorkoutNote(workout.getWorkoutNote());
		workoutDBRec.setWorkoutTitle(workout.getWorkoutTitle());		
	}

	public WorkoutCollection getWorkout(int workoutId ) 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        WorkoutCollection workout=(WorkoutCollection) sessionOne.get(WorkoutCollection.class,workoutId);
	        sessionOne.getTransaction().commit();
	        return workout;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void deleteWorkout(int workoutId)
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        org.hibernate.Query qry = sessionOne.createQuery("delete WorkoutActive WA where WA.workout.workoutId=?");
	        qry.setParameter(0,workoutId);
	        qry.executeUpdate();
	        qry = sessionOne.createQuery("delete WorkoutCollection WC where WC.workoutId=?");
	        qry.setParameter(0,workoutId);
	        qry.executeUpdate();
	        sessionOne.getTransaction().commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public WorkoutActive getActiveWorkoutRec(int workoutId) 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        String hql="SELECT workoutActive from WorkoutActive workoutActive where workoutActive.status=:status and workoutActive.workout.workoutId=:workoutId";
	        List<WorkoutActive> activeWorkout=sessionOne.createQuery(hql).setString("status", "TRUE").setInteger("workoutId", workoutId).list();
	        sessionOne.getTransaction().commit();
	        return activeWorkout.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void updateActiveWorkout(WorkoutActive workoutActiveDB,int workoutId) 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        org.hibernate.Query qry = sessionOne.createQuery("update WorkoutActive WA set WA.endDate=?, WA.endTime=?,WA.comment=?,WA.status='FALSE' where WA.workout.workoutId=? and WA.status='TRUE'");
	        			        qry.setParameter(0,workoutActiveDB.getEndDate());
	        			        qry.setParameter(1,workoutActiveDB.getEndTime());
	        			        qry.setParameter(2,workoutActiveDB.getComment());
	        			        qry.setParameter(3,workoutId);
	        			        
	        int res = qry.executeUpdate();
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void addActiveWorkout(WorkoutActive activeWorkout) 
	{
		try
		{
			Session sessionOne = HibernateConnector.getSessionFactory().openSession();
	        sessionOne.beginTransaction();
	        sessionOne.save(activeWorkout);
	        sessionOne.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
