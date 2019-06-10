<template>
  <div>
    <!--TODO 登录后切换top bar-->
    <visitorTopBar></visitorTopBar>
    <div class="main-body">
      <div>
        <div style="width: 100%; display: flex;">
          <div style="width: 350px; background: #409EFF; color: white; font-size: 20px;
      text-align: center; margin-right: 10px; padding: 10px" @click="changeShowPcdChoice">
            <span>当前位置：{{pcd}}</span>
            <img src="../assets/down.svg" style="width: 30px; height: 30px; float: right; margin-right: 10px"/>
          </div>
          <input style="width: 300px; font-size: 20px;" placeholder="  您的详细地址" v-model="detail_address"/>
          <el-input
            style="margin-left: 45%;width: 200px"
            placeholder="请输入您想查找的餐厅"
            prefix-icon="el-icon-search"
            v-model="search">
          </el-input>
        </div>
        <div v-if="showPcdChoice" style="min-height: 100px;margin:5px auto;font-size: 20px; position: absolute;z-index:9999">
          <addressChoice @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
        </div>
      </div>
      <!--分类&具体餐厅-->
      <div style="width: 100%; margin-top: 50px">
        <el-card style="width: 100%;">
          <div style="display: flex">
            <div style="margin-right: 50px;margin-top: 5px; font-size: 20px">选择您喜欢的分类：</div>
            <el-checkbox-group v-model="checkList">
              <el-checkbox-button v-for="item in type" :label="item" :key="item">{{item}}</el-checkbox-button>
            </el-checkbox-group>
          </div>
          <!--具体餐厅-->
          <div style="margin-top: 50px;">
            <div style="display: inline-block;" v-for="info in infos" :key="info.key">
              <restaurantCard :info="info"></restaurantCard>
            </div>
          </div>
        </el-card>
      </div>

      <img v-if="btnFlag" style="width:50px; height: 50px; position: fixed;z-index:9999;
      right: 50px; bottom: 50px;border:1px solid #409EFF; border-radius: 50%" src="../assets/up.svg" @click="backTop">
    </div>
  </div>

</template>

<script>
  import addressChoice from '../components/addressChoice'
  import visitorTopBar from '../components/visitorTopBar'
  import restaurantCard from '../components/restaurantCard'
    export default {
        name: "nearbyRestaurant",
        components: {visitorTopBar, addressChoice,restaurantCard},
        data(){
          return{
            address:"",
            search: "",
            btnFlag: false,
            scrollTop: 0,
            showPcdChoice: false,
            pcd: "选择您所在的位置",
            detail_address: "",
            type:['甜品饮品','快餐便当','小吃夜宵','特色菜系',"欧美西餐","日韩美食","异域美味"],
            checkList: [],
            infos:[{name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5", url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 1},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5" , url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 2},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5",  url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 3},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5", url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 4},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5" , url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 5},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5",  url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 6},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5" , url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 7},
              {name:"mock餐厅", rate:3.7, time:"40分钟", price: "￥5",  url:"../assets/logo.png",person: 10, type: "甜品饮品", rid: 8},]
          }
        },
        mounted(){
            this.pcd = this.$route.params.pcd;
            this.detail_address = this.$route.params.detail_address
            window.addEventListener('scroll', this.scrollToTop)
        },
        destroyed () {
          window.removeEventListener('scroll', this.scrollToTop)
        },
        methods:{
          changeShowPcdChoice () {
            this.showPcdChoice = !this.showPcdChoice;
          },
          setPcd(pcdChoice){
            console.log("pcd: "+pcdChoice);
            this.pcd = pcdChoice;
          },
          // 点击图片回到顶部方法，加计时器是为了过渡顺滑
          backTop () {
            let that = this
            let timer = setInterval(() => {
              let ispeed = Math.floor(-that.scrollTop / 5)
              document.documentElement.scrollTop = document.body.scrollTop = that.scrollTop + ispeed
              if (that.scrollTop === 0) {
                clearInterval(timer)
              }
            }, 16)
          },

          // 为了计算距离顶部的高度，当高度大于60显示回顶部图标，小于60则隐藏
          scrollToTop () {
            let that = this
            let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
            that.scrollTop = scrollTop
            if (that.scrollTop > 60) {
              that.btnFlag = true
            } else {
              that.btnFlag = false
            }
          }
        }
    }
</script>

<style scoped>
  .main-body{
    padding-top: 40px;
    padding-left: 50px;
    padding-right: 50px;
    /*border: 1px solid red*/;
  }
  .category{
    width: 100px;
    height: 30px;
    border: 1px solid gainsboro;
  }
</style>
