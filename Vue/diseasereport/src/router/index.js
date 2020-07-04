import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from "../views/Index";
import UserContainer from "../components/UserContainer";
import UserTable from "../components/UserTable";
import DoctorTable from "../components/DoctorTable";
import UserAdd from "../components/UserAdd";
import UserEdit from "../components/UserEdit";
import DiseaseContainer from "../components/DiseaseContainer";
import DiseaseCaseTable from "../views/DiseaseCaseTable";
import DiseaseCaseAdd from "../views/DiseaseCaseAdd";
import DoctorAdd from "../components/DoctorAdd";
import DataContainer from "../components/DataCotainer";
import Login from "../components/Login";
import UserInfoForm from "../components/UserInfoForm";
import PunchContainer from "../components/PunchContainer";
import PunchHistory from "../components/PunchHisoryTable";
import PublishPunch from "../components/PublishPunch";

Vue.use(VueRouter);

const routes = [
    {
        path: "/login",
        name: "登陆",
        component: Login
    },
    {
        path: "/",
        name: "/",
        component: Index,
        children: [
            {
                path: "/userinfo",
                name: "用户信息",
                isShow: [true, false, false],
                component: UserInfoForm
            },
            {
                path: "/health",
                name: "健康打卡",
                isShow: [true, true, false],
            },
            {
                path: "/punch",
                name: "打卡管理",
                isShow: [false, false, true],
                component: PunchContainer,
                children: [
                    {
                        path: "/publish",
                        name: "发布任务",
                        component: PublishPunch,
                        show: true,
                    },
                    {
                        path: "/history",
                        name: "任务历史",
                        component: PunchHistory,
                        show: true,
                    }
                ]
            },
            {
                path: "/disease",
                name: "案例管理",
                isShow: [false, true, true],
                component: DiseaseContainer,
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
                component: UserContainer,
                isShow: [false, false, true],
                children: [
                    {
                        path: "/doctortable",
                        name: "医生管理",
                        show: true,
                        component: DoctorTable
                    },
                    {
                        path: "/usertable",
                        name: "用户管理",
                        show: true,
                        component: UserTable
                    },
                    {
                        path: "/useradd",
                        name: "添加用户",
                        show: false,
                        component: UserAdd
                    },
                    {
                        path: "/doctoradd",
                        name: "添加医生",
                        show: false,
                        component: DoctorAdd
                    },
                    {
                        path: "/useredit",
                        name: "修改用户",
                        show: false,
                        component: UserEdit
                    }
                ]
            },
            {
                path: "/data",
                name: "统计分析",
                component: DataContainer,
                isShow: [false, true, true],
                children: [
                    {
                        path: '/getbyday',
                        name: '日期',
                        component: () => import('../views/Getbyday.vue'),
                        show: true
                    },
                    {
                        path: '/getbyinstitute',
                        name: '学院',
                        component: () => import('../views/Getbyinstitute.vue'),
                        show: true
                    },
                ]
            }
        ]
    }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

router.beforeEach((to, from, next) => {
    let token = sessionStorage.getItem('token');
    if (to.path === '/login') {
        next();
    } else {
        if (token === '' || token == null) {
            next('/login');
        } else {
            next();
        }
    }
})

export default router
