<template>
  <div style="margin-bottom: 10px">
    <el-card class="food">
      <div style="display: flex">
        <div class="img">
          <img class="size" v-bind:src="food_info.image" alt="">
        </div>
        <div style="margin-left: 30px;margin-top: -18px">
          <div>
            <p><b>{{food_info.name}}</b></p>
            <div style="font-size: 14px;margin-bottom: 10px">
              分类：{{food_info.type}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 剩余：{{food_info.amount}}
            </div>
            <div style="font-size: 14px">
              描述：藤椒炸鸡腿
            </div>
          </div>
          <div>
            <el-row style="margin-top: 10px;">
              <span style="color: red">￥{{food_info.price}}</span>
              <el-input-number size="mini" v-model="food_info.num" style="margin-left: 50px"></el-input-number>
              <el-button size="mini" type="primary" v-on:click="add_food">加入购物车</el-button>
            </el-row>
          </div>
        </div>

      </div>
    </el-card>
  </div>
</template>

<script>
    export default {
      name: "food-info",
      props:["food_info"],

      data() {
          return {
            /*food_info:{
              name:'精品冒菜',
              type:'主食',
              image:'http://localhost:8000/images/upload/1.jpg',
              price:20,
              amount:1000,
              num:1
            }*/
          }
      },
      methods: {
        add_food() {
          console.log("加入购物车");
          this.$emit("getFoodEvent",this.food_info)
        }
      }
    }
</script>

<style scoped>

  .food{
    width:500px;
    height: 150px;
  }

  .img{
    width: 110px;
    height: 110px;
    /*border:1px solid black;*/
    /*margin: 8px;*/
  }

  .size{
    width: 110px;
    height: 110px;
  }

</style>
