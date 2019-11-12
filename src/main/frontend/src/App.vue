<template>
  <div id="app" >


    <Ingredients :msg="info"></Ingredients>
    <Menu :menu="menu"></Menu>
  </div>
</template>

<script>
import Ingredients from "./components/Ingredients";
import Menu from "./components/Menu";

export default {
  name: "app",
  components: {
    Ingredients,
    Menu
  },
  data() {
    return {
      info: [],
      menu: []
    };
  },
  mounted() {
    
  },
  methods: {
   
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: wheat;
  margin-top: 60px;
  background-color: black;
  opacity: 0.7;  
  

}

html {
  background-size: cover;
}
</style>
 