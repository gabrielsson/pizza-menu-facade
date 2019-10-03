package com.gabrielsson.api;

import com.gabrielsson.model.Ingredient;
import com.gabrielsson.model.Pizza;
import com.gabrielsson.service.CityService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuApiControllerTest {

    @Test
    public void menuPost() {
        MenuApiController api = new MenuApiController(new CityService());
        List<String> ingredients = Arrays.asList("Skinka",
                "Kebabkött",
                "Köttfärs",
                "Salami",
                "Ananas",
                "Champinjoner",
                "Mozzarella",
                "Tonfisk",
                "Paprika",
                "Vitlök",
                "Basilika",
                "Kebabsås"
                );
        List<Pizza> pizzas = api.menuPost(ingredients
                .stream()
                .map(s -> new Ingredient().name(s))
                .collect(Collectors.toList()))
                .getBody();

        pizzas.forEach(pizza -> System.out.println(pizza.getName() + "\nTomat, Ost, " + pizza.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", "))));
                Assertions.assertThat(pizzas)
                        .hasSize((int) Math.pow(2,
                                ingredients.size()));
    }
}