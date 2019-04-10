package org.acme.rest.panache;

import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author cristhiank on 2019-04-09
 **/
@Path("/test-entity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntityRepositoryEndpoint {
	@Inject
	TestEntityRepository repository;

	@GET
	@Path("/{id}")
	public TestEntity findById(@PathParam("id") UUID id) {
		return repository.findById( id );
	}
}