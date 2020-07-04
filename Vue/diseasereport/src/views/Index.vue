<template>
    <el-container style="height: 100%; width: 100%">
        <el-header height="60px" style="border-bottom: 1px solid #DCDFE6">
            <el-row>
                <el-col :span="8">
                    <el-image :src="require('../assets/logo.jpg')" class="el-header-image"></el-image>
                </el-col>
                <el-col :span="4" :offset="4">
                    <el-image :src="require('../assets/title.jpg')" class="el-header-image"></el-image>
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
                        <span style="color: red">退出系统</span>
                    </el-menu-item>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
    export default {
        data() {
            return {
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
            }
        }
    }
</script>

<style scoped>
    .el-header-image {
        height: 55px;
        width: 200px;
    }
</style>
