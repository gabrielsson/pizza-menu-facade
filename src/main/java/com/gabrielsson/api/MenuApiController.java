package com.gabrielsson.api;

import io.swagger.annotations.ApiParam;
import com.gabrielsson.model.Ingredient;
import com.gabrielsson.model.Pizza;
import com.gabrielsson.service.CityService;
import org.paukov.combinatorics3.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-02T13:16:40.716Z")

@Controller
public class MenuApiController implements MenuApi {

    private static final Logger log = LoggerFactory.getLogger(MenuApiController.class);
    private final CityService cityProvider;
    public MenuApiController(CityService cityProvider) {
        this.cityProvider = cityProvider;
    }

    public ResponseEntity<List<Pizza>> menuPost(@ApiParam(value = "", required = true) @Valid @RequestBody List<Ingredient> body) {

        Stream<List<Ingredient>> stream = Generator
                .subset(body)
                .simple()
                .stream();

        List<Pizza> collect = stream
                .map(list -> {

                    return new Pizza().ingredients(list).name(cityProvider.newPizzaName());
                }).collect(Collectors.toList());

        return new ResponseEntity<List<Pizza>>(collect, HttpStatus.OK);
    }
}
