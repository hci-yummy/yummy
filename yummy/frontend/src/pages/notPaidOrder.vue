<template>
  <div>
    <memberTopBar></memberTopBar>
    <div style="width: 100%" >
      <div style="width: 70%;margin:50px auto">
        <div style="margin-top: 20px; margin-bottom: 20px; display: flex">
          <div style="font-size: 25px;">
            订单状态：<span style="color: #409EFF">未支付</span>
          </div>
          <div style="margin-left: 55%; margin-top: 10px">
            <router-link :to="{name:'order'}" style="color: #409EFF">>>>返回订单列表</router-link>
          </div>
        </div>

        <el-table
          :data="foodList"
          stripe
          width="100%"
        >
          <el-table-column
            prop="name"
            label="商品名称"
            align="center"
          ></el-table-column>
          <el-table-column
            prop="num"
            label="商品数量"
            align="center"
          ></el-table-column>
          <el-table-column
            prop="price"
            label="商品单价(元)"
            align="center"
          ></el-table-column>

        </el-table>
        <div style="color: #7e7e7e;padding-left: 68%;margin-top: 20px">
          <div align="center">
            <div class="title">
              配送费：3.5元
            </div>
            <div class="title">
              会员折扣：-{{this.disByLevel}}元
            </div>
            <div class="title" v-show="fullMoney !== 0">
              店铺满{{this.fullMoney}}减{{this.disByRest}}：-{{this.disByRest}}元
            </div>
            <div style="font-size: 40px;color: red;">
              ￥{{this.sum}}
            </div>
          </div>

        </div>

        <div style="font-size: 20px;">
          <div style="margin-bottom: 10px" v-show="remark !== ''">
            订单备注：{{remark}}
          </div>
        </div>

        <el-row style="float: right;margin: 20px 0px">
          <el-button v-on:click="cancel_order">取消付款</el-button>
          <el-button type="primary"  v-on:click="click_pay">确认付款</el-button>
        </el-row>
      </div>
    </div>

    <modal v-show="isModalVisible" @close="close_modal">
      <div slot="header">输入支付密码</div>
      <div slot="body">
        <el-form :model="pay_form" ref="pay_form" label-width="100px" style="margin-right: 40px">
          <el-form-item label="支付密码">
            <el-input type="password" v-model="pay_form.password"></el-input>
          </el-form-item>
          <div style="height: 20px;color: red;font-size: 12px;margin-left: 100px;margin-top: -10px">
            <span v-show="isPasswordFalse">*密码输入错误</span>
          </div>
        </el-form>
      </div>
      <div slot="footer" style="display: flex">
        <el-button size="mini" @click="close_modal">取消</el-button>
        <el-button size="mini" type="primary" @click="check_password">确认</el-button>
      </div>
    </modal>

  </div>
</template>

<script>
  import memberTopBar from '../components/memberTopBar'
  import modal from '../components/modal'
    export default {
      name: "not-paid-order",
      components: {memberTopBar, modal},
      mounted: function () {
        this.oid = this.$route.params.id;
        this.get_order_info();
      },
      data() {
        return {
          oid: 0,
          foodList:[],
          disByLevel: 0,
          disByRest: 0,
          fullMoney: 0,
          sum: 0,
          remark:'',

          isModalVisible: false,
          pay_form:{
            password:'',
          },
          isPasswordFalse: false,
        }
      },

      methods: {
        get_order_info() {
          let oid = this.oid;
          let self = this;
          this.$axios.get('/order/get_order_detail', {
            params: {
              oid: oid
            }
          }).then(
            function (response) {
              let info = response.data;
              self.foodList = info.foodList;
              self.disByLevel = info.disByLevel;
              self.disByRest = info.disByRest;
              self.fullMoney = info.fullMoney;
              self.sum = info.sum;
              self.remark = info.remark;
            }
          ).catch(function (error) {
            console.log(error);
          })
        },

        click_pay() {
          this.isModalVisible = true;
        },

        check_password() {
          let password = this.pay_form.password;
          let email = localStorage.user_email;
          let self = this;
          this.$axios.get("/user/check_paypassword",{
            params:{
              email: email,
              password: password
            }
          }).then(function (response) {
            if(response.data === true) {
              self.payOrder(self);
            }else {
              self.isPasswordFalse = true;
            }
          }).catch(function (error) {
            console.log(error);
          })
        },

        payOrder(_self) {
          let oid = _self.oid;
          let self = _self;
          _self.$axios.get('/order/pay_order',{
            params: {
              oid: oid
            }
          }).then(
            function (response) {
              let self2 = self;
              let isPaid = response.data;
              if(isPaid) {
                self.$alert('订单支付成功！\n你可以在‘已支付订单’中查看该订单详情', '', {
                  confirmButtonText: '确定',
                  callback: action => {
                    self2.$router.push({name: 'order'});
                  }
                })
              }else {
                self.$alert('未在2分钟内完成支付\n订单已取消！', '', {
                  confirmButtonText: '确定',
                  callback: action => {
                    self2.$router.push({name: 'order'});
                  }
                })
              }
            }
          ).catch(function (error) {
            console.log(error);
          })
        },

        cancel_order() {
          let oid = this.oid;
          let self = this;
          this.$axios.get('/order/cancel_order', {
            params: {
              oid: oid
            }
          }).then(
            function (response) {
              alert("该订单已被取消\n你可以在已失效订单中查看");
              self.$router.push({name: 'order'});
            }
          ).catch(function (error) {
            console.log(error);
          })
        },

        close_modal:function() {
          this.isModalVisible = false;
          this.pay_form.password = "";
          this.isPasswordFalse = false;
        },
      }
    }
</script>

<style scoped>

  .title{
    margin-bottom: 20px;
  }

</style>
