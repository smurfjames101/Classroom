package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomDBRepositoryTest {

	@InjectMocks
	private ClassroomDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	

	private static final String MOCK_DATA_ARRAY = "[{\"classroomId\":1,\"trainer\":\"John Gordon\"}]";

	private static final String MOCK_OBJECT = "{\"classroomId\":1,\"trainer\":\"John Gordon\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllClassrooms() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classroom> classrooms = new ArrayList<Classroom>();
		classrooms.add(util.getObjectForJSON(MOCK_OBJECT, Classroom.class));
		Mockito.when(query.getResultList()).thenReturn(classrooms);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllClassrooms());
	}

	@Test
	public void testCreateClassroom() {
		String reply = repo.createClassroom(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Classroom has been added\"}");
	}

	@Test
	public void testDeleteClassroom() {
		String reply = repo.deleteClassroom(1L);
		Assert.assertEquals(reply, "{\"message\": \"Classroom sucessfully deleted\"}");
	}
	@Ignore
	@Test
	public void testUpdate() {
	}
	

}
