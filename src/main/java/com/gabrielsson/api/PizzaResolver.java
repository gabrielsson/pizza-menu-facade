package com.gabrielsson.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gabrielsson.model.Ingredient;
import com.gabrielsson.model.Pizza;
import com.gabrielsson.service.CityService;
import lombok.AllArgsConstructor;
import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PizzaResolver implements GraphQLQueryResolver {

    private final CityService cityService;

    public List<Pizza> pizzas(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return Collections.emptyList();
        }
        List<String> ingredientNames = ingredients.stream()
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
}
