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

import com.qa.business.service.ClassroomService;
import com.qa.rest.ClassroomEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private ClassroomEndpoint endpoint;

	@Mock
	private ClassroomService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	
	public void testGetAllClassrooms() {
		Mockito.when(service.getAllClassrooms()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllClassrooms());
	}

	@Test
	
	public void testCreateClassroom() {
		Mockito.when(service.createClassroom(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createClassroom(MOCK_VALUE2));
		Mockito.verify(service).createClassroom(MOCK_VALUE2);
	}

	@Test
	public void testGetAClassroom()
	{
		Mockito.when(service.getAClassroom(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAClassroom(1L));
	}
	@Test
	public void testDeleteClassroom() {
		Mockito.when(service.deleteClassroom(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteClassroom(1L));
		Mockito.verify(service).deleteClassroom(1L);
	}

}
