package com.workoutapp.WorkoutAppBoot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.workoutapp.dao.ReportDao;
import com.workoutapp.dao.WorkoutCategoryDao;
import com.workoutapp.dao.WorkoutDao;
import com.workoutapp.daoimpl.ReportDaoImpl;
import com.workoutapp.daoimpl.WorkoutCategoryDaoImpl;
import com.workoutapp.daoimpl.WorkoutDaoImpl;
import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCategory;
import com.workoutapp.entity.WorkoutCollection;
import com.workoutapp.service.ReportService;
import com.workoutapp.service.WorkoutCategoryService;
import com.workoutapp.service.WorkoutService;
import com.workoutapp.serviceimpl.ReportServiceImpl;
import com.workoutapp.serviceimpl.WorkoutCategoryServiceImpl;
import com.workoutapp.serviceimpl.WorkoutServiceImpl;

//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
//@EnableConfigurationProperties
//@TestPropertySource(locations = "classpath:application-test.properties")
//@PropertySource("classpath:application-test.properties")
@SpringBootTest
public class DaoTest
{
	@InjectMocks
	private WorkoutDao workoutDao=new WorkoutDaoImpl();
	
	@InjectMocks
	private WorkoutCategoryDao workoutCategoryDao=new WorkoutCategoryDaoImpl();
	
	@InjectMocks
	private ReportDao reportDao=new ReportDaoImpl();
	
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
		workoutDao.getAllWorkout();
		assertEquals(2, workoutDao.getAllWorkout().size());		
	}
	
	@Test
	public void getAWorkoutDetail()
	{
		WorkoutCollection workout = workoutDao.getWorkout(1);
		assertEquals(workout.getWorkoutId(),1);
		assertEquals(workout.getWorkoutCategory().getCategoryId(),1);
		assertEquals(workout.getWorkoutTitle(),"RUNNING");
		assertEquals(workout.getWorkoutNote(),"HELLO2");
		assertEquals(workout.getCalBurnPerMin(),11.5);		
	}
	
	/*@Test
	public void deleteWorkout()
	{
		workoutService.deleteWorkout(1);
		verify(workoutDao).deleteWorkout(any(Integer.class));
		
	}
	
	@Test
	public void addWorkout()
	{
		workoutService.createNewWorkout(workoutCollection1);
		verify(workoutDao).createNewWorkout(any(WorkoutCollection.class));
		
	}
	
	@Test
	public void updateWorkout()
	{
		workoutService.editWorkout(workoutCollection1);
		verify(workoutDao).editWorkout(any(WorkoutCollection.class));
		
	}
	
	@Test
	public void getaWorkoutActiveRec()
	{
		when(workoutDao.getActiveWorkoutRec(1)).thenReturn(workoutActive1);
		WorkoutActive activeRec=workoutService.getActiveWorkoutRec(1);
		assertEquals(activeRec.getWorkout().getWorkoutId(),1);
		assertEquals(activeRec.getComment(),"runn");
		verify(workoutDao).getActiveWorkoutRec(any(Integer.class));
		
	}
	
	@Test
	public void startAWorkout()
	{

		workoutService.startWorkout(workoutActive1, 1);
		verify(workoutDao).addActiveWorkout(any(WorkoutActive.class));
		
	}
	
	@Test
	public void updateAWorkout()
	{

		workoutService.updateActiveWorkout(workoutActive2, 1);
		verify(workoutDao).updateActiveWorkout((any(WorkoutActive.class)), any(Integer.class));
		
	}
	
	@Test
	public void getAllCategories()
	{

		List workoutCategories = new ArrayList();
		workoutCategories.add(workoutCategory1);
		workoutCategories.add(workoutCategory2);
		when(workoutCategoryDao.getAllWorkoutCategories()).thenReturn(workoutCategories);
		List returnedData=workoutCategoryService.getAllWorkoutCategories();
		assertEquals(2, returnedData.size());
		verify(workoutCategoryDao).getAllWorkoutCategories();
	}
	
	@Test
	public void createCategoryTest()
	{

		workoutCategoryService.addNewWorkoutCategory(workoutCategory1);
		verify(workoutCategoryDao).addNewWorkoutCategory(any(WorkoutCategory.class));
	}
	
	@Test
	public void updateCategoryTest()
	{

		workoutCategoryService.updateWorkoutCategory(workoutCategory1);
		verify(workoutCategoryDao).updateWorkoutCategory(any(WorkoutCategory.class));
	}
	
	
	@Test
	public void deleteCategoryTest()
	{

		workoutCategoryService.deleteWorkoutCategory(1);
		verify(workoutCategoryDao).deleteWorkoutCategory(any(Integer.class));
	}
	
	@Test
	public void generateReportTest()
	{

		reportService.generateReport();
		verify(reportDao).getCalorieBurntMonth();
		verify(reportDao).getCalorieBurntWeek();
		verify(reportDao).getCalorieBurntYear();
		verify(reportDao).getWorkoutMinDay();
		verify(reportDao).getWorkoutMinMonth();
		verify(reportDao).getWorkoutMinWeek();
	
	}*/
	
	private void setData()
	{

		workoutCategory1= new WorkoutCategory();
		workoutCategory1.setCategoryId(1);
		workoutCategory1.setCategoryName("RUNNING");
		workoutCategory2= new WorkoutCategory();
		workoutCategory2.setCategoryId(2);
		workoutCategory2.setCategoryName("SWIMMING");
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
