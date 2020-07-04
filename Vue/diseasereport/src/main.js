import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
<<<<<<< Updated upstream
import Common from "./components/Common";
=======

import myCharts from './chartjs/mychart.js'
Vue.use(myCharts)

>>>>>>> Stashed changes

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
