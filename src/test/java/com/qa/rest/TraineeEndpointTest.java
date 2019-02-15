package com.qa.rest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.TraineeService;
import com.qa.rest.TraineeEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private TraineeEndpoint endpoint;

	@Mock
	private TraineeService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	
	public void testGetAllTrainees() {
		Mockito.when(service.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllTrainees());
	}

	@Test
	
	public void testCreateMovie() {
		Mockito.when(service.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createTrainee(MOCK_VALUE2));
		Mockito.verify(service).createTrainee(MOCK_VALUE2);
	}

	@Test
	
	public void testDeleteMovie() {
		Mockito.when(service.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteTrainee(1L));
		Mockito.verify(service).deleteTrainee(1L);
	}

}
