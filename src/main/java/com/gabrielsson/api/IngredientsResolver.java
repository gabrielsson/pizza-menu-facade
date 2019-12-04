package com.gabrielsson.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gabrielsson.model.Ingredient;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngredientsResolver implements GraphQLQueryResolver {

    @Timed
    public List<Ingredient> ingredients() {
        String[] ingredients = new String[]{"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra cheese",
                "Black olives", "Green peppers", "Pineapple", "Spinach", "Garlic", "Basil", "Buffalo Mozzarella",
                "Sun-Dried Tomatoes", "Prosciutto"};
        return Arrays.stream(ingredients)
                .map(s -> Ingredient.builder().name(s).build())
                .collect(Collectors.toList());
    }
}
