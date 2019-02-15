package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService{

	@Inject
	private TraineeRepository repo;

	JSONUtil util;
	@Override
	public String createTrainee(String traineeId) {
		return repo.createTrainee(traineeId);
	}

	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}
	@Override
	public String updateTrainee(String trainee, Long traineeId) {
		return repo.updateTrainee(trainee, traineeId);
	}

	@Override
	public String deleteTrainee(Long traineeId) {
		return repo.deleteTrainee(traineeId);
	}

	public void setRepo(TraineeRepository repo2) {
		this.repo = repo2;
	}
	public void setUtil(JSONUtil util)
	{
		this.util = util;
	} 

	@Override
	public String getATrainee(String option) {
		return repo.getATrainee(option);
	}
	
	
}
