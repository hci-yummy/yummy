<template>
  <el-menu class="menu" :default-active="activeIndex" background-color="#409EFF" text-color="#FFF" mode="horizontal" @select="handleSelect" :router="routerBool">
    <el-menu-item class="top-bar-style" index="1"><img src="../assets/logo.png" style="width: auto;height: auto;max-width: 150px;"></el-menu-item>

    <el-menu-item class="top-bar-style" index="/expressRecord"><span slot="title">订单记录</span></el-menu-item>
    <el-submenu index="2">
      <template slot="title">
        <span class="top-bar-style">发布信息</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/launchNewFood">发布新品</el-menu-item>
        <el-menu-item index="/launchSetMeal">发布套餐</el-menu-item>
        <el-menu-item index="/launchDiscount">发布优惠</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-menu-item class="top-bar-style" index="/restStatistics">统计信息</el-menu-item>
    <!--<el-menu-item class="top-bar-style" style="float: right;" index="4">你好，{{user}}</el-menu-item>-->
    <el-submenu style="width:150px; float: right;" index="4">
      <span class="top-bar-style" slot="title">&nbsp;&nbsp;{{user}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <el-menu-item class="sub-menu" index="/restLogin">登出</el-menu-item>
      <el-menu-item class="sub-menu" index="/restPage">基本信息</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
    export default {
      name: "rest-top-bar",
      data() {
        return {
          activeIndex: "1",
          user: localStorage.rest_name,
          routerBool:true
        }
      },

      methods: {
        logout() {
          localStorage.rest_id = "";
          localStorage.rest_name = "";
        },

        handleSelect(key, keyPath) {
          console.log(key,keyPath);
          if(key === "/restLogin") {
            this.logout();
          }
        }
      }

    }
</script>

<style scoped>
  .top-bar-style{
    font-size: 14px;
  }
  .menu{
    border: 1px solid #409EFF;
  }
  .sub-menu{
    font-size: 12px;
    width:200px;
  }
</style>
