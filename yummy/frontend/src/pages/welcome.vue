<template>
  <div>
    <visitorTopBar></visitorTopBar>

    <div style="width: 700px; margin:100px auto 20px auto;">
      <img src="../assets/logo.png" style="width: auto;height: auto;max-width: 100%;">
    </div>
    <div style="width: 900px; margin:0 auto;display: flex; font-size: 20px;">
      <div style="width: 250px; background: #409EFF; color: white; font-size: 20px;
      text-align: center; margin-right: 10px; padding: 10px;" @click="changeShowPcdChoice">
        <span>{{pcd}}</span>
        <img src="../assets/down.svg" style="width: 30px; height: 30px; float: right; margin-right: 10px"/>
      </div>
      <input style="width: 550px; font-size: 20px;" placeholder="  您的详细地址" v-model="detail_address"/>
      <div style="width: 10px"></div>
      <el-button type="primary" style="font-size: 20px;" @click="searchNearby">搜索</el-button>
    </div>
    <div v-if="showPcdChoice" style="width: 900px; min-height: 100px;margin:5px auto;font-size: 20px;">
      <addressChoice @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
    </div>
  </div>
</template>

<script>
    import addressChoice from '../components/addressChoice'
    import visitorTopBar from '../components/visitorTopBar'
    export default {
      name: "welcome",
      components: {addressChoice, visitorTopBar},
        data () {
          return {
            pcd: "选择您所在的位置",
            detail_address: "",
            showPcdChoice: false
          }
        },
        methods:{
          setPcd(pcdChoice){
            console.log("pcd: "+pcdChoice);
            this.pcd = pcdChoice;
          },
          changeShowPcdChoice () {
            this.showPcdChoice = !this.showPcdChoice;
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
              this.$router.push({name:"nearbyRestaurant", params:{pcd:this.pcd, detail_address: this.detail_address}});
            }

          }

        }
    }
</script>

<style scoped>

</style>
