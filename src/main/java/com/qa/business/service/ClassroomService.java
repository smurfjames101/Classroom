package com.qa.business.service;

public interface ClassroomService {
	

	String createClassroom(String classroom);

	String getAllClassrooms();
	String getAClassroom(String classroomId);
	String updateClassroom(String classroom, Long id);

	String deleteClassroom(Long id);
}
