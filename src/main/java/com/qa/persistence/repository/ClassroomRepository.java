package com.qa.persistence.repository;

public interface ClassroomRepository {


	String createClassroom(String product);

	String getAllClassrooms();
	String getAClassroom(String option);

	String updateClassroom(String product, Long id);

	String deleteClassroom(Long id);
	
}
