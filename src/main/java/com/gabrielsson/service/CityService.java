package com.gabrielsson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CityService {

    private final String cityEndpoint;

    public CityService(@Value("${pizza.name.endpoint}")String cityEndpoint) {
        this.cityEndpoint = cityEndpoint;
    }

    public String newPizzaName(List<String> ingredients) {

        Map<String, String> params = new HashMap<>();
        params.put("ingredients", ingredients.stream().collect(Collectors.joining(",")));

        RestTemplate restTemplate = new RestTemplate();
        String name = restTemplate.getForObject(cityEndpoint +"/name?ingredients={ingredients}",
                String.class, params);
        return name;
    }
}
