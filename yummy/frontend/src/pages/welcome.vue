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
      <input style="width: 550px; font-size: 20px;" placeholder="  您的详细地址"/>
      <div style="width: 10px"></div>
      <el-button type="primary" style="font-size: 20px;">搜索</el-button>
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
            pcd: "选择您所在的城市",
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
          }

        }
    }
</script>

<style scoped>

</style>
