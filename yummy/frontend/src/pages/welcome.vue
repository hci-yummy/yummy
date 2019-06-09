<template>
  <div>
    <el-menu :default-active="activeIndex" background-color="#409EFF" text-color="#FFF" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1"><img src="../assets/logo.png" style="width: auto;height: auto;max-width: 150px;"></el-menu-item>
      <el-menu-item class="top-bar-style" index="2">|  商家</el-menu-item>
      <el-menu-item class="top-bar-style" index="3">注册</el-menu-item>
      <el-menu-item class="top-bar-style" index="4">登录</el-menu-item>
    </el-menu>

    <div style="width: 700px; margin:100px auto 20px auto;">
      <img src="../assets/logo.png" style="width: auto;height: auto;max-width: 100%;">
    </div>
    <div style="width: 900px; margin:0 auto;display: flex; font-size: 20px;">
      <div style="width: 250px; background: #409EFF; color: white; font-size: 20px;
      text-align: center; margin-right: 10px; padding: 10px;">
        <span>选择您所在的城市</span>
        <img src="../assets/down.svg" style="width: 30px; height: 30px; float: right; margin-right: 10px"/>
      </div>
      <input style="width: 550px; font-size: 20px;" placeholder="您的详细地址"/>
      <div style="width: 10px"></div>
      <el-button type="primary" style="font-size: 20px;">搜索</el-button>
    </div>
    <div style="width: 900px; margin:0 auto;font-size: 20px;">
      chengshi
    </div>
  </div>
</template>

<script>
    import province from '../components/addressUtil'
    export default {
        name: "welcome",
        data () {
          return {
            activeIndex: 1,
            address: province,
            province: "",
            city: "",
            district: "",
            detail_address: "",
          }
        }
    }
</script>

<style scoped>
  .top-bar-style{
    font-size: 22px;
    float: right;
  }

</style>
