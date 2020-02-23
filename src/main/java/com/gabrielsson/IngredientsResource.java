package com.gabrielsson;

import com.gabrielsson.model.Ingredient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/ingredients")
public class IngredientsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ingredient> ingredients() {
        String[] ingredients = new String[]{"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra cheese",
                "Black olives", "Green peppers", "Pineapple", "Spinach", "Garlic", "Basil", "Buffalo Mozzarella",
                "Sun-Dried Tomatoes", "Prosciutto"};
        return Arrays.stream(ingredients)
                .map(s -> Ingredient.builder().name(s).build())
                .collect(Collectors.toList());
    }
}