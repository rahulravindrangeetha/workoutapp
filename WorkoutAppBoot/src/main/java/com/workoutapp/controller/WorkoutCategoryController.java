package com.workoutapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workoutapp.entity.WorkoutCategory;
import com.workoutapp.service.WorkoutCategoryService;

@RestController
@RequestMapping("/workoutcategory")
@CrossOrigin
public class WorkoutCategoryController 
{
	@Autowired
	private WorkoutCategoryService workoutCategoryService;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity addNewWorkoutCategory(@RequestBody WorkoutCategory newWorkoutCategory) 
	{
		workoutCategoryService.addNewWorkoutCategory(newWorkoutCategory);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity updateWorkoutCategory(@RequestBody WorkoutCategory updatedWorkoutCategory) 
	{
		workoutCategoryService.updateWorkoutCategory(updatedWorkoutCategory);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getAllWorkoutCategories() 
	{
		List<WorkoutCategory> workoutCategories=workoutCategoryService.getAllWorkoutCategories();
		return new ResponseEntity(workoutCategories,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{workoutCategoryId}",method=RequestMethod.DELETE)
	public ResponseEntity deleteWorkoutCategory(@PathVariable("workoutCategoryId") int workoutCategoryId) 
	{
		workoutCategoryService.deleteWorkoutCategory(workoutCategoryId);
		return new ResponseEntity(HttpStatus.OK);
	}

}
