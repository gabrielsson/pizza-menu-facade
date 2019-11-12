package com.gabrielsson.configuration;

import com.gabrielsson.api.IngredientsProvider;
import com.gabrielsson.api.MenuProvider;
import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class GraphQLDataFetchers {

    private final IngredientsProvider ingredientsProvider;
    private final MenuProvider menuProvider;

    public DataFetcher getIngredientsFetcher() {
        return dataFetchingEnvironment -> ingredientsProvider.provide();
    }

    public DataFetcher getPizzaFetcher() {
        return dataFetchingEnvironment -> {
            List<Map<String, Object>> ingredients = dataFetchingEnvironment.getArgument("ingredients");
            return menuProvider
                    .provide(ingredients);
        };
    }
}