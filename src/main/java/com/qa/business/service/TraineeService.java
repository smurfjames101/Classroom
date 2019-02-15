package com.qa.business.service;

public interface TraineeService {

	String createTrainee(String trainee);
	
	String getAllTrainees();
	
	String updateTrainee(String trainee,Long traineeId);

	
	String deleteTrainee(Long traineeId);

	String getATrainee(Long option);
	
}
