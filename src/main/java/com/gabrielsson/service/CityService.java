package com.gabrielsson.service;

import io.opentracing.Tracer;
import io.opentracing.contrib.spring.web.client.TracingRestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CityService {

    private final String cityEndpoint;
    private final Tracer tracer;


    public CityService(@Value("${pizza.name.endpoint}") String cityEndpoint, Tracer tracer) {
        this.cityEndpoint = cityEndpoint;
        this.tracer = tracer;
    }

    public String newPizzaName(String ingredients) {

        Map<String, String> params = new HashMap<>();
        params.put("ingredients", ingredients);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new TracingRestTemplateInterceptor(tracer)));

        String name = restTemplate.getForObject(cityEndpoint +"/name?ingredients={ingredients}",
                String.class, params);
        return name;
    }
}
