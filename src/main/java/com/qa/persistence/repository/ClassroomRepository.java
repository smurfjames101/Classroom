package com.qa.persistence.repository;

public interface ClassroomRepository {

	String createClassroom(String product);

	String getAllClassrooms();

	String updateClassroom(String classroom, Long id);

	String deleteClassroom(Long id);

	String getAClassroom(Long id);
}