<template>
    <div>
      <el-card class="order">
        <div slot="header" class="clearfix">
          <span>{{order.orderTime}}</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="receive_order">接单&nbsp&nbsp&nbsp</el-button>
        </div>
        <div>
          <div style="display: flex">
            <div class="person">
              <p>
                <strong>{{order.memberName}}</strong>
              </p>

              <div>
                {{order.address}}
              </div>
            </div>
            <div class="tele">
              <p style="color: #409EFF;"> <i class="el-icon-phone"></i>{{order.phone}}</p>
            </div>
          </div>
          <el-divider></el-divider>
        </div>


        <div v-show="order.remark.length !== 0">
          <div> <span style="color: #ff6445;">备注： </span>{{order.remark}}</div>
          <el-divider></el-divider>
        </div>

        <div>
          <div>
            <strong>商品</strong>
          </div>
          <foodInWaitOrder :food="item" v-for="item in order.foodList" :key="item.name"></foodInWaitOrder>

        </div>
      </el-card>
    </div>
</template>

<script>
    import foodInWaitOrder from './foodInWaitOrder'
    export default {
      name: "wait-receive-order",
      components:{foodInWaitOrder},
      props:['order'],
      data() {
        return {
          /*order: {
            time: '2019/06/08 12:03:07',
            name: '某翔',
            tele: '18861524027',
            address: '南京大学鼓楼校区',
            tip: '不要辣，不要一次性筷子',
            food: [
              {
              name: '脆骨丸子',
              num: 3,
              sum: 16.9
            },
              {
                name: '照烧鸡排饭',
                num: 1,
                sum: 25.9
              }]
          }*/
        }
      },

      methods: {
        receive_order() {
          let oid = this.order.oid;
          this.$emit("receiveEvent", oid);
        },
      }

    }
</script>

<style scoped>
  .order{
    width: 700px;
    min-height: 200px;
    /*padding-left: 10px;*/
  }

  .person{
    /*border: 1px solid black;*/
    width: 81%;
    height: 70px;
    /*margin-left: 10px;*/
  }

  .tele{
    /*border: 1px solid black;*/
    width: 19%;
    height: 70px;
    /*padding-left: 120px;*/
  }
</style>
