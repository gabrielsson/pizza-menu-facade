package com.gabrielsson.api;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IngredientsProvider {

    private static final Logger log = LoggerFactory.getLogger(IngredientsProvider.class);

    public List<Map<String, String>> provide() {
        String[] ingredients = new String[]{"Kebab", "Mushrooms", "Pineapple", "Ham", "Mozzarella", "Basil"};
        return Arrays.stream(ingredients)
                .map(this::ingredientMap)
                .collect(Collectors.toList());
    }

    private ImmutableMap<String, String> ingredientMap(String name) {
        return ImmutableMap.of("name", name);
    }
}
