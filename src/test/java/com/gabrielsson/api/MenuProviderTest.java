package com.gabrielsson.api;

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
        MenuProvider api = new MenuProvider(cityService);
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
        List<Map<String, Object>> name = ingredients
                .stream()
                .map(s -> ImmutableMap.of("name", (Object) s))
                .collect(Collectors.toList());
        List<Map<String, Object>> pizzas = api.provide(name);

        IntStream.range(0, pizzas.size())
                .forEach(i -> {
                    Map<String, Object> pizza = pizzas.get(i);
                    System.out.println(i + 1 + ". " +
                            pizza.get("name") +
                            "\nTomat, Ost, " +
                            pizza.get("ingredients")
                    );

                });

        Assertions.assertThat(pizzas)
                .hasSize((int) Math.pow(2,
                        ingredients.size()));
    }
}