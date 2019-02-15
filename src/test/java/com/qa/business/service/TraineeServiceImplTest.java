package com.qa.business.service;

import static org.junit.Assert.assertEquals;

import javax.xml.ws.Service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceImplTest {

	@InjectMocks
	TraineeServiceImpl service;
	
	@Mock
	TraineeRepository repo;
	
	JSONUtil util;
	private static final String MOCK_VALUE = "1";
	private static final String MOCK_OBJECT = "{\"traineeId\":1,\"traineeName\":\"Joe Bloggs\"}";
	
	@Before
	public void setup() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	
	@Test
	public void testCreate() {
	Mockito.when(repo.createTrainee(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
	assertEquals(MOCK_OBJECT,service.createTrainee(MOCK_OBJECT));
	Mockito.verify(repo).createTrainee(MOCK_OBJECT);
	}
	
	@Test
	public void testDelete() {
		Mockito.when(repo.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteTrainee(1L));
		Mockito.verify(repo).deleteTrainee(1L);
	}
	@Test
	public void testUpdate() {
		Mockito.when(repo.updateTrainee(MOCK_VALUE, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateTrainee(MOCK_VALUE, 1L));
		Mockito.verify(repo).updateTrainee(MOCK_VALUE, 1L);
	}
	
	@Test
	public void testGetAll() {
		Mockito.when(repo.getAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllTrainees());
	}

	@Test
	public void testGetA()	{
		Mockito.when(repo.getATrainee("1")).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, repo.getATrainee("1"));
	}
}
