package com.gabrielsson.configuration;

import com.gabrielsson.api.IngredientsResolver;
import com.gabrielsson.model.Ingredient;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsService {

    private final MeterRegistry meterRegistry;
    public MetricsService(MeterRegistry meterRegistry, IngredientsResolver ingredientsResolver) {
        this.meterRegistry = meterRegistry;
        meterRegistry.gauge("pizza.menu.ingredients.available",
                ingredientsResolver,
                resolver -> (resolver
                        .ingredients()
                        .size()));
    }

    public void count(List<Ingredient> ingredients) {
        meterRegistry.counter("pizza.menu.pizza.counter").increment();
        ingredients.forEach(i -> meterRegistry
                .counter("pizza.menu.ingredient.counter",
                        Tags.of(Tag.of("ingredient", i.getName()))).increment()
        );
    }
}
