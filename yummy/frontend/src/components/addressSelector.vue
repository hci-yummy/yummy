<template>
  <div>
    <div style="width: 100%; display: flex;">
      <div style="width: 350px; background: #409EFF; color: white; font-size: 20px;display: flex;
      text-align: center; margin-right: 10px; padding: 10px" @click="changeShowPcdChoice">
        <div style="width: 270px; height: 30px; overflow: hidden">{{pcd}}</div>
        <img src="../assets/down.svg" style="width: 30px; height: 30px; float: right; margin-right: 10px"/>
      </div>
    </div>
    <div v-if="showPcdChoice" style="min-height: 100px;margin:5px auto;font-size: 20px; position: absolute;z-index:9999">
      <addressChoice @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
    </div>
  </div>
</template>

<script>
  import addressChoice from '../components/addressChoice'
    export default {
        name: "addressSelector",
        components: {addressChoice},
        props:["pcd"],
        data() {
          return {
            showPcdChoice: false,
          }
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

</style>
