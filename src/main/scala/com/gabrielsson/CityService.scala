package com.gabrielsson

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

import javax.inject.Singleton
import javax.ws.rs.core.MediaType
import javax.ws.rs.{Consumes, POST, Path, Produces}

@RegisterRestClient(configKey = "name-api")
trait CityService {

  @POST
  @Path("/name")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Produces(Array("application/json"))
  def newPizzaNames(ingredients: Array[Array[String]]): Array[String]
}