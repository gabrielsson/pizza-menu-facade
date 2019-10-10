package com.gabrielsson.configuration;

import com.gabrielsson.api.IngredientsProvider;
import com.gabrielsson.api.MenuProvider;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private final IngredientsProvider ingredientsProvider;
    private final MenuProvider menuProvider;

    public GraphQLDataFetchers(IngredientsProvider ingredientsProvider, MenuProvider menuProvider) {
        this.ingredientsProvider = ingredientsProvider;
        this.menuProvider = menuProvider;
    }

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