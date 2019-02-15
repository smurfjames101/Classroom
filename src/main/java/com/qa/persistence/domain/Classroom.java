package com.qa.persistence.domain;

import java.util.List;

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
	
	@OneToMany(mappedBy = "classroom")
	private List<Trainee> trainees;
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
	 public List<Trainee> getBooks() {
	        return trainees;
	    }

	    public void setBooks(List<Trainee> trainees) {
	        this.trainees = trainees;
	    }
}
