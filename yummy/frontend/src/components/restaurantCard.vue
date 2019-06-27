<template>
    <el-card style="width: 285px; margin-top: 20px; margin-right: 3px; height: 180px">
      <div style="display: flex;" @click="enter_rest">
        <img :src="info.url" style="min-width: 100px; max-width: 100px; height: 100px; border: 1px solid gainsboro;margin-top: 5px"/>
        <div style="margin-left: 12px; font-size: 10px; color: grey; max-width:140px ">
          <div style="font-size: 24px; font-weight: bold; margin-bottom: 5px; color: black; width: 150px; overflow: hidden;text-overflow: ellipsis"> <nobr>{{info.name}}</nobr></div>
          <el-tag style="margin-bottom: 5px" size="mini">{{info.type}}</el-tag>
          <el-rate
            v-model="info.rate"
            disabled
            show-score
            text-color="#ff9900"
            score-template="{value}">
          </el-rate>
          <div style="margin-left: 2px">{{info.person}}人评价</div>
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
