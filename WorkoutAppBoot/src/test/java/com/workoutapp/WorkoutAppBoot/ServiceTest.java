package com.workoutapp.WorkoutAppBoot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import com.workoutapp.dao.ReportDao;
import com.workoutapp.dao.WorkoutCategoryDao;
import com.workoutapp.dao.WorkoutDao;
import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCategory;
import com.workoutapp.entity.WorkoutCollection;
import com.workoutapp.service.ReportService;
import com.workoutapp.service.WorkoutCategoryService;
import com.workoutapp.service.WorkoutService;
import com.workoutapp.serviceimpl.ReportServiceImpl;
import com.workoutapp.serviceimpl.WorkoutCategoryServiceImpl;
import com.workoutapp.serviceimpl.WorkoutServiceImpl;



public class ServiceTest 
{
	@InjectMocks
	private WorkoutService workoutService=new WorkoutServiceImpl();
	
	@InjectMocks
	private WorkoutCategoryService workoutCategoryService=new WorkoutCategoryServiceImpl();
	
	@InjectMocks
	private ReportService reportService=new ReportServiceImpl();
	
	@Mock
	private ReportDao reportDao;
	
	@Mock
	private WorkoutDao workoutDao;
	
	@Mock
	private WorkoutCategoryDao workoutCategoryDao;
	
	private static WorkoutCategory workoutCategory1;
	
	private static WorkoutCategory workoutCategory2;
	
	private static WorkoutCollection workoutCollection1;
	
	private static WorkoutCollection workoutCollection2;
	
	private static WorkoutActive workoutActive1;
	
	private static WorkoutActive workoutActive2;
	
	private static WorkoutActive workoutActive3;
	
	private static WorkoutActive workoutActive4;
	
	
	@Before
	public void init()
	{
		initMocks(this);
		setData();
	}
	
	@Test
	public void getWorkoutDetail()
	{
		List workouts = new ArrayList();
		workouts.add(workoutCollection1);
		workouts.add(workoutCollection2);
		when(workoutDao.getAllWorkout()).thenReturn(workouts);
		List returnedData=workoutService.getAllWorkout();
		assertEquals(2, returnedData.size());
		verify(workoutDao).getAllWorkout();
		
	}
	
	@Test
	public void getAWorkoutDetail()
	{
		when(workoutDao.getWorkout(1)).thenReturn(workoutCollection1);
		WorkoutCollection workout=workoutService.getWorkout(1);
		assertEquals(workout.getWorkoutId(),1);
		assertEquals(workout.getWorkoutCategory(),workoutCategory1);
		assertEquals(workout.getWorkoutTitle(),"medium pace run");
		verify(workoutDao).getWorkout(any(Integer.class));
		
	}
	
	@Test
	public void deleteWorkout()
	{
		workoutService.deleteWorkout(1);
		verify(workoutDao).deleteWorkout(any(Integer.class));
		
	}
	
	private void setData()
	{
		workoutCategory1= new WorkoutCategory();
		workoutCategory1.setCategoryId(1);
		workoutCategory1.setCategoryName("running");
		workoutCategory2= new WorkoutCategory();
		workoutCategory2.setCategoryId(2);
		workoutCategory2.setCategoryName("cycling");
		workoutCollection1= new WorkoutCollection();
		workoutCollection1.setWorkoutId(1);
		workoutCollection1.setCalBurnPerMin(12.11f);
		workoutCollection1.setWorkoutCategory(workoutCategory1);
		workoutCollection1.setWorkoutNote("good day to run");
		workoutCollection1.setWorkoutTitle("medium pace run");
		workoutCollection2= new WorkoutCollection();
		workoutCollection2.setWorkoutId(2);
		workoutCollection2.setCalBurnPerMin(7.8f);
		workoutCollection2.setWorkoutCategory(workoutCategory2);
		workoutCollection2.setWorkoutNote("cycling yeee");
		workoutCollection2.setWorkoutTitle("cycling");
		workoutActive1 = new WorkoutActive();
		workoutActive1.setComment("runn");
		workoutActive1.setStartDate(LocalDate.parse("11-11-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		workoutActive1.setStartTime(LocalTime.parse("09:45", DateTimeFormatter.ofPattern("HH:mm")));
		workoutActive1.setWorkout(workoutCollection1);
		workoutActive1.setStatus("TRUE");
		workoutActive2 = new WorkoutActive();
		workoutActive2.setComment("runn");
		workoutActive2.setStartDate(LocalDate.parse("11-11-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		workoutActive2.setStartTime(LocalTime.parse("09:45", DateTimeFormatter.ofPattern("HH:mm")));
		workoutActive2.setWorkout(workoutCollection1);
		workoutActive2.setStatus("FALSE");
		workoutActive2.setEndDate(LocalDate.parse("11-11-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		workoutActive2.setEndTime(LocalTime.parse("10:15", DateTimeFormatter.ofPattern("HH:mm")));
		workoutActive3 = new WorkoutActive();
		workoutActive3.setComment("cycleee");
		workoutActive3.setStartDate(LocalDate.parse("14-12-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		workoutActive3.setStartTime(LocalTime.parse("05:15", DateTimeFormatter.ofPattern("HH:mm")));
		workoutActive3.setWorkout(workoutCollection2);
		workoutActive3.setStatus("TRUE");
		workoutActive4 = new WorkoutActive();
		workoutActive4.setComment("cycleee");
		workoutActive4.setStartDate(LocalDate.parse("14-12-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		workoutActive4.setStartTime(LocalTime.parse("05:15", DateTimeFormatter.ofPattern("HH:mm")));
		workoutActive4.setWorkout(workoutCollection2);
		workoutActive4.setStatus("FALSE");
		workoutActive4.setEndDate(LocalDate.parse("14-12-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		workoutActive4.setEndTime(LocalTime.parse("06:15", DateTimeFormatter.ofPattern("HH:mm")));

		
	}

}