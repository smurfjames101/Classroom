package com.qa.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.rest.JAXActivator;

public class JAXActivatorTest {

	@Test
	public void testJAX() {
		assertTrue(JAXActivator.testJAX());
	}
}
