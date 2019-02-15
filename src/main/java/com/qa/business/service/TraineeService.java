package com.qa.business.service;

public interface TraineeService {

	String createTrainee(String trainee);
	
	String getAllTrainees();
	
	String updateTrainee(String trainee,Long traineeId);
	
	String getATrainee(String option);
	
	String deleteTrainee(Long traineeId);
	
}
