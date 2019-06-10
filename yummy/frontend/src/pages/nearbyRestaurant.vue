<template>
  <div>
    <!--TODO 登录后切换top bar-->
    <visitorTopBar></visitorTopBar>
    <div class="main-body">
      <div>
        <div style="width: 900px; float: left; display: flex">
          <div style="width: 400px; background: #409EFF; color: white; font-size: 20px;
      text-align: center; margin-right: 10px; padding: 10px" @click="changeShowPcdChoice">
            <span>当前位置：{{pcd}}</span>
            <img src="../assets/down.svg" style="width: 30px; height: 30px; float: right; margin-right: 10px"/>
          </div>
          <input style="width: 300px; font-size: 20px;" placeholder="  您的详细地址" v-model="detail_address"/>
        </div>
        <!--TODO-->
        <!--<div v-if="showPcdChoice" style="width: 900px; min-height: 100px;margin:5px auto;font-size: 20px;">
          <addressChoice @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
        </div>-->
        <el-input
          style="float: right; width: 200px"
          placeholder="请输入您想查找的餐厅"
          prefix-icon="el-icon-search"
          v-model="search">
        </el-input>
      </div>

    </div>
  </div>

</template>

<script>
  import addressChoice from '../components/addressChoice'
  import visitorTopBar from '../components/visitorTopBar'
    export default {
        name: "nearbyRestaurant",
        components: {visitorTopBar, addressChoice},
        data(){
          return{
            address:"",
            search: "",
            showPcdChoice: false,
            pcd: "选择您所在的位置",
            detail_address: "",
          }
        },
        mounted(){
            this.pcd = this.$route.params.pcd;
            this.detail_address = this.$route.params.detail_address
        },
        methods:{
          changeShowPcdChoice () {
            this.showPcdChoice = !this.showPcdChoice;
          },
          setPcd(pcdChoice){
            console.log("pcd: "+pcdChoice);
            this.pcd = pcdChoice;
          },
        }
    }
</script>

<style scoped>
  .main-body{
    padding-top: 20px;
    padding-left: 50px;
    padding-right: 50px;
    /*border: 1px solid red*/;
  }
</style>
