package com.gabrielsson.api;

import com.gabrielsson.model.Ingredient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class IngredientsApiController implements IngredientsApi {

    private static final Logger log = LoggerFactory.getLogger(IngredientsApiController.class);

    public ResponseEntity<List<Ingredient>> ingredientsGet() {
        String[] ingredients = new String[]{"Kebab", "Mushrooms", "Pineapple", "Ham", "Mozzarella", "Basil"};
        return new ResponseEntity<>(allIngredients(ingredients), HttpStatus.OK);
    }

    private List<Ingredient> allIngredients(String[] s) {
        return Arrays.stream(s)
                .map(ingredient -> new Ingredient().name(ingredient))
                .collect(Collectors.toList());
    }
}
