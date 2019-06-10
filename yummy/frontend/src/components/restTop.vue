<template>
  <el-row>
    <el-col :span="6" class="c">
      <div class="logo">
        <div class="title"><i>Yummy餐厅版</i></div>
      </div>
    </el-col>

    <el-col :span="18">
      <div>
        <el-menu :default-active="activeIndex"
                 class="el-menu-demo"
                 mode="horizontal"
                 @select="handleSelect"
                 background-color="#409EFF"
                 text-color="#fff"
                 active-text-color="#000000"
                 :router="routerBool"

        >
          <el-menu-item index="/restLogin">登出</el-menu-item>

          <el-submenu index="1" class="bar-main">
            <template slot="title">
              <i class="el-icon-location-outline bar-icon"></i>
              <span>我的餐厅</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/restPage">基本信息</el-menu-item>
              <!-- <el-menu-item index="/UserSpace/SchoolPerformance">餐厅菜单</el-menu-item> -->
              <!--<el-menu-item index="/UserSpace/FinancialStanding">财务状况</el-menu-item>
              <el-menu-item index="/UserSpace/BasicInformation">基本信息</el-menu-item>-->
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2" class="bar-main">
            <template slot="title">
              <i class="el-icon-menu bar-icon"></i>
              <span>发布信息</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/launchNewFood">发布新品</el-menu-item>
              <el-menu-item index="/launchSetMeal">发布套餐</el-menu-item>
              <el-menu-item index="/launchDiscount">发布优惠</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="/expressRecord" class="bar-main">
            <i class="el-icon-menu bar-icon"></i>
            <span slot="title">送餐记录</span>
          </el-menu-item>
          <el-menu-item index="/restStatistics" class="bar-main">
            <i class="el-icon-location bar-icon"></i>
            <span slot="title">统计信息</span>
          </el-menu-item>

        </el-menu>
      </div>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "rest-top",
    data() {
      return {
        activeIndex: '',
        routerBool:true
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key,keyPath);
        if(key === "/restLogin") {
          this.logout();
        }
      },

      logout() {
        localStorage.rest_id = "";
      }
    }
  }
</script>

<style scoped>

  .logo{
    color: white;
    background-color: #409EFF;
    text-align: center;
    /*font-size: 18px;*/
    height: 60px;
    line-height: 60px;
    margin: auto;
  }

  .title{
    font-size: 30px;
    color: white;
  }

</style>
