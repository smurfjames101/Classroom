package com.qa.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class JAXActivator extends Application {
	public static boolean testJAX()
	{
		return true;
	}
}
