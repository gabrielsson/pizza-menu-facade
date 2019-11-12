<template src='./Menu.html'>
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="./Menu.css">
</style>

<script>
import EventBus from '../../events/eventBus'
import gql from 'graphql-tag'

export default {
  name: 'Menu',
  data() {
    return {
      data: {
        menu: [],
        ingredients: []
      }
    }
  },
  methods: {
    updateMenu (payload) {
      this.data.ingredients = []
      payload.forEach(element => {
        this.data.ingredients.push({"name":element})
      });
    }
  },
  mounted () {
    EventBus.$on('generateMenu', (payload) => {
               
        this.updateMenu(payload)
        
      }
    )
  },
  apollo: {
    menu: {
      query: gql`
        query GetAllPizzas($ingredients: [IngredientInput]) {
            pizzas(ingredients: $ingredients) {
              name
              ingredients {
                name
              }
            }
          }  
        `,
    
        variables () {
          return {"ingredients": this.data.ingredients}
            
            
        },
        update(data) {
          return data.pizzas;
        }
    }
  }
};
</script> 
