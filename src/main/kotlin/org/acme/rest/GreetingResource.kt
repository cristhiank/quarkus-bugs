package org.acme.rest

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.inject.Inject

@Path("/greeting")
class GreetingResource {

    @Inject
    lateinit var service:GreetingService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = service.helloBug()
}