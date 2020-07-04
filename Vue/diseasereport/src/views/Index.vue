<template>
    <el-container style="height: 100%; border: 1px solid #eee">
<<<<<<< Updated upstream
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu router>
                <el-submenu v-for="(item, index) in $router.options.routes[1].children" :index="index + ''" :key="index">
                    <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
                    <el-menu-item v-for="(subitem, subindex) in item.children" :index="subitem.path" :key="index + subindex"
                                  :class="$route.path === subitem.path? 'is-active' : ''">
                        {{subitem.name}}</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-container>
            <el-header style="text-align: center; font-size: 12px">
                <span>添加案例</span>
            </el-header>
            <el-main>
                <router-view></router-view>
=======
        <el-header height="60px" style="background-color: white; border-bottom: 1px solid #DCDFE6">
            <el-row type="flex" justify="row-bg">
                <el-col :span="8">
                    <el-image :src="require('../assets/logo.jpg')" class="el-header-image"/>
                </el-col>
                <el-col :span="4" :offset="3">
                    <el-image :src="require('../assets/title.jpg')" class="el-header-image"/>
                </el-col>
            </el-row>
        </el-header>
        <el-container>
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu router>
                    <el-menu-item v-for="(item, index) in $router.options.routes[1].children" :key="index"
                                  v-if="item.children==null&&item.isShow[permission]" :index="item.path"
                                  @click="itemClick(item.name)">
                        <template slot="title"><i :class="item.icon"></i>{{item.name}}</template>
                    </el-menu-item>
                    <el-submenu v-for="(item, index) in $router.options.routes[1].children" :key="index"
                                v-if="item.children!=null&&item.isShow[permission]" :index="item.path">
                        <template slot="title"><i :class="item.icon"></i>{{item.name}}</template>
                        <el-menu-item v-for="(subItem, subindex) in item.children" v-if="subItem.show" :index="subItem.path"
                                      :class="$route.path===subItem.path?'is-active':''" :key="index + subindex"
                                      @click="itemClick(subItem.name)">
                            <template slot="title"><i :class="subItem.icon"></i>{{subItem.name}}</template>
                        </el-menu-item>
                    </el-submenu>
                    <el-menu-item @click="logout">
                        <i class="el-icon-error"/>
                        <span style="color: red">退出</span>
                    </el-menu-item>
                </el-menu>
            </el-aside>
            <el-main style="width: 100%; height: 100%">
                <router-view/>
>>>>>>> Stashed changes
            </el-main>
        </el-container>
    </el-container>
</template>

<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>

<script>
    export default {
        data() {
            return {
<<<<<<< Updated upstream
=======
                title: "健康打卡",
                permission: Number(sessionStorage.getItem("permission"))
            };
        },
        methods: {
            itemClick(itemName) {
                this.title = itemName
            },
            logout() {
                this.$router.push('/login')
>>>>>>> Stashed changes
            }
        }
    };
</script>
<<<<<<< Updated upstream
=======

<style scoped>
    .el-header-image {
        width: 200px;
        height: 55px;
    }
</style>
>>>>>>> Stashed changes
