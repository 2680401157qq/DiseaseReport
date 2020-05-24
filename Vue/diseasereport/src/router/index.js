import Vue from 'vue'
import VueRouter from 'vue-router'
import UserManager from "../views/UserManager";

Vue.use(VueRouter)

  const routes = [
    {
      path:"/UserManager",
      name:"人员管理",
      component:UserManager
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
