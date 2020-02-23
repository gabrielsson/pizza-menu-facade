package com.gabrielsson;

import com.gabrielsson.model.Ingredient;
import com.gabrielsson.model.Pizza;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.Tag;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.paukov.combinatorics3.Generator;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Path("/pizzas")
public class PizzaResource {
    @Inject
    @Any
    CityService cityService;

    @Inject
    MetricRegistry registry;

    public PizzaResource() {

    }

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pizza> pizzas(List<Ingredient> ingredients) {
        registry.counter("pizza.menu.counter").inc();
        ingredients.forEach(i -> registry
                .counter("pizza.menu.ingredient.counter",
                        new Tag("ingredient", i.getName()))
                .inc());

        List<List<String>> pizzas = Generator
                .subset(ingredients.stream()
                        .skip(Math.max(0, ingredients.size() - 16))
                        .map(Ingredient::getName)
                        .collect(Collectors.toList()))
                .simple()
                .stream()
                .collect(Collectors.toList());

        List<String> names = cityService.newPizzaNames(pizzas);
        return IntStream.range(0, names.size())
                .boxed()
                .map(i -> Pizza.builder()
                        .name(names.get(i))
                        .ingredients(pizzas.get(i).stream()
                                .map(s -> Ingredient.builder()
                                        .name(s)
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

    }
}