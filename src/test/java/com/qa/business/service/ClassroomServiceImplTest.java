package com.qa.business.service;

import static org.junit.Assert.assertEquals;

import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomServiceImplTest {

	@InjectMocks
	ClassroomServiceImpl service;
	
	@Mock
	ClassroomRepository repo;
	
	JSONUtil util;
	private static final String MOCK_VALUE = "1";
	private static final String MOCK_OBJECT = "{\"classroomId\":1,\"trainer\":\"John Gordon\"}";

	@Before
	public void setup() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	
	@Test
	public void testCreate() {
	Mockito.when(repo.createClassroom(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
	assertEquals(MOCK_OBJECT,service.createClassroom(MOCK_OBJECT));
	Mockito.verify(repo).createClassroom(MOCK_OBJECT);
	}
	
	@Test
	public void testDelete() {
		Mockito.when(repo.deleteClassroom(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteClassroom(1L));
		Mockito.verify(repo).deleteClassroom(1L);
	}
	@Test
	public void testUpdate() {
		Mockito.when(repo.updateClassroom(MOCK_VALUE, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateClassroom(MOCK_VALUE, 1L));
		Mockito.verify(repo).updateClassroom(MOCK_VALUE, 1L);
	}

	
	@Test
	public void testGetAll() {
		Mockito.when(repo.getAllClassrooms()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllClassrooms());
	}
	@Test
	public void testGetA()	{
		Mockito.when(repo.getAClassroom(1L)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, repo.getAClassroom(1L));
	}
}
