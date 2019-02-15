package com.qa.business.service;

public interface ClassroomService {
	
	//C
	String createClassroom(String classroom);
	//R
	String getAllClassrooms();
	String getAClassroom(String classroomId, String contains);
	//U
	String updateClassroom(String classroom, Long id);
	//D
	String deleteClassroom(Long id);
}
