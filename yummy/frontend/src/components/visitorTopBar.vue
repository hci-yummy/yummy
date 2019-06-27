<template>
  <el-menu class="menu" :default-active="activeIndex" background-color="#409EFF" text-color="#FFF" mode="horizontal" @select="handleSelect">
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
          handleSelect(key, keyPath) {
            this.activeIndex = key;
            console.log(this.activeIndex)
            if(this.activeIndex === '4'){
              this.$router.push({name: "login"})
            }else if(this.activeIndex === '1'){
              this.$router.push({name: "welcome"})
            }else if(this.activeIndex === '3'){
              this.$router.push({name:'memberRegister'})
            }else if(this.activeIndex === '2'){
              this.$router.push({name: "restLogin"})
            }
          },
        }
    }
</script>

<style scoped>
  .top-bar-style{
    float: right;
  }
  .menu{
    border: 1px solid #409EFF;
  }
</style>
