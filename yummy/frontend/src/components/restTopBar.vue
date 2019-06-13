<template>
  <el-menu class="menu" :default-active="activeIndex" background-color="#409EFF" text-color="#FFF" mode="horizontal" @select="handleSelect">
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
      <span class="top-bar-style" slot="title">你好，{{user}}</span>
      <el-menu-item class="sub-menu" index="4-1">登出</el-menu-item>
      <el-menu-item class="sub-menu" index="4-2">基本信息</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
    export default {
      name: "rest-top-bar",
      data() {
        return {
          activeIndex: "1",
          user: localStorage.rest_name
        }
      }

    }
</script>

<style scoped>
  .top-bar-style{
    font-size: 18px;
  }
  .menu{
    border: 1px solid #409EFF;
  }
  .sub-menu{
    font-size: 14px;
    width:200px;
  }
</style>
