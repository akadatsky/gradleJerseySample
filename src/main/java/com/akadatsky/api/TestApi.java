package com.akadatsky.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class TestApi {

    @GET
    public Response test() {
        return Response.status(Response.Status.OK).entity("Hello!!!").build();
    }

}