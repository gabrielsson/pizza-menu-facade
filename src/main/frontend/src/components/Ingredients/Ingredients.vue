<template src='./Ingredients.html'>
</template>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="./Ingredients.css">
</style>

<script>
import { ALL_INGREDIENTS_QUERY } from '../../constants/graphql.js';
import EventBus from '../../events/eventBus'

export default {

  name: 'Ingredients',
  data() {
    return {
       data: {
        ingredients: [],
        selectedList: []
       }
    }
  },
  methods: {
    selectedIngredient: function(ingredient) {
      if(this.data.selectedList.includes(ingredient)) {
        this.data.selectedList.splice(this.data.selectedList.indexOf(ingredient), 1)
       
      } else {
        this.data.selectedList.push(ingredient)
      }
      EventBus.$emit('generateMenu', this.data.selectedList)
    }
  },
  apollo: {
    ingredients: {
      query: ALL_INGREDIENTS_QUERY
    }
  }
};
</script>