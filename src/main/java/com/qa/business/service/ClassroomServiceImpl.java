package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService{
	
	@Inject
	private ClassroomRepository repo;
	private JSONUtil util;
	
	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	@Override
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String getAClassroom(String option) {
		return repo.getAClassroom(option);
	}

	@Override
	public String updateClassroom(String classroom, Long id) {
		return repo.updateClassroom(classroom, id);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

	public void setRepo(ClassroomRepository repo2) {
		this.repo = repo2;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
