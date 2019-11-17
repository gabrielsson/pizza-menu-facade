package com.gabrielsson.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gabrielsson.model.Ingredient;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngredientsResolver  implements GraphQLQueryResolver {


    public List<Ingredient> ingredients() {
        String[] ingredients = new String[]{"Kebab", "Mushrooms", "Pineapple", "Ham", "Mozzarella", "Basil"};
        return Arrays.stream(ingredients)
                .map(s -> Ingredient.builder().name(s).build())
                .collect(Collectors.toList());
    }
}
