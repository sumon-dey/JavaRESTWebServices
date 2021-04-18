package com.webservices.jersey;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*URI	               HTTP Method	   Description
/person/{id}/getDummy	  GET	       Returns a dummy person object
/person/add	              POST	       Adds a person
/person/{id}/delete		  GET	       Delete the person with ‘id’ in the URI
/person/getAll		      GET	       Get all persons
/person/{id}/get	      GET	       Get the person with ‘id’ in the URI*/

@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImplementation implements PersonService {

	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

	@Override
	@POST
	@Path("/add")
	// POST - http://localhost:8080/JavaRESTWebServices/person/add
	/*
	 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?> <person>
	 * <age>30</age> <id>1</id> <name>Pankaj</name> </person>
	 */
	public Response addPerson(Person p) {
		Response response = new Response();
		if (persons.get(p.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Person already exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/delete")
	// GET - http://localhost:8080/JavaRESTWebServices/person/1/delete
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if (persons.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Person does not exist");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	// GET - http://localhost:8080/JavaRESTWebServices/person/1/get
	public Person getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}

	@GET
	@Path("/{id}/getDummy")
	// GET - http://localhost:8080/JavaRESTWebServices/person/99/getDummy
	public Person getDummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	// GET - http://localhost:8080/JavaRESTWebServices/person/getAll
	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}
