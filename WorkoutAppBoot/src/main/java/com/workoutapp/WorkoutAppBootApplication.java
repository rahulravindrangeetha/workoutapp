package com.workoutapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.workoutapp.controller.WorkoutController;

@SpringBootApplication
public class WorkoutAppBootApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(WorkoutAppBootApplication.class, args);
	}

}

