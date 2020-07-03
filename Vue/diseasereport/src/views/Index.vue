<template>
    <el-container style="height: 100%; border: 1px solid #eee">
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
            }
        }
    };
</script>
