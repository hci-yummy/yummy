<template>
  <div style="display: flex; height: 45px;background-color: white;">
    <div style="width: 110px;margin-top: 14px;margin-left: 10px;text-overflow: ellipsis;overflow: hidden;font-size: 14px"><nobr>{{food.name}}</nobr></div>
    <div style="width: 150px;margin-top: 10px">
      <el-input-number style="font-size: 1px" size="mini" v-model="food.num" @change="changeNum"></el-input-number>
    </div>
    <div style="width: 60px;margin-top: 13px;color: red">￥{{food.price}}</div>
  </div>
</template>

<script>
    export default {
      name: "food-in-cart",
      props: ['food'],
      data(){
          return {

          }
      },
      methods: {
        changeNum() {
          this.$emit("changeNumEvent", this.food);
        }
      }
    }
</script>

<style scoped>

</style>
