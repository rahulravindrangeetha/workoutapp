package com.workoutapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workoutapp.dao.ReportDao;
import com.workoutapp.model.WorkOutGraphModel;
import com.workoutapp.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService 
{
	@Autowired
	private ReportDao reportDao;

	public WorkOutGraphModel generateReport() 
	{
		WorkOutGraphModel report = new WorkOutGraphModel();
		report.setWorkoutMinDay(reportDao.getWorkoutMinDay());
		report.setWorkoutMinWeek(reportDao.getWorkoutMinWeek());
		report.setWorkoutMinMonth(reportDao.getWorkoutMinMonth());
		report.setCalorieBurntWeek(reportDao.getCalorieBurntWeek());
		report.setCalorieBurntMonth(reportDao.getCalorieBurntMonth());
		report.setCalorieBurntYear(reportDao.getCalorieBurntYear());
		return report;
	}

	
	

}
