package com.gabrielsson.api;

import com.gabrielsson.service.CityService;
import com.google.common.collect.ImmutableMap;
import graphql.GraphQL;
import lombok.AllArgsConstructor;
import org.paukov.combinatorics3.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@AllArgsConstructor
public class MenuProvider {

    private static final Logger log = LoggerFactory.getLogger(MenuProvider.class);
    private final CityService cityService;

    public List<Map<String, Object>> provide(List<Map<String, Object>> ingredients) {
        if(ingredients == null) {
            return Collections.emptyList();
        }
        List<String> ingredientNames = ingredients.stream()
                .map(i -> (String)i.get("name"))
                .collect(Collectors.toList());

        return Generator
                .subset(ingredientNames)
                .simple()
                .stream()
                .map(list -> {
                    List<Map<String, Object>> ingredientMap = new ArrayList<>();
                    String ingredientsString = list.stream()
                            .peek(s -> ingredientMap.add(ImmutableMap.of("name", s)))
                            .collect(Collectors.joining(","));

                    return ImmutableMap.of(
                            "ingredients", ingredientMap,
                            "name", cityService.newPizzaName(ingredientsString));
                }).collect(Collectors.toList());
    }
}
