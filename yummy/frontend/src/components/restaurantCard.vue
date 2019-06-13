<template>
    <el-card style="width: 380px; margin-top: 20px; margin-right: 5px; height: 220px">
      <div style="display: flex;" @click="enter_rest">
        <img :src="info.url" style="width: 150px; height: 150px; border: 1px solid gainsboro;"/>
        <div style="margin-left: 20px; font-size: 14px; color: grey; max-width:180px ">
          <div style="font-size: 24px; font-weight: bold; margin-bottom: 10px; color: black; width: 200px; overflow: hidden;text-overflow: ellipsis"> <nobr>{{info.name}}</nobr></div>
          <el-tag style="margin-bottom: 10px" size="mini">{{info.type}}</el-tag>
          <el-rate
            v-model="info.rate"
            disabled
            show-score
            text-color="#ff9900"
            score-template="{value}">
          </el-rate>
          <div style="font-size: 14px; margin-left: 2px">{{info.person}}人评价</div>
          <div style="padding-top: 10px; margin-left: 2px">预计送达时间：{{info.time}}</div>
          <div style="padding-top: 10px; margin-left: 2px">配送费：{{info.price}}</div>
        </div>
      </div>
    </el-card>
</template>

<script>
    export default {
      name: "restaurantCard",
      props:['info'],
      methods: {
        enter_rest() {
          this.$emit("enterRestEvent", this.info);
        }
      }
    }
</script>

<style scoped>

</style>
