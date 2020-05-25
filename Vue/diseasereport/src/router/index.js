import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index";
import UserContainer from "../components/UserContainer";
import UserTable from "../components/UserTable";
import DoctorTable from "../components/DoctorTable";
import UserAdd from "../components/UserAdd";
import UserEdit from "../components/UserEdit";
import DiseaseCaseTable from "../views/DiseaseCaseTable";
import DiseaseCaseAdd from "../views/DiseaseCaseAdd";
Vue.use(VueRouter)

  const routes = [
    {
      path:"/",
      name:"/",
      component:Index,
      children:[
        {
          path: "/userinfo",
          name: "用户信息",
          isShow:[true,true,true]
        },
        {
          path: "/health",
          name: "健康打卡",
          isShow:[true,true,true],
        },
        {
          path: "/disease",
          name: "案例管理",
          isShow:[false,true,true],
          children: [
            {
              path: "/diseasetable",
              name: "案例查看",
              component: DiseaseCaseTable,
              show: true,
            },
            {
              path: "/diseaseadd",
              name: "案例录入",
              component: DiseaseCaseAdd,
              show: true,
            }
          ]
        },
        {
          path: "/user",
          name: "人员管理",
          component:UserContainer,
          isShow:[false,false,true],
          children:[
            {
              path: "/doctortable",
              name: "医生管理",
              show:true,
              component:DoctorTable
            },
            {
              path: "/usertable",
              name: "用户管理",
              show:true,
              component:UserTable
            },
            {
              path:"/useradd",
              name:"添加用户",
              show:true,
              component:UserAdd
            },
            {
              path:"/useredit",
              name:"修改用户",
              show:false,
              component:UserEdit
            }
          ]
        },
        {
          path: "/data",
          name:"统计分析",
          isShow:[false,true,true]
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
