<template>
  <div>
    <div style="width: 300px; border: 1px solid gainsboro;border-radius: 5px; color: #7e7e7e; font-size: 16px;
        height: 40px;line-height: 40px;display: flex" @click="changeShowPcdChoice" >
      <div style="width: 265px; height: 40px; margin-left: 10px;overflow: hidden;text-overflow: ellipsis;"><nobr>{{pcd}} </nobr></div>
      <div><i class="el-icon-arrow-down" style="font-size: 16px"></i></div>
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
