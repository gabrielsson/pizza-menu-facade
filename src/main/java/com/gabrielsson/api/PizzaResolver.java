package com.gabrielsson.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gabrielsson.model.Ingredient;
import com.gabrielsson.model.Pizza;
import com.gabrielsson.service.CityService;
import lombok.AllArgsConstructor;
import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class PizzaResolver implements GraphQLQueryResolver {

    private final CityService cityService;

    public List<Pizza> pizzasSlow(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return Collections.emptyList();
        }
        List<String> ingredientNames = ingredients.stream()
                .skip(Math.max(0, ingredients.size() - 16))
                .map(Ingredient::getName)
                .collect(Collectors.toList());

        return Generator
                .subset(ingredientNames)
                .simple()
                .stream()
                .map(list -> {
                    List<Ingredient> ingredientList = list.stream()
                            .map(s -> Ingredient.builder().name(s).build())
                            .collect(Collectors.toList());

                    return Pizza.builder().ingredients(ingredientList)
                            .name(cityService
                                    .newPizzaName(ingredientList.stream()
                                            .map(Ingredient::getName)
                                            .collect(Collectors.joining(","))))
                            .build();
                }).collect(Collectors.toList());
    }

    public List<Pizza> pizzas(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return Collections.emptyList();
        }
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
