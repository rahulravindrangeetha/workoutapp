package com.workoutapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workoutapp.entity.WorkoutActive;
import com.workoutapp.entity.WorkoutCollection;
import com.workoutapp.service.WorkoutService;

@RestController
@RequestMapping("/workout")
@CrossOrigin
public class WorkoutController 
{
	@Autowired
	private WorkoutService workoutService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getAllWorkout()	
	{
		List<Object[]> workouts= workoutService.getAllWorkout();
		List<WorkoutCollection> workoutCollection = new ArrayList<WorkoutCollection>();
		for(Object[] data:workouts)
		{
			WorkoutCollection currentWorkout = (WorkoutCollection) data[0];
			WorkoutActive currentWorkoutActive = (WorkoutActive) data[1];
			if(currentWorkoutActive!=null)
			{
				currentWorkout.setDisabled(true);
			}
			else
			{
				currentWorkout.setDisabled(false);
			}
			
			workoutCollection.add(currentWorkout);
		}
		return new ResponseEntity(workoutCollection,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{workoutId}",method=RequestMethod.GET)
	public ResponseEntity getWorkoutDetail(@PathVariable("workoutId")int workoutId)	
	{
		WorkoutCollection workout= workoutService.getWorkout(workoutId);
		return new ResponseEntity(workout,HttpStatus.OK);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity  createNewWorkout(@RequestBody WorkoutCollection workout)
	{
		workoutService.createNewWorkout(workout);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity editWorkout(@RequestBody WorkoutCollection workout)
	{
		workoutService.editWorkout(workout);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{workoutId}",method=RequestMethod.DELETE)
	public ResponseEntity deleteWorkout(@PathVariable("workoutId") int workoutId)
	{
		workoutService.deleteWorkout(workoutId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/startWorkout/{workoutId}",method=RequestMethod.POST)
	public ResponseEntity starWorkout(@PathVariable("workoutId") int workoutId,@RequestBody WorkoutActive workoutActive)
	{
		workoutService.startWorkout(workoutActive,workoutId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/startWorkout/{workoutId}",method=RequestMethod.GET)
	public ResponseEntity getStartedWorkout(@PathVariable("workoutId") int workoutId)
	{
		WorkoutActive workoutActiveDB = workoutService.getActiveWorkoutRec(workoutId);
		return new ResponseEntity(workoutActiveDB,HttpStatus.OK);
	}
	
	@RequestMapping(value="/endWorkout/{workoutId}",method=RequestMethod.PUT)
	public ResponseEntity endWorkout(@RequestBody WorkoutActive activeWorkout,@PathVariable("workoutId") int workoutId)
	{
		WorkoutActive workoutActiveDB = workoutService.getActiveWorkoutRec(workoutId);
		addWorkoutEndData(workoutActiveDB,activeWorkout);
		workoutService.updateActiveWorkout(workoutActiveDB,workoutId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	

	private void addWorkoutEndData(WorkoutActive workoutActiveDB, WorkoutActive activeWorkout)
	{
		workoutActiveDB.setEndDate(activeWorkout.getEndDate());
		workoutActiveDB.setEndTime(activeWorkout.getEndTime());
		workoutActiveDB.setComment(activeWorkout.getComment());
		workoutActiveDB.setStatus("FALSE");
		
	}



}
