package com.workoutapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workoutapp.model.WorkOutGraphModel;
import com.workoutapp.service.ReportService;

@RestController
@RequestMapping("/reports")
@CrossOrigin
public class ReportController 
{
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity generateReport()
	{
		WorkOutGraphModel report = reportService.generateReport();
		return new ResponseEntity(report,HttpStatus.OK);
	}

}
