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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-02T13:16:40.716Z")

@Controller
public class IngredientsApiController implements IngredientsApi {

    private static final Logger log = LoggerFactory.getLogger(IngredientsApiController.class);

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IngredientsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<List<Ingredient>> ingredientsGet() {
        String accept = request.getHeader("Accept");
        String[] ingredients = new String[]{"Kebab", "Mushrooms", "Pineapple", "Ham", "Mozzarella", "Basil"};
        return Optional.ofNullable(accept)
                .filter(a -> a.contains("application/json"))
                .map(a -> new ResponseEntity<List<Ingredient>>(allIngredients(ingredients), HttpStatus.OK))
                .orElse(new ResponseEntity<List<Ingredient>>(HttpStatus.BAD_REQUEST));
    }

    private List<Ingredient> allIngredients(String[] s) {
        return Arrays.stream(s)
                .map(ingredient -> new Ingredient().name(ingredient))
                .collect(Collectors.toList());
    }

}
