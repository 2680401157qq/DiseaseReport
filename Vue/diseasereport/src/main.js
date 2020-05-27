import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import FilterForm from "./components/FilterForm";
import UserInfoForm from "./components/UserInfoForm";
import Common from "./components/Common";
import CaseInfoForm from "./components/CaseInfoForm";

import myCharts from './chartjs/mychart.js'
Vue.use(myCharts)


Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

Vue.prototype.Common = Common

Vue.component("filter-form", FilterForm)
Vue.component("userinfo-form", UserInfoForm)
Vue.component("caseinfo-form", CaseInfoForm)
