import { ApolloClient } from 'apollo-client'
import { HttpLink } from 'apollo-link-http'
import { InMemoryCache } from 'apollo-cache-inmemory'
import VueApollo from 'vue-apollo'

import Vue from 'vue'
import App from './App.vue'
import 'tachyons'

Vue.config.productionTip = false
const httpLink = new HttpLink({
  // You should use an absolute URL here
  uri: '/graphql'
})

// 4
const apolloClient = new ApolloClient({
  link: httpLink,
  cache: new InMemoryCache(),
  connectToDevTools: true
})

Vue.use(VueApollo)

const apolloProvider = new VueApollo({
  defaultClient: apolloClient,
  defaultOptions: {
    $loadingKey: 'loading'
  }
})


new Vue({
  render: h => h(App),
  provide: apolloProvider.provide(),
  data () {
    return {
      info: "Max"
    }
  },
}).$mount('#app')
