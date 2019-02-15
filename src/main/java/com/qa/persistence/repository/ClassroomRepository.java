package com.qa.persistence.repository;

public interface ClassroomRepository {

	//C
	String createClassroom(String product);
	//R
	String getAllClassrooms();
	String getAClassroom(String option,String contains);
	//U
	String updateClassroom(String product, Long id);
	//D
	String deleteClassroom(Long id);
	
}
