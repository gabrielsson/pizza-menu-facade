package com.gabrielsson

import org.eclipse.microprofile.metrics.annotation.Timed
import org.eclipse.microprofile.metrics.{MetricRegistry, Tag}
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.paukov.combinatorics3.Generator

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.{Consumes, POST, Path, Produces}
import scala.collection.JavaConverters.{iterableAsScalaIterableConverter, mapAsJavaMapConverter, seqAsJavaListConverter}
import scala.collection.breakOut

@Path("/pizzas")
class PizzaResource {

  @Inject
  @RestClient
  protected var cityService: CityService = null

  @Inject
  protected var registry: MetricRegistry = _

  @POST
  @Timed
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Produces(Array(MediaType.APPLICATION_JSON))
  def pizzas(ingredients: Array[String]) = {
    registry.counter("pizza.menu.counter").inc()

    ingredients.foreach(i => registry
      .counter("pizza.menu.ingredient.counter",
        new Tag("ingredient", i))
      .inc())

    val permutations = getPermutations(ingredients)
    val names = cityService.newPizzaNames(permutations)

    (names zip permutations)(breakOut).toMap.asJava
  }

  def getPermutations(ingredients: Array[String]): Array[Array[String]] = {

    val target: java.util.List[String] = ingredients.toSeq.asJava


    val subsets = Generator.subset(target).simple().asScala.toArray


    subsets.map(_.asScala).map(_.toArray)
  }
}
