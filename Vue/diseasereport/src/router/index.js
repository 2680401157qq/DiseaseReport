import Vue from 'vue'
import VueRouter from 'vue-router'
import UserManager from "../views/UserManager";
import Index from "../views/Index"
import DiseaseCaseTable from "../views/DiseaseCaseTable";
import DiseaseCaseAdd from "../views/DiseaseCaseAdd";

Vue.use(VueRouter)

  const routes = [
    {
      path: "/",
      name: "普通用户",
      component: Index,
      redirect: "/doctor/diseasecase/table",
      children: [
        {
          path: "/diseasecase",
          name: "案例管理",
          component: {render: (c) => c("router-view")},
          children: [
            {
              path: "/diseasecase/table",
              name: "案例列表",
              component: DiseaseCaseTable
            }
          ]
        }
      ]
    },
    {
      path: "/doctor",
      name: "医生用户",
      component: Index,
      children: [
        {
          path: "/diseasecase",
          name: "案例管理",
          component: {render: (c) => c("router-view")},
          children: [
            {
              path: "/doctor/diseasecase/table",
              name: "案例列表",
              component: DiseaseCaseTable
            },
            {
              path: "/doctor/diseacase/add",
              name: "添加案例",
              component: DiseaseCaseAdd
            }
          ]
        }
      ]
    },
    {
      path: "/admin",
      name: "管理员用户",
      component: Index,
      children: [
        {
          path: "/diseasecase",
          name: "案例管理",
          component: {render: (c) => c("router-view")},
          children: [
            {
              path: "/admin/diseasecase/table",
              name: "案例列表",
              component: DiseaseCaseTable
            },
            {
              path: "/admin/diseacase/add",
              name: "添加案例",
              component: DiseaseCaseAdd
            }
          ]
        }
      ]
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
