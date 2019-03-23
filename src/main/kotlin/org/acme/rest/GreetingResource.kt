package org.acme.rest

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/bug")
class GreetingResource {

    @Inject
    lateinit var service: GreetingService
    @Inject
    lateinit var otherService: OtherService

    @GET
    @Path("/1575")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloBug1575() = service.helloBug1575()

    @GET
    @Path("/1650")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloBug1650() = otherService.helloBug1650()
}