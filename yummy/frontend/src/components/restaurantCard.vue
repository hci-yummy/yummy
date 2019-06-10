<template>
    <el-card style="width: 500px; margin-top: 20px; margin-right: 5px;">
      <div style="display: flex;">
        <img src="../assets/logo.png" style="width: 200px; height: 200px; border: 1px solid gainsboro;"/>
        <div style="margin-left: 40px; font-size: 16px; color: grey">
          <div style="font-size: 30px; font-weight: bold; margin-bottom: 20px; color: black; max-width: 200px; overflow: hidden">{{info.name}}</div>
          <el-tag style="margin-bottom: 10px">{{info.type}}</el-tag>
          <div style="display: flex">
            <el-rate
              v-model="info.rate"
              disabled
              show-score
              text-color="#ff9900"
              score-template="{value}">
            </el-rate>
            <div style="font-size: 14px; margin-left: 10px">{{info.person}}人评价</div>
          </div>
          <div style="padding-top: 10px">预计送达时间：{{info.time}}</div>
          <div style="padding-top: 10px">配送费：{{info.price}}</div>
        </div>
      </div>
    </el-card>
</template>

<script>
    export default {
        name: "restaurantCard",
        props:['info'],
        mounted(){
          document.getElementsByTagName('img')[0].src = info.url;
        }
    }
</script>

<style scoped>

</style>
