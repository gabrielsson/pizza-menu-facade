package com.gabrielsson.api;

public class MenuProviderTest {
/*

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
        List<Pizza> pizzas = api.provide(ingredients
                .stream()
                .map(s -> {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(s);
                    return ingredient;
                })
                .collect(Collectors.toList()));
        IntStream.range(0, pizzas.size())
                .forEach(i -> {
                    Pizza pizza = pizzas.get(i);
                    System.out.println(i + 1 + ". " +
                            pizza.getName() +
                            "\nTomat, Ost, " +
                            pizza.getIngredients()
                                    .stream()
                                    .map(Ingredient::getName)
                                    .collect(Collectors.joining(", ")));

                });

        Assertions.assertThat(pizzas)
                .hasSize((int) Math.pow(2,
                        ingredients.size()));
    }*/
}