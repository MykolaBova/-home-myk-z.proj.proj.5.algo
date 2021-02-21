package org.acme.getting.started;

//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.jboss.resteasy.annotations.jaxrs.PathParam;
//
//import javax.inject.Inject;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.SecurityContext;

///import com.apollocurrency.dfs.api.v2.dto.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Inject AuthApiService service1;

    @POST
    @Path("/login")
//    @Consumes({ "application/json" })
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces({ "application/json" })
    @Produces(MediaType.APPLICATION_JSON)
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "401", description = "Unauthorized Error, cause bad credentials"),
//            @ApiResponse(responseCode = "200", description = "Return the access token", content = @Content(schema = @Schema(implementation = AuthResponse.class))) })

//    public Response loginUser(@Parameter(description = "Credentials for user login" ,required=true)
//                                          AuthRequest body,
//                              @Context SecurityContext securityContext)
//            throws NotFoundException {
    public Response loginUser(
                AuthRequest body)
            throws NotFoundException {

        return service1.loginUser(body,null);
    }

}