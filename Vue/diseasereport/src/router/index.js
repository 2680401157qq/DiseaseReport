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
<<<<<<< Updated upstream
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
=======
                path: "/userinfo",
                name: "用户信息",
                isShow: [true, false, false],
                component: UserInfoForm,
                icon: 'el-icon-user-solid'
            },
            {
                path: "/health",
                name: "健康打卡",
                isShow: [true, true, true],
                icon: 'el-icon-s-promotion'
            },
            {
                path: "/disease",
                name: "案例管理",
                isShow: [false, true, true],
                component: DiseaseContainer,
                icon: 'el-icon-notebook-2',
                children: [
                    {
                        path: "/diseasetable",
                        name: "案例查看",
                        component: DiseaseCaseTable,
                        icon: 'el-icon-s-order',
                        show: true,
                    },
                    {
                        path: "/diseaseadd",
                        name: "案例录入",
                        component: DiseaseCaseAdd,
                        icon: 'el-icon-s-claim',
                        show: true,
                    }
                ]
            },
            {
                path: "/user",
                name: "人员管理",
                component: UserContainer,
                isShow: [false, false, true],
                icon: 'el-icon-user',
                children: [
                    {
                        path: "/doctortable",
                        name: "医生管理",
                        show: true,
                        component: DoctorTable,
                        icon: 'el-icon-s-custom'
                    },
                    {
                        path: "/usertable",
                        name: "用户管理",
                        show: true,
                        component: UserTable,
                        icon: 'el-icon-s-custom',
                    },
                    {
                        path: "/useradd",
                        name: "添加用户",
                        show: false,
                        component: UserAdd,
                        icon: 'el-icon-zoom-in'
                    },
                    {
                        path: "/doctoradd",
                        name: "添加医生",
                        show: false,
                        component: DoctorAdd,
                        icon: 'el-icon-zoom-in'
                    },
                    {
                        path: "/useredit",
                        name: "修改用户",
                        show: false,
                        component: UserEdit,
                        icon: 'el-icon-s-check'
                    }
                ]
            },
            {
                path: "/data",
                name: "统计分析",
                //加一个xxContainer
                component: DataContainer,
                isShow: [false, true, true],
                icon: 'el-icon-data-line',
                children: [
                    {
                        path: '/getbyday',
                        name: "日期查询",
                        show: true,
                        component: () => import('../views/Getbyday.vue'),
                        icon: 'el-icon-date'
                    },
                    {
                        path: '/getbyinstitute',
                        name: '学院展示',
                        show: true,
                        component: () => import('../views/Getbyinstitute.vue'),
                        icon: 'el-icon-s-data'
                    },
                ]
>>>>>>> Stashed changes
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
