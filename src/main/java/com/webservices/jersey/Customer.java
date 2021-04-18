package com.webservices.jersey;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class Customer {

	@GET
	@Path("{name}/{city}")
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerInformation(@PathParam("name") String customerName,
			@PathParam("city") String customerCity) {
		System.out.println("Customer name is: " + customerName);
		System.out.println("Customer city is: " + customerCity);
		return "<h1>Hello WebServices</h1>";
	}

	@PUT
	@Path("{name}/{city}")
	public void putCustomerInformation(@PathParam("name") String customerName, @PathParam("city") String customerCity) {

	}

	@POST
	@Path("{name}/{city}")
	public void postCustomerInformation(@PathParam("name") String customerName,
			@PathParam("city") String customerCity) {

	}

	@DELETE
	@Path("{name}/{city}")
	public void deleteCustomerInformation(@PathParam("name") String customerName,
			@PathParam("city") String customerCity) {

	}

	@HEAD
	@Path("{name}/{city}")
	public void headCustomerInformation(@PathParam("name") String customerName,
			@PathParam("city") String customerCity) {

	}

}
