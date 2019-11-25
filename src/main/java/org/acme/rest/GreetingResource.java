package org.acme.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/bug")
public class GreetingResource {
	@Inject
	EntityManager manager;

	@POST
	@Transactional
	public String test() {
		var entity = TestEntity.of( "ID", "TEST NAME" );
		manager.persist( entity );
		return "DONE";
	}
}