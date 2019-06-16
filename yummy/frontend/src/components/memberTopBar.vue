<template>
  <el-menu class="menu" :default-active="activeIndex" background-color="#409EFF" text-color="#FFF" mode="horizontal" @select="handleSelect">
    <el-menu-item class="top-bar-style" index="1"><img src="../assets/logo.png" style="width: auto;height: auto;max-width: 150px;"></el-menu-item>
    <el-menu-item class="top-bar-style" index="2">附近的餐厅</el-menu-item>
    <el-menu-item class="top-bar-style" index="3">我的订单</el-menu-item>
    <!--<el-menu-item class="top-bar-style" style="float: right;" index="4">你好，{{user}}</el-menu-item>-->
    <el-submenu style="width:150px; float: right;" index="4">
      <span class="top-bar-style" slot="title">你好，{{user}}</span>
      <el-menu-item class="sub-menu" index="4-1">登出</el-menu-item>
      <el-menu-item class="sub-menu" index="4-2">基本信息</el-menu-item>
      <el-menu-item class="sub-menu" index="4-3">地址修改</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
    export default {
        name: "memberTopBar",
      data(){
        return{
          activeIndex: "1",
          user: localStorage.username
        }
      },
      methods: {
        handleSelect(key, keyPath) {
          this.activeIndex = key;
          console.log(this.activeIndex)
          if(this.activeIndex === '4-1'){
            //TODO 个人中心
            this.logout();
            this.$router.push({name: "login"})
          }else if(this.activeIndex === '1'){
            this.$router.push({name: "welcome"})
          }else if(this.activeIndex === '3'){
            this.$router.push({name: "order"})
          }else if(this.activeIndex === '2'){
            this.$router.push({name: "nearbyRestaurant"})
          }else if(this.activeIndex === '4-2'){
            this.$router.push({name: "memberInfo"})
          }
        },
        logout() {
          localStorage.user_email = "";
          localStorage.address = "";
          localStorage.district = "";
          localStorage.username = "";
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
