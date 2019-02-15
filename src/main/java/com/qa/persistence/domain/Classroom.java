package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomId;
	private String trainer;
	
	@OneToMany
    @JoinColumn(name="trainee_id")
	private Trainee trainee;
	
	public Classroom() {
		
	}
	
	public Classroom(Long classroomId, String trainer) {
		super();
		this.classroomId = classroomId;
		this.trainer =trainer;
	}
	
	
	
	public Long getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

}
