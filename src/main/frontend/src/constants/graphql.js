import gql from 'graphql-tag'

// 2
export const ALL_INGREDIENTS_QUERY = gql`
  query AllIngredientsQuery {
    ingredients {
      name
    }
  }
`

export const PIZZA_MENU_QUERY = gql`
query GetAllPizzas($selectedIngredients: [IngredientInput]) {
    pizzas(ingredients: $selectedIngredients) {
      name
      ingredients {
        name
      }
    }
  }  
`
