package com.qa.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long traineeId;
	private String traineeName;
	
	
	public Trainee() {
		
	}
	public Trainee(Long traineeId, String traineeName) {
		this.traineeId = traineeId;
		this.traineeName = traineeName;
	}
	
	public Long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
}
