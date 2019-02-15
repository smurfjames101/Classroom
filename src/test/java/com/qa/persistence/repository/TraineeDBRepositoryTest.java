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

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBRepositoryTest {

	@InjectMocks
	private TraineeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	


	private static final String MOCK_DATA_ARRAY = "[{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}]";
	private static final String MOCK_OBJECT = "{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(util.getObjectForJSON(MOCK_OBJECT, Trainee.class));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}

	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Item has been added\"}");
	}

	@Test
	public void testDeleteTrainee() {
		String reply = repo.deleteTrainee(1L);
		Assert.assertEquals(reply, "{\"message\": \"Trainee Item Sucessfully Deleted\"}");
	}
	
	@Test
	public void testUpdate() {
		
	}
	

}
