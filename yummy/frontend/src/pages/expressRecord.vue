<template>
    <div>
      <restTopBar></restTopBar>
      <div style="width: 1200px;padding-top: 50px; padding-left: 40px;">
        <el-tabs v-model="index" @tab-click="handleClick" :tab-position="tabPosition">
          <el-tab-pane label="待接单订单" name="1">
            <div style="margin-left: 150px">

              <div v-show="not_receive_list.length === 0" style="font-size: 30px;color: #7e7e7e">
                暂时没有需要接单的订单~
              </div>
              <waitReceiveOrder
                :order="item"
                v-for="item in not_receive_list"
                :key="item.oid"
                @receiveEvent="receive_order"
              ></waitReceiveOrder>
            </div>

          </el-tab-pane>
          <el-tab-pane label="待发货订单" name="2">
            <el-card style="margin-left: 30px;width: 1000px;margin-top: -20px;">
              <el-table
                :data="not_deliver_list"
                stripe
                width="100%"
                class="table_style"
              >
                <el-table-column
                  prop="orderTime"
                  label="下单时间"
                  width="190px"
                >
                </el-table-column>
                <el-table-column
                  prop="foodList"
                  label="商品"
                  width="150px"
                >
                  <template slot-scope="scope">
                    <p
                      v-for="item in scope.row.foodList"
                      :key="item.id"
                    >
                      {{item.name + ' x'}}{{item.num}}
                    </p>
                  </template>
                </el-table-column>
                <el-table-column
                  prop="sum"
                  label="总价(元)"
                  width="130px"
                >
                </el-table-column>
                <el-table-column
                  label="是否退订"
                  width="120px"
                >
                  <template slot-scope="scope">
                    <div v-show="!scope.row.isCancel">
                      否
                    </div>
                    <div v-show="scope.row.isCancel">
                      <span style="color: red">是</span>
                    </div>
                  </template>
                </el-table-column>
                <el-table-column
                  label="操作"
                  align="center"
                >
                  <template slot-scope="scope">
                    <el-button v-show="!scope.row.isCancel" size="small" v-on:click="deliver_order(scope.row.oid)">准备发货</el-button>
                    <el-button v-show="scope.row.isCancel" size="small" v-on:click="agree_cancel(scope.row.oid)">接受退订</el-button>

                  </template>
                </el-table-column>
              </el-table>
            </el-card>
          </el-tab-pane>
          <el-tab-pane label="已发货订单" name="3">
            <el-card style="margin-left: 30px;width: 1000px;margin-top: -20px;">
              <el-table
                :data="delivered_list"
                stripe
                width="100%"
                class="table_style"
              >
                <el-table-column
                  prop="orderTime"
                  label="下单时间"

                  width="190px"
                >
                </el-table-column>
                <el-table-column
                  prop="foodList"
                  label="商品"
                  width="170px"
                >
                  <template slot-scope="scope">
                    <p
                      v-for="item in scope.row.foodList"
                      :key="item.id"
                    >
                      {{item.name + ' x'}}{{item.num}}
                    </p>
                  </template>
                </el-table-column>
                <el-table-column
                  prop="sum"
                  label="总价(元)"
                  width="130px"
                >
                </el-table-column>
                <el-table-column
                  prop="state"
                  label="状态"
                >
                </el-table-column>
                <el-table-column
                  label="是否退订"
                  align="center"
                >
                  <template slot-scope="scope">
                    <div v-show="!scope.row.isCancel">
                      否
                    </div>

                    <el-button v-show="scope.row.isCancel" size="small" v-on:click="agree_cancel(scope.row.oid)">接受退订</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </el-card>

          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
</template>

<script>
    import restTopBar from '../components/restTopBar'
    import waitReceiveOrder from '../components/waitReceiveOrder'
    export default {
      name: "express-record",
      components:{restTopBar, waitReceiveOrder},
      mounted: function () {
        this.get_not_receive();
      },
      data() {
        return {
          tabPosition: 'left',
          index: '1',
          not_receive_list: [],
          not_deliver_list: [],
          delivered_list: [],
        }
      },
      methods: {
        handleClick() {
          let index = this.index;
          if(index === '1') {
            this.get_not_receive();
          }else if(index === '2') {
            this.get_not_deliver();
          }else if(index === '3') {
            this.get_delivered();
          }
        },

        get_not_receive() {
          let restId = localStorage.rest_id;
          let self = this;

          this.$axios.get('/order/get_not_receive', {
            params: {
              restId: restId
            }
          }).then(
            function (response) {
              self.not_receive_list = response.data;
              for(let i = 0; i < self.not_receive_list.length; i++) {
                let time = self.not_receive_list[i].orderTime + "";
                time = time.substring(0, 10) + " " + time.substring(11,20);
                self.not_receive_list[i].orderTime = time;
              }
            }
          ).catch(function (error) {
            console.log(error);
          })
        },

        get_not_deliver() {
          let restId = localStorage.rest_id;
          let self = this;

          this.$axios.get('/order/get_not_deliver', {
            params: {
              restId: restId
            }
          }).then(
            function (response) {
              self.not_deliver_list = response.data;
              for(let i = 0; i < self.not_deliver_list.length; i++) {
                let time = self.not_deliver_list[i].orderTime + "";
                time = time.substring(0, 10) + " " + time.substring(11,20);
                self.not_deliver_list[i].orderTime = time;
              }
            }
          ).catch(function (error) {
            console.log(error);
          })
        },

        get_delivered() {
          let restId = localStorage.rest_id;
          let self = this;

          this.$axios.get('/order/get_delivered', {
            params: {
              restId: restId
            }
          }).then(
            function (response) {
              self.delivered_list = response.data;
              for(let i = self.delivered_list.length - 1; i >= 0; i--) {
                let time = self.delivered_list[i].orderTime + "";
                time = time.substring(0, 10) + " " + time.substring(11,20);
                self.delivered_list[i].orderTime = time;
              }
            }
          ).catch(function (error) {
            console.log(error);
          })
        },

        receive_order:function(oid) {
          var self = this;
          this.$axios.get('/order/receive_order',{
            params: {
              oid: oid
            }
          }).then(
            function (response) {
              self.get_not_receive();
              self.$message({
                type:'success',
                message:'接单成功'
              });
            }
          ).catch(function (error) {
            console.log(error);
          })
        },
        deliver_order(oid,) {
          var self = this
          this.$axios.get('/order/deliver_order',{
            params: {
              oid: oid
            }
          }).then(
            function (response) {
              self.get_not_deliver();
              self.$message({
                type:'success',
                message:'发货成功'
              });
            }
          ).catch(function (error) {
            console.log(error);
          })
        },
        agree_cancel(oid, index) {
          let self = this;
          this.$axios.get('/order/agree_cancel', {
            params: {
              oid: oid
            }
          }).then(
            function (response) {
              self.$alert('已接受退订，相关钱款已返还至用户账户中','', {
                confirmButtonText: '确定',
                callback: action => {
                  window.location.reload();
                }
              });
            }
          ).catch(
            function (error) {
              console.log(error);
            }
          )
        }
      }
    }
</script>

<style scoped>

  .table_style{
    margin-left: 50px;
    width: 800px;
  }

</style>

<style>
  .el-tabs__item{
    font-size: 18px !important;
  }
</style>
