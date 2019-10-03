package com.gabrielsson.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CityService {

    public String newPizzaName() {
        List<String> cities = Arrays.asList("Brindisi",
                "Novara",
                "Arezzo",
                "Asti",
                "Ragusa",
                "Benevento",
                "Crotone",
                "Siena",
                "Olbia",
                "Vibo Valentia",
                "Padova",
                "Savona",
                "Caltanissetta",
                "Vicenza",
                "Gorizia",
                "Rieti",
                "Grosseto",
                "Bolzano",
                "Massa",
                "Sanluri",
                "Latina",
                "Vercelli");
        return cities.stream().skip((int) (cities.size() * Math.random())).findAny().get();
    }
}
