package com.gabrielsson

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs.{GET, Path, Produces}

@Path("/ingredients")
@Produces(Array[String](MediaType.APPLICATION_JSON))
class IngredientsResource {

  @GET
  def ingredients(): Array[String] =
    Array("Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra cheese",
      "Black olives", "Green peppers", "Pineapple", "Spinach", "Garlic", "Basil", "Buffalo Mozzarella",
      "Sun-Dried Tomatoes", "Prosciutto")
}
