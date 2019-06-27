<template>
  <div>
    <div v-if="visitorMode">
      <visitorTopBar></visitorTopBar>
    </div>
    <div v-else>
      <memberTopBar></memberTopBar>
    </div>
    <div style="z-index: 999">
      <div style="width: 550px; margin:100px auto 20px auto;">
        <img src="../assets/logo.png" style="width: auto;height: auto;max-width: 100%;">
      </div>
      <div style="width: 900px; margin:0 auto;display: flex; font-size: 20px;">
        <div style="width: 250px; background: #409EFF; color: white; font-size: 20px;
      text-align: center; margin-right: 10px; height: 50px; line-height: 50px" @click="changeShowPcdChoice">
          <span v-if="pcd.province !=='' ">{{pcd.province+" "+pcd.city+" "+pcd.district}}</span>
          <span v-else>请选择所在地</span>
          <i class = "el-icon-arrow-down" style="width: 30px; height: 30px;"></i>
        </div>
        <input style="width: 550px; font-size: 20px;" placeholder="  您的详细地址" v-model="detail_address"/>
        <div style="width: 10px"></div>
        <el-button type="primary" style="font-size: 20px;" @click="searchNearby">搜索</el-button>
      </div>
      <div v-if="showPcdChoice" style="width: 900px; min-height: 100px;margin:5px auto;font-size: 20px;">
        <addressChoice :pcd="pcd" @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
      </div>
    </div>
    <div style="position: absolute;top:0; z-index: -999; width: 100%; background: red; opacity: 0.4">
      <img src="../assets/cake.jpg" style="width: 100%; height: 660px;opacity: 0.8;"/>
    </div>

  </div>
</template>

<script>
    import addressChoice from '../components/addressChoice'
    import visitorTopBar from '../components/visitorTopBar'
    import memberTopBar from '../components/memberTopBar'
    export default {
      name: "welcome",
      components: {addressChoice, visitorTopBar,memberTopBar},
        data () {
          return {
            pcd: {
              province: "",
              city: "",
              district: ""
            },
            detail_address: "",
            showPcdChoice: false,
            visitorMode: localStorage.username === undefined || localStorage.username === null ||  localStorage.username === ""
          }
        },
        mounted(){
          this.pcd.province = localStorage.province===undefined? this.pcd.province: localStorage.province;
          this.pcd.city = localStorage.city===undefined? this.pcd.city: localStorage.city;
          this.pcd.district = localStorage.dis===undefined? this.pcd.district: localStorage.dis;
          this.detail_address = localStorage.detail_address===undefined? this.detail_address: localStorage.detail_address;
        },
        methods:{
          setPcd(pcdChoice){
            console.log(pcdChoice);
            this.pcd = pcdChoice;
          },
          changeShowPcdChoice () {
            this.showPcdChoice = !this.showPcdChoice;
          },
          searchNearby () {
            var token = [this.pcd.province, this.pcd.city, this.pcd.district];
            var valid = true;
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
              localStorage.dis = token[2];
              localStorage.detail_address = this.detail_address;
              this.$router.push({name:"nearbyRestaurant", params:{pcd:this.pcd, detail_address: this.detail_address}});
            }

          }

        }
    }
</script>

<style scoped>

</style>
