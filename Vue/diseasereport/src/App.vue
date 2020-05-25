<template>
<!--  <div id="app">-->
<!--    <el-container style="height: 100%; border: 1px solid #eee">-->
<!--      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">-->
<!--        <el-menu :default-active="'1'">-->
<!--          -->
<!--          <el-menu-item index="1">-->
<!--            <template slot="title"><i class="el-icon-s-custom"></i>用户名</template>-->
<!--          </el-menu-item>-->
<!--          -->
<!--          <el-menu-item index="2">-->
<!--            <template slot="title"><i class="el-icon-s-home"></i>健康打卡</template>-->
<!--          </el-menu-item>-->
<!--          -->
<!--          <el-menu-item index="3">-->
<!--            <template slot="title"><i class="el-icon-menu"></i>案例查看</template>-->
<!--          </el-menu-item>-->
<!--          -->
<!--          <el-menu-item index="4">-->
<!--            <template slot="title"><i class="el-icon-menu"></i>案例录入</template>-->
<!--          </el-menu-item>-->
<!--          -->
<!--          <el-submenu index="5">-->
<!--            <template slot="title"><i class="el-icon-menu"></i>人员管理</template>-->
<!--            <el-menu-item index="4-1">-->
<!--              <template slot="title"><i class="el-icon-s-custom"></i>医生管理</template>-->
<!--            </el-menu-item>-->
<!--            <el-menu-item index="4-2">-->
<!--              <template slot="title"><i class="el-icon-s-custom"></i>用户管理</template>-->
<!--            </el-menu-item>-->
<!--          </el-submenu>-->
<!--          -->
<!--          <el-menu-item index="6">-->
<!--            <template slot="title"><i class="el-icon-menu"></i>统计分析</template>-->
<!--          </el-menu-item>-->
<!--        </el-menu>-->
<!--      </el-aside>-->

<!--      <el-container>-->
<!--        <el-header style="text-align: center; font-size: 20px">-->
<!--          <span>人员管理</span>-->
<!--        </el-header>-->
<!--        <el-main>-->
<!--          <router-view>-->
<!--          </router-view>-->
<!--        </el-main>-->
<!--      </el-container>-->
<!--    </el-container>-->
<!--  </div>-->
  <router-view></router-view>
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
  html,body,#app,.el-container{
    padding: 0px;
    margin: 0px;
    height: 100%;
  }
</style>

<script>
  export default {
  }; 
</script>
