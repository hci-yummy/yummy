<template>
    <el-card style="width: 500px; margin-top: 20px; margin-right: 5px;">
      <div style="display: flex;">
        <img src="../assets/logo.png" style="width: 200px; height: 200px; border: 1px solid gainsboro;"/>
        <div style="margin-left: 40px; font-size: 16px; color: grey">
          <div style="font-size: 30px; font-weight: bold; margin-bottom: 40px; color: black">{{info.name}}</div>
          <el-rate
            v-model="info.rate"
            disabled
            show-score
            text-color="#ff9900"
            score-template="{value}">
          </el-rate>
          <div style="padding-top: 5px">预计送达时间：{{info.time}}</div>
          <div style="padding-top: 5px">配送费：{{info.price}}</div>
        </div>
      </div>
    </el-card>
</template>

<script>
    export default {
        name: "restaurantCard",
        props:['info'],
    }
</script>

<style scoped>

</style>
