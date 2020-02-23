package com.gabrielsson;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey="name-api")
public interface CityService {

    @POST
    @Path("/name")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    List<String> newPizzaNames(List<List<String>> ingredients);
}
