<template>
  <el-menu :default-active="activeIndex" background-color="#409EFF" text-color="#FFF" mode="horizontal" @select="handleSelect">
    <el-menu-item index="1"><img src="../assets/logo.png" style="width: auto;height: auto;max-width: 150px;"></el-menu-item>
    <el-menu-item class="top-bar-style" index="2">|  商家</el-menu-item>
    <el-menu-item class="top-bar-style" index="3">注册</el-menu-item>
    <el-menu-item class="top-bar-style" index="4">登录</el-menu-item>
  </el-menu>
</template>

<script>
    export default {
        name: "visitorTopBar",
        data(){
            return{
              activeIndex: "1",
            }
        },
        methods: {
          handleSelect() {

          },
        }
    }
</script>

<style scoped>
  .top-bar-style{
    font-size: 22px;
    float: right;
  }
</style>
