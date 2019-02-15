package com.qa.persistence.repository;

public interface TraineeRepository {

	String createTrainee(String stock);
	
	String getAllTrainee();
	
	String updateTrainee(String stock,Long stockId);
	
	String deleteTrainee(Long stock);

	String getATrainee(String option, String contains);
}
