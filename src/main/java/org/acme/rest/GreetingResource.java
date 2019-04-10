package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bug")
public class GreetingResource {

	@Inject
	GreetingService service;
	@Inject
	OtherService otherService;

	@GET
	@Path("/1575")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloBug1575() {
		return service.helloBug1575();
	}

	@GET
	@Path("/1650")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloBug1650() {
		return otherService.helloBug1650();
	}
}