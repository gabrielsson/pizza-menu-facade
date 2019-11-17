package com.gabrielsson.api;

import com.gabrielsson.model.Ingredient;
import com.gabrielsson.model.Pizza;
import com.gabrielsson.service.CityService;
import com.google.common.collect.ImmutableMap;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;

public class MenuProviderTest {


    @Test
    public void menuPost() {
        CityService cityService = Mockito.mock(CityService.class);
        Mockito.when(cityService.newPizzaName(any())).thenReturn("Dummy");
        PizzaResolver api = new PizzaResolver(cityService);
        List<String> ingredients = Arrays.asList(
                "Skinka",
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
        List<Ingredient> name = ingredients
                .stream()
                .map(s -> Ingredient.builder().name(s).build())
                .collect(Collectors.toList());
        List<Pizza> pizzas = api.pizzas(name);

        IntStream.range(0, pizzas.size())
                .forEach(i -> {
                    Pizza pizza = pizzas.get(i);
                    System.out.println(i + 1 + ". " +
                            pizza.getName() +
                            "\nTomat, Ost, " +
                            pizza.getIngredients().toString()
                    );

                });

        Assertions.assertThat(pizzas)
                .hasSize((int) Math.pow(2,
                        ingredients.size()));
    }
}