<template>
  <div style=" min-height: 900px;">
    <div v-if="visitorMode">
      <visitorTopBar></visitorTopBar>
    </div>
    <div v-else>
      <memberTopBar></memberTopBar>
    </div>
    <div class="main-body">
      <div>
        <div style="width: 100%; display: flex;">
          <div style="width: 280px; background: #409EFF; color: white; font-size: 16px; border-radius: 2%;
      text-align: center; margin-right: 10px; height: 40px; line-height: 40px;" @click="changeShowPcdChoice">
            <div style="display: inline-block;">当前位置：{{pcd}}</div>
            <i class = "el-icon-arrow-down" style="width: 30px; height: 30px;"></i>
          </div>
          <el-input style="width: 300px; font-size: 16px;" placeholder="  您的详细地址" v-model="detail_address"></el-input>
          <div style="width: 10px"></div>
          <el-button size="mini" type="primary" style="font-size: 16px;" @click="searchNearby">搜索</el-button>
          <el-input
            size="medium"
            style="margin-left: 350px;width: 200px; font-size: 16px"
            placeholder="输入餐厅名称"
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
        <div style="width: 100%;">
          <div style="display: flex; border: 1px dashed lightgrey; height: 60px; border-radius: 1%; line-height: 60px; background: white">
            <div style="margin-right: 20px; font-size: 16px; margin-left: 10px; color: grey">选择您喜欢的分类：</div>
            <el-checkbox-group v-model="checkList">
              <el-checkbox-button v-for="item in type" :label="item" :key="item">{{item}}</el-checkbox-button>
            </el-checkbox-group>
          </div>
          <!--具体餐厅-->
          <div style="margin-top: 20px;margin-left: 2px">
            <div style="display: inline-block;" v-for="info in infos" :key="info.rid">
              <restaurantCard :info="info" @enterRestEvent="enter_rest"></restaurantCard>
            </div>
            <div v-if="infos.length===0" style="font-size: 80px; width: 100%; height: 400px; margin: 50px auto;line-height: 300px">
              <div style="margin: 10px auto; width: 800px; color: grey">请先选择地址并搜索！</div>
            </div>
          </div>
        </div>
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
  import memberTopBar from '../components/memberTopBar'
    export default {
        name: "nearbyRestaurant",
        components: {visitorTopBar, addressChoice,restaurantCard,memberTopBar},
        data(){
          return{
            visitorMode: localStorage.username === undefined || localStorage.username === null ||  localStorage.username === "",
            address:"",
            search: "",
            btnFlag: false,
            scrollTop: 0,
            showPcdChoice: false,
            pcd: "选择您所在的位置",
            detail_address: "",
            type:['甜品饮品','快餐便当','小吃夜宵','特色菜系',"欧美西餐","日韩美食","异域美味"],
            checkList: [],
            infos:[],
            saveInfos:[],
          }
        },
        mounted(){
            this.pcd = this.$route.params.pcd;
            this.detail_address = this.$route.params.detail_address
            window.addEventListener('scroll', this.scrollToTop)
            if(this.pcd && this.pcd.split(' ').length===3){
                this.searchNearby();
            }
        },
        destroyed () {
          window.removeEventListener('scroll', this.scrollToTop)
        },
        watch: {
          checkList:{
            handler: function (val, oldVal) {
              this.infos = this.searchNewInfos(val);
            }
          },
          search:{
            handler: function (val, oldVal) {
              this.infos = this.searchCertainInfo(val);
            }
          }
        },
        methods:{
          enter_rest:function(info) {
            this.$router.push({name:'restInfo',params:{info:info}});
          },
          searchNewInfos(val){
            if(val.length===0){
              return this.saveInfos;
            }
            let newInfos = [];
            for(var i = 0; i < this.saveInfos.length; i++){
              if(val.indexOf(this.saveInfos[i].type)>=0){
                newInfos.push(this.saveInfos[i]);
              }
            }
            return newInfos
          },
          searchCertainInfo (val) {
            if(val.length===0){
              return this.saveInfos;
            }
            let newInfos = [];
            for(var i = 0; i < this.saveInfos.length; i++){
              if(this.saveInfos[i].name.indexOf(val)>=0){
                newInfos.push(this.saveInfos[i]);
              }
            }
            return newInfos
          },
          changeShowPcdChoice () {
            this.showPcdChoice = !this.showPcdChoice;
          },
          setPcd(pcdChoice){
            console.log("pcd: "+pcdChoice);
            this.pcd = pcdChoice;
          },
          searchNearby () {
            var token = this.pcd.split(' ');
            var valid = true;
            if(token.length !== 3){
              valid = false;
              this.$message({
                message: '请先选择完整的省-市-区',
                type: 'error'
              });
            }
            for(var i = 0; i < token.length; i++){
              if(token[i].length === 0){
                this.$message({
                  message: '请先选择完整的省-市-区',
                  type: 'error'
                });
                valid = false;
                break;
              }
            }
            if(this.detail_address.length===0){
              this.$message({
                message: '请先填写详细地址',
                type: 'error'
              });
              valid = false;
            }
            if(valid){
              localStorage.district = token[2]+this.detail_address;
              localStorage.city = token[1];
              localStorage.province = token[0];
              /*this.$router.push({name:"nearbyRestaurant", params:{pcd:this.pcd, detail_address: this.detail_address}});*/
              console.log(localStorage)
              var self = this;
              this.$axios.get('/rest/get_rests',{
                params:{
                  province: token[0],
                  city: token[1],
                  district: token[2]
                }
              }).then(function(response){
                self.infos = response.data
                self.saveInfos = response.data
                console.log("nearby:")
                console.log(response.data)
              }).catch(function (error) {

              });
            }

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
