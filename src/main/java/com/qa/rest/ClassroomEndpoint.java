package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/getAClassroom/{option}")
	@GET
	@Produces({"application/json"})
	public String getAClassroom(@PathParam("option") String option)
	{
		return service.getAClassroom(option);
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({"application/json"})
	public String createClassroom(String recipe)
	{
		return service.createClassroom(recipe);
	}
	
	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClassroom(@PathParam("id") Long id)
	{
		return service.deleteClassroom(id);
	}
	
	public void setService(ClassroomService service) {
		this.service = service;
	}
	
}