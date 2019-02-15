package com.qa.business.service;

public interface TraineeService {

	String createTrainee(String trainee);
	
	String getAllTrainee();
	
	String updateTrainee(String trainee,Long traineeId);
	
	String getATrainee(String option, String contains);
	
	String deleteTrainee(Long traineeId);
	
}
