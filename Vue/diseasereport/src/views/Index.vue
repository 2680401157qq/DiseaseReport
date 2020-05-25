<template>
    <el-container style="height: 100%; border: 1px solid #eee">
<!--        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">-->
<!--            <el-menu router v-for="(item,index) in $router.options.routes[permission].children">-->
<!--                <el-menu-item v-if="item.children==null" :index="item.path"-->
<!--                @click="itemClick(item.name)">-->
<!--                    <template slot="title"><i class="el-icon-menu"></i>{{item.name}}</template>-->
<!--                </el-menu-item>-->
<!--                <el-submenu v-if="item.children!=null" :index="item.path">-->
<!--                    <template slot="title"><i class="el-icon-menu"></i>{{item.name}}</template>-->
<!--                    <el-menu-item v-for="(subItem,subIndex) in item.children" v-if="subItem.show" :index="subItem.path" -->
<!--                                  :class="$route.path==subItem.path?'is-active':''"-->
<!--                    @click="itemClick(subItem.name)">-->
<!--                        <template slot="title"><i class="el-icon-arrow-right"></i>{{subItem.name}}</template>-->
<!--                    </el-menu-item>-->
<!--                </el-submenu>-->
<!--            </el-menu>-->
<!--        </el-aside>-->
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu router v-for="(item) in $router.options.routes[0].children">
                <el-menu-item v-if="item.children==null&&item.isShow[permission]":index="item.path"
                              @click="itemClick(item.name)">
                    <template slot="title"><i class="el-icon-menu"></i>{{item.name}}</template>
                </el-menu-item>
                <el-submenu v-if="item.children!=null&&item.isShow[permission]" :index="item.path">
                    <template slot="title"><i class="el-icon-menu"></i>{{item.name}}</template>
                    <el-menu-item v-for="(subItem) in item.children" v-if="subItem.show" :index="subItem.path"
                                  :class="$route.path==subItem.path?'is-active':''"
                                  @click="itemClick(subItem.name)">
                        <template slot="title"><i class="el-icon-arrow-right"></i>{{subItem.name}}</template>
                    </el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-container>
            <el-header style="text-align: center; font-size: 20px">
                <span>{{title}}</span>
            </el-header>
            <el-main>
                <router-view>
                </router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        data() {
            return {
                title: "健康打卡",
                permission:2
            };
        },
        methods:{
            itemClick(itemName){
                this.title = itemName
            }
        }
    }
</script>

<style scoped>

</style>
