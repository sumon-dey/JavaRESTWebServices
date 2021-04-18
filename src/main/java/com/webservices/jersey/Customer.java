package com.webservices.jersey;

import javax.ws.rs.GET;
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

}
