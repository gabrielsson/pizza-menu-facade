package com.gabrielsson.api;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class IngredientsProvider {

    private static final Logger log = LoggerFactory.getLogger(IngredientsProvider.class);

    public List<Map<String, String>> provide() {
        String[] ingredients = new String[]{"Kebab", "Mushrooms", "Pineapple", "Ham", "Mozzarella", "Basil"};
        List<Map<String, String>> list = new ArrayList();

        Arrays.stream(ingredients).forEach(name -> list.add(getIngredient(name)));

        return list;
    }

    private ImmutableMap<String, String> getIngredient(String name) {
        return ImmutableMap.of("name", name);
    }
}
