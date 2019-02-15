package com.qa.persistence.repository;

public interface TraineeRepository {

	String createTrainee(String trainee);
	
	String getAllTrainees();
	
	String updateTrainee(String trainee,Long traineeId);
	
	String deleteTrainee(Long trainee);

	String getATrainee(Long id);
}
