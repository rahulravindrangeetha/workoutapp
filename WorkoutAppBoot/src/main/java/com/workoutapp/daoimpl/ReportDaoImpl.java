package com.workoutapp.daoimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.workoutapp.dao.ReportDao;
import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.model.CalorieBurntMonth;
import com.workoutapp.model.CalorieBurntWeek;
import com.workoutapp.model.CalorieBurntYear;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.DayOfWeek;
import java.time.Duration;

@Repository
public class ReportDaoImpl implements ReportDao 
{
	@Autowired
    private EntityManagerFactory entityManagerFactory;

	public double getWorkoutMinDay() 
	{
		try
		{
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	        sessionOne.beginTransaction();
	        Criteria workoutMin=sessionOne.createCriteria(WorkoutActive.class);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		    LocalDate localDate = null;
		    localDate = LocalDate.parse(LocalDate.now().toString(), formatter);
	        LocalDate sd = localDate;
	        LocalDate ed = sd.plusDays(1);
	        Criterion criterion1=Restrictions.eq("status", "FALSE");
	        Criterion criterion2=Restrictions.ge("endDate", sd);
	        Criterion criterion3=Restrictions.lt("endDate", ed);
	        Criterion criterion4=Restrictions.and(criterion1,criterion2,criterion3);
	        workoutMin.add(criterion4);
	        /*workoutMin.add(Restrictions.ge("endDate", sd)); 
	        workoutMin.add(Restrictions.lt("endDate", ed));*/
	        Projection projection1 = Projections.property("startTime");
	        Projection projection2 = Projections.property("endTime");
	        Projection projection3 = Projections.property("startDate");
	        Projection projection4 = Projections.property("endDate");
	        ProjectionList projectionList=Projections.projectionList();
	        projectionList.add(projection1);
	        projectionList.add(projection2);
	        projectionList.add(projection3);
	        projectionList.add(projection4);
	        workoutMin.setProjection(projectionList);
	        List<Object[]> workouts = workoutMin.list();
	        sessionOne.getTransaction().commit();
	        double minutes=0;
	        
	        for(Object[] workout : workouts)
	        {
	        	LocalTime startTime=(LocalTime)workout[0];
	        	LocalTime endTime=(LocalTime)workout[1];
	        	LocalDate startDate=(LocalDate)workout[2];
	        	LocalDate endDate=(LocalDate)workout[3];
	        	LocalDateTime fromdate = LocalDateTime.of(startDate.getYear(),startDate.getMonthValue(),startDate.getDayOfMonth(),startTime.getHour(),startTime.getMinute(),startTime.getSecond());
	        	LocalDateTime todate = LocalDateTime.of(endDate.getYear(),endDate.getMonthValue(),endDate.getDayOfMonth(),endTime.getHour(),endTime.getMinute(),endTime.getSecond());
	        	minutes += MINUTES.between(fromdate, todate);
	        }
	        return minutes;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public double getWorkoutMinWeek() 
	{
		try
		{
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	        sessionOne.beginTransaction();
	        Criteria workoutMin=sessionOne.createCriteria(WorkoutActive.class);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = null;
		    localDate = LocalDate.parse(LocalDate.now().toString(), formatter);
	        LocalDate sd = localDate;
	        LocalDate ed = sd.plusDays(1);
	        Criterion criterion1=Restrictions.eq("status", "FALSE");
	        Criterion criterion2=Restrictions.ge("endDate", sd.with(DayOfWeek.MONDAY));
	        Criterion criterion3=Restrictions.lt("endDate", ed);
	        Criterion criterion4=Restrictions.and(criterion1,criterion2,criterion3);
	        workoutMin.add(criterion4);
	        /*workoutMin.add(Restrictions.ge("endDate", sd)); 
	        workoutMin.add(Restrictions.lt("endDate", ed));*/
	        Projection projection1 = Projections.property("startTime");
	        Projection projection2 = Projections.property("endTime");
	        Projection projection3 = Projections.property("startDate");
	        Projection projection4 = Projections.property("endDate");
	        ProjectionList projectionList=Projections.projectionList();
	        projectionList.add(projection1);
	        projectionList.add(projection2);
	        projectionList.add(projection3);
	        projectionList.add(projection4);
	        workoutMin.setProjection(projectionList);
	        List<Object[]> workouts = workoutMin.list();
	        sessionOne.getTransaction().commit();
	        double minutes=0;
	        
	        for(Object[] workout : workouts)
	        {
	        	LocalTime startTime=(LocalTime)workout[0];
	        	LocalTime endTime=(LocalTime)workout[1];
	        	LocalDate startDate=(LocalDate)workout[2];
	        	LocalDate endDate=(LocalDate)workout[3];
	        	LocalDateTime fromdate = LocalDateTime.of(startDate.getYear(),startDate.getMonthValue(),startDate.getDayOfMonth(),startTime.getHour(),startTime.getMinute(),startTime.getSecond());
	        	LocalDateTime todate = LocalDateTime.of(endDate.getYear(),endDate.getMonthValue(),endDate.getDayOfMonth(),endTime.getHour(),endTime.getMinute(),endTime.getSecond());
	        	minutes += MINUTES.between(fromdate, todate);
	        }
	        return minutes;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public double getWorkoutMinMonth() 
	{
		try
		{
			Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	        sessionOne.beginTransaction();
	        Criteria workoutMin=sessionOne.createCriteria(WorkoutActive.class);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = null;
		    localDate = LocalDate.parse(LocalDate.now().toString(), formatter);
	        LocalDate sd = localDate;
	        LocalDate ed = sd.plusDays(1);
	        Criterion criterion1=Restrictions.eq("status", "FALSE");
	        Criterion criterion2=Restrictions.ge("endDate", sd.withDayOfMonth(1));
	        Criterion criterion3=Restrictions.lt("endDate", ed);
	        Criterion criterion4=Restrictions.and(criterion1,criterion2,criterion3);
	        workoutMin.add(criterion4);
	        /*workoutMin.add(Restrictions.ge("endDate", sd)); 
	        workoutMin.add(Restrictions.lt("endDate", ed));*/
	        Projection projection1 = Projections.property("startTime");
	        Projection projection2 = Projections.property("endTime");
	        Projection projection3 = Projections.property("startDate");
	        Projection projection4 = Projections.property("endDate");
	        ProjectionList projectionList=Projections.projectionList();
	        projectionList.add(projection1);
	        projectionList.add(projection2);
	        projectionList.add(projection3);
	        projectionList.add(projection4);
	        workoutMin.setProjection(projectionList);
	        List<Object[]> workouts = workoutMin.list();
	        sessionOne.getTransaction().commit();
	        double minutes=0;
	        
	        for(Object[] workout : workouts)
	        {
	        	LocalTime startTime=(LocalTime)workout[0];
	        	LocalTime endTime=(LocalTime)workout[1];
	        	LocalDate startDate=(LocalDate)workout[2];
	        	LocalDate endDate=(LocalDate)workout[3];
	        	LocalDateTime fromdate = LocalDateTime.of(startDate.getYear(),startDate.getMonthValue(),startDate.getDayOfMonth(),startTime.getHour(),startTime.getMinute(),startTime.getSecond());
	        	LocalDateTime todate = LocalDateTime.of(endDate.getYear(),endDate.getMonthValue(),endDate.getDayOfMonth(),endTime.getHour(),endTime.getMinute(),endTime.getSecond());
	        	minutes += MINUTES.between(fromdate, todate);
	        }
	        return minutes;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public CalorieBurntWeek getCalorieBurntWeek() 
	{
		try
		{
			CalorieBurntWeek calorieBurntWeek= new CalorieBurntWeek();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		      LocalDate localDate = null;
		      localDate = LocalDate.parse(LocalDate.now().with(DayOfWeek.MONDAY).toString(), formatter);
		      Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	        sessionOne.beginTransaction();
	        Query query = sessionOne.createSQLQuery("SELECT SUM(DATA_VAL.CALORIE_BURNT) AS CALORIE_BURNT, DAYNAME(DATA_VAL.END_DATE) AS DAY FROM( " + 
	        		"SELECT WC.calories_burn_per_min * TIMESTAMPDIFF(MINUTE,CONCAT(DATE_FORMAT(WA.START_DATE,'%Y-%m-%d'),' ',DATE_FORMAT(WA.START_TIME,'%T')),CONCAT(DATE_FORMAT(WA.END_DATE,'%Y-%m-%d'),' ',DATE_FORMAT(WA.END_TIME,'%T'))) AS CALORIE_BURNT,WA.END_DATE " + 
	        		"FROM WORKOUT_ACTIVE WA,WORKOUT_COLLECTION WC WHERE WC.WORKOUT_ID=WA.WORKOUT_ID AND WA.STATUS='FALSE' AND WA.END_DATE >= '"+localDate.toString()+"') AS DATA_VAL  GROUP BY DAY " + 
	        		"");
	        
	        List<Object[]> records=query.list();	        
	        sessionOne.getTransaction().commit();
	        double minutes=0;
	        for(Object[] record : records)
	        {
	        	switch(record[1].toString())
	        	{
	        	case "Monday":calorieBurntWeek.setMon(Double.parseDouble(record[0].toString()));
	        					break;
	        	case "Tuesday":calorieBurntWeek.setTue(Double.parseDouble(record[0].toString()));
				break;
	        	case "Wednesday":calorieBurntWeek.setWed(Double.parseDouble(record[0].toString()));
				break;
	        	case "Thursday":calorieBurntWeek.setThu(Double.parseDouble(record[0].toString()));
				break;
	        	case "Friday":calorieBurntWeek.setFri(Double.parseDouble(record[0].toString()));
				break;
	        	case "Saturday":calorieBurntWeek.setSat(Double.parseDouble(record[0].toString()));
				break;
	        	case "Sunday":calorieBurntWeek.setSun(Double.parseDouble(record[0].toString()));
				break;					        	
	        	}
	        }
	        return calorieBurntWeek;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	public CalorieBurntMonth getCalorieBurntMonth() 
	{
		try
		{
			CalorieBurntMonth calorieBurntMonth= new CalorieBurntMonth();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		      LocalDate localDate = null;
		      localDate = LocalDate.parse(LocalDate.now().withDayOfMonth(1).toString(), formatter);
		      Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	        sessionOne.beginTransaction();
	        Query query = sessionOne.createSQLQuery("SELECT SUM(DATA_VAL.CALORIE_BURNT) AS CALORIE_BURNT, WEEK(DATA_VAL.END_DATE)-WEEK(DATE_ADD(DATE_ADD(LAST_DAY(DATA_VAL.END_DATE),INTERVAL 1 DAY),INTERVAL - 1 MONTH))+  1 AS WEEK_VAL FROM( " + 
	        		"SELECT WC.calories_burn_per_min * TIMESTAMPDIFF(MINUTE,CONCAT(DATE_FORMAT(WA.START_DATE,'%Y-%m-%d'),' ',DATE_FORMAT(WA.START_TIME,'%T')),CONCAT(DATE_FORMAT(WA.END_DATE,'%Y-%m-%d'),' ',DATE_FORMAT(WA.END_TIME,'%T'))) AS CALORIE_BURNT,WA.END_DATE " + 
	        		"FROM WORKOUT_ACTIVE WA,WORKOUT_COLLECTION WC WHERE WC.WORKOUT_ID=WA.WORKOUT_ID AND WA.STATUS='FALSE' AND WA.END_DATE >= '"+localDate.toString()+"') AS DATA_VAL  GROUP BY WEEK_VAL " + 
	        		""); 
	        
	        List<Object[]> records=query.list();	        
	        sessionOne.getTransaction().commit();
	        double minutes=0;
	        for(Object[] record : records)
	        {
	        	switch(record[1].toString())
	        	{
	        	case "1":calorieBurntMonth.setWeek1(Double.parseDouble(record[0].toString()));
	        					break;
	        	case "2":calorieBurntMonth.setWeek2(Double.parseDouble(record[0].toString()));
				break;
	        	case "3":calorieBurntMonth.setWeek3(Double.parseDouble(record[0].toString()));
				break;
	        	case "4":calorieBurntMonth.setWeek4(Double.parseDouble(record[0].toString()));
				break;
	        	case "5":calorieBurntMonth.setWeek5(Double.parseDouble(record[0].toString()));
				break;				        	
	        	}
	        }
	        return calorieBurntMonth;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}

	public CalorieBurntYear getCalorieBurntYear() 
	{
		try
		{
			CalorieBurntYear calorieBurntYear= new CalorieBurntYear();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		      LocalDate localDate = null;
		      localDate = LocalDate.parse(LocalDate.now().withDayOfYear(1).toString(), formatter);
		      Session sessionOne = entityManagerFactory.unwrap(SessionFactory.class).openSession();
	        sessionOne.beginTransaction();
	        Query query = sessionOne.createSQLQuery("SELECT SUM(DATA_VAL.CALORIE_BURNT) AS CALORIE_BURNT, MONTH(DATA_VAL.END_DATE) AS MONTH FROM( " + 
	        		"SELECT WC.calories_burn_per_min * TIMESTAMPDIFF(MINUTE,CONCAT(DATE_FORMAT(WA.START_DATE,'%Y-%m-%d'),' ',DATE_FORMAT(WA.START_TIME,'%T')),CONCAT(DATE_FORMAT(WA.END_DATE,'%Y-%m-%d'),' ',DATE_FORMAT(WA.END_TIME,'%T'))) AS CALORIE_BURNT,WA.END_DATE " + 
	        		"FROM WORKOUT_ACTIVE WA,WORKOUT_COLLECTION WC WHERE WC.WORKOUT_ID=WA.WORKOUT_ID AND WA.STATUS='FALSE' AND WA.END_DATE >= '"+localDate.toString()+"') AS DATA_VAL  GROUP BY MONTH " + 
	        		""); 
	        
	        List<Object[]> records=query.list();	        
	        sessionOne.getTransaction().commit();
	        double minutes=0;
	        for(Object[] record : records)
	        {
	        	switch(record[1].toString())
	        	{
	        	case "1":calorieBurntYear.setOne(Double.parseDouble(record[0].toString()));
	        					break;
	        	case "2":calorieBurntYear.setTwo(Double.parseDouble(record[0].toString()));
				break;
	        	case "3":calorieBurntYear.setThree(Double.parseDouble(record[0].toString()));
				break;
	        	case "4":calorieBurntYear.setFour(Double.parseDouble(record[0].toString()));
				break;
	        	case "5":calorieBurntYear.setFive(Double.parseDouble(record[0].toString()));
				break;	
	        	case "6":calorieBurntYear.setSix(Double.parseDouble(record[0].toString()));
				break;
	        	case "7":calorieBurntYear.setSeven(Double.parseDouble(record[0].toString()));
				break;
	        	case "8":calorieBurntYear.setEight(Double.parseDouble(record[0].toString()));
				break;
	        	case "9":calorieBurntYear.setNine(Double.parseDouble(record[0].toString()));
				break;
	        	case "10":calorieBurntYear.setTen(Double.parseDouble(record[0].toString()));
				break;
	        	case "11":calorieBurntYear.setEleven(Double.parseDouble(record[0].toString()));
				break;
	        	case "12":calorieBurntYear.setTwelve(Double.parseDouble(record[0].toString()));
				break;
	        	}
	        }
	        return calorieBurntYear;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}}
