<template>
  <div>
    <memberTopBar></memberTopBar>

    <div style="display:flex;margin-top: 50px;margin-left: 50px">
      <div>
        <el-card style="width: 500px;margin-bottom: 40px;">
          <div slot="header" class="clearfix">
            <span>订单详情</span>
            <el-button style="float: right; padding: 3px 0" type="text" v-on:click="return_to_rest">< 返回商家修改 </el-button>
          </div>
          <div>
            <el-table
              :data="basket"
              stripe
              style="width: 100%"
              @selection-change="handleChange"
            >
              <el-table-column
                prop="name"
                label="商品"
                align="center"
              ></el-table-column>
              <el-table-column
                prop="num"
                label="份数"
                align="center"
              >
                <template  slot-scope="scope" >
                  <el-input-number
                    size="mini"
                    :min="0"
                    v-model="scope.row.num"
                    @change="test(scope.row.num, scope.$index)"
                  ></el-input-number>
                </template>
              </el-table-column>
              <!--<el-table-column
                label="操作"
                align="center"
              >
                <template slot-scope="scope">
                  <el-button plain type="danger" size="mini" @click="delete_food(scope.$index)">删除</el-button>
                </template>
              </el-table-column>-->
              <el-table-column
                prop="price"
                label="小计(元)"
                align="center"
              >
                <template  slot-scope="scope" >
                  <span>{{scope.row.num * scope.row.cost}}</span>
                </template>
              </el-table-column>

            </el-table>
            <div style="color: #7e7e7e;padding-left: 65%;margin-top: 20px">
              <div align="center">
                <div class="tip">
                  配送费：3.5元
                </div>
                <div class="tip">
                  会员折扣：-{{this.disMoneyByLevel}}元
                </div>
                <div class="tip" v-show="fullMoney !== 0">
                  店铺满{{this.fullMoney}}减{{this.disMoneyByRest}}：-{{this.disMoneyByRest}}元
                </div>

                <div  style="font-size: 40px;color: red;">
                  ￥{{this.all}}
                </div>
              </div>

            </div>
            <!--<div style="font-size: 40px;color: red;padding-left: 67%; margin-top: 10px">
              <div align="center" style="width: 200px;">
                ￥{{this.all}}
              </div>
            </div>-->
            <!--<div style="margin-left: 80px;">
              <p style="margin-top: 0"><span style=" font-size: 24px;color: #7e7e7e">收货地址：</span>{{this.now_address}},</p>
              <p><span style="font-size: 24px;color: #7e7e7e">预计送达时间：</span>{{this.time}}</p>
            </div>
            <div style="margin-left: 80px; display: flex;margin-top: 30px">
              <el-button v-on:click="submit">提交订单</el-button>
              &lt;!&ndash;<el-button v-show="this.need_pay">付款</el-button>&ndash;&gt;
            </div>-->
          </div>
        </el-card>
      </div>
      <div style="width: 600px; min-height: 300px;margin-left: 30px">
        <div class="box">
          <div style="display: flex;margin-bottom: -10px">
            <div class="title" style="width: 470px">
              收货地址
            </div>
            <div style="color: #409EFF;cursor: pointer;text-decoration: underline" @click="add_address">
              添加新地址
            </div>
          </div>


          <div v-show="!isShow && showAddress">
            <addressCard :info="now_address" :test="now_address.isChoosed" @editAddressEvent="edit_address" />
          </div>
          <div v-if="isShow && showAddress">
            <addressCard
              :info="item"
              v-for="item in address_list"
              :test="item.isChoosed" :key="item.aid"
              @chooseAddressEvent="choose_address"
              @editAddressEvent="edit_address" />
          </div>

          <div class="address" v-if="!showAddress">
            <p style="margin-right: auto;margin-left: auto; width: 220px">暂无收货地址信息请先添加！</p>
          </div>

          <modal v-show="isModalVisible" @close="close_modal">
            <div slot="header" style="margin-top: 5px">{{title}}</div>
            <div slot="body">
              <div style="width: 700px">
                <el-form :rules="rules" ref="address_form" :model="address_form" style="width: 400px;" label-width="100px">
                  <!--style="width: 500px;height: 300px"-->
                  <el-form-item label="姓名" prop="name">
                    <el-input v-model="address_form.name"></el-input>
                  </el-form-item>
                  <el-form-item label="位置">
                    <addressSelector :pcd="pcd" @setPcd="setAddress"></addressSelector>
                  </el-form-item>
                  <el-form-item label="详细地址" prop="address">
                    <el-input v-model="address_form.address"></el-input>
                  </el-form-item>
                  <el-form-item label="手机号" prop="phone">
                    <el-input style="width: 210px " v-model="address_form.phone"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <span style="color: #c1c1c1;margin-left: 30px;margin-right: 30px;cursor: pointer" @click="close_modal">取消</span> <el-button type="primary" style="width: 120px" @click="save_address">保存</el-button>
                  </el-form-item>
                </el-form>
              </div>

            </div>
            <div slot="footer"></div>
          </modal>

          <div v-show="!isShow && showAddress" class="show" v-on:click="show_list"><span>显示更多地址 <i class="el-icon-arrow-down"></i></span></div>
          <div v-show="isShow && showAddress" class="show" v-on:click="hide_list"><span>收起 <i class="el-icon-arrow-up"></i></span></div>


          <div style="margin-top: 20px">
            <div class="title">
              其他信息
            </div>
            <el-form :model="other_form" ref="other_form" label-width="80px" style="width: 550px">
              <el-form-item label="送达时间"> <span style="margin-left: 20px;font-size: 16px">{{time}}</span></el-form-item>
              <el-form-item label="订单备注">
                <div style="display: flex">
                  <el-input v-model="other_form.remark" style="width: 200px;margin-right: 200px"></el-input><el-button type="danger" @click="submit">确认下单</el-button>
                </div>

              </el-form-item>

            </el-form>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    import memberTopBar from '../components/memberTopBar'
    import addressCard from '../components/addressCard'
    import modal from '../components/modal'
    import addressSelector from '../components/addressSelector'
    export default {
      name: "basket",
      components: {memberTopBar, addressCard, modal, addressSelector},
      mounted: function () {

        this.info = this.$route.params.info;
        this.basket = this.$route.params.basket;

        this.get_address_list();


        this.cal_sum();
        this.get_time();

      },
      data() {
        return {
          info: {},
          basket:[],
          all:0, // 订单实付总额
          disMoneyByLevel: 0,
          fullMoney: 0,
          disMoneyByRest: 0,
          need_pay:false,
          time:'',

          other_form: {
            remark: '' // 备注
          },

          title: "", // 模态框的标题
          address_form: {},
          rules:{
            name: [
              { required: true, message: '请输入收货人姓名', trigger: 'blur' },
            ],
            address: [
              { required: true, message: '请填写详细地址', trigger: 'blur' }
            ],
            phone: [
              { required: true, message: '请填写手机号', trigger: 'blur' }
            ],
          },
          pcd:{
            province:'',
            city:'',
            district:'',
          },

          showAddress: true,
          isShow: false, // 是否显示地址列表
          isModalVisible: false,
          now_address:{}, // 当前缩略显示的地址
          choose_id:'', // 当前选择的地址id
          address_list:[
            /*{
              aid:1,
              name: "1",
              tele: "1234",
              address: "鼓楼区 广州路10号",
              isChoosed: true,
              province: "江苏省",
              city: "南京市",
              district: "鼓楼区",
            },
            {
              aid: 2,
              name: "2",
              tele: "5678",
              address: "栖霞区 仙林大道168号",
              isChoosed: false,
              province: "江苏省",
              city: "南京市",
              district: "栖霞区",
            },
            {
              aid: 3,
              name: "3",
              tele: "9101112",
              address: "玄武区 中山路100号",
              isChoosed: false,
              province: "江苏省",
              city: "南京市",
              district: "玄武区",
            }*/]
        }
      },
      methods: {

        get_address_list() {
          let email = localStorage.user_email;
          let self = this;
          this.$axios.get('/user/get_address',{
            params:{
              email:email,
            }
          }).then(
            function(response) {
              self.address_list = response.data.reverse();

              if(self.address_list.length === 0) {
                self.showAddress = false;
              }

              if(self.choose_id === '') {
                self.choose_id = self.address_list[0].aid;
              }

              // self.choose_id = self.now_address.aid;
              console.log("choose id in get:"+self.choose_id);
              for(let i = 0; i < self.address_list.length; i++) {
                if(self.choose_id === self.address_list[i].aid) {
                  self.address_list[i].isChoosed = true;
                  self.now_address = self.address_list[i];
                }else {
                  self.address_list[i].isChoosed = false;
                }
              }
              // self.now_address = self.address_list[0];
              self.choose_id = self.now_address.aid;
            }
          ).catch(function(error){
              console.log(error);
          })

          return true;
        },

        show_list() {
          this.isShow = true;
          this.get_address_list();
        },

        hide_list() {
          this.isShow = false;

        },

        choose_address: function(id) {
          console.log("in choose:"+id);
          this.choose_id = id;
          let info;
          console.log("length:"+this.address_list.length);
          for(let i = 0; i < this.address_list.length; i++) {
            console.log(id, this.address_list[i].aid);
            if(id == this.address_list[i].aid) {
              this.address_list[i].isChoosed = true;
              this.now_address = this.address_list[i];
              this.choose_id = this.now_address.aid;
              console.log("choose id in click:"+this.choose_id);
            }else {
              this.address_list[i].isChoosed = false;
            }
            info = JSON.parse(JSON.stringify(this.address_list[i]));
            this.$set(this.address_list, i, info);
          }
          console.log(this.address_list);

          console.log("in click after:"+this.choose_id);

        },

        save_address() {
          if(this.title === "编辑地址") {
            this.save_edit_address();
          }else if(this.title === "添加新地址") {
            this.save_add_address();
          }
        },

        save_edit_address() {

          let info = this.address_form;
          let self = this;
          this.$axios.post('/user/modify_address', {
            aid: info.aid,
            province: info.province,
            city: info.city,
            district: info.district,
            address: info.address,
            phone: info.phone,
            name: info.name,
          }).then(function (response) {
            if(response.data === true) {

              let choose_id = self.choose_id;

              new Promise(
                function (resolve, reject) {
                  let test = self.get_address_list();
                  if(test) {
                    resolve("OK");
                  }else {
                    reject("error");
                  }
                }
              )
                .then(function (result) {
                  console.log(result);
                  console.log("in promise:"+choose_id);

                  /*self.choose_address(choose_id);*/
                  setTimeout(function () {
                    self.choose_address(choose_id);
                  }, 200);
                  self.close_modal();

              }).catch(function () {
                console.log("error");
              })


            }

          }).catch(function (error) {
              console.log(error);
          })
        },

        save_add_address() {
          let info = this.address_form;
          let self = this;
          let pcd = this.pcd;

          let email = localStorage.user_email;

          this.$axios.post('/user/new_address', {
            province: pcd.province,
            city: pcd.city,
            district: pcd.district,
            address: info.address,
            phone: info.phone,
            name: info.name,
            email: email,
          }).then(function (response) {
            console.log(response.data);
            if(response.data) {
              self.isShow = false;
              self.showAddress = true;
              /*self.get_address_list();

              self.now_address = self.address_list[0];
              self.now_address.isChoosed = true;
              self.choose_id = self.now_address.aid;*/


              new Promise(
                function (resolve, reject) {
                  let test = self.get_address_list();
                  if(test) {
                    resolve("OK");
                  }else {
                    reject("error");
                  }
                }
              )
                .then(function (result) {



                  /*self.choose_address(choose_id);*/
                  setTimeout(function () {
                    self.choose_address(response.data);


                    self.isShow = false;
                    self.now_address = self.address_list[0];
                    self.now_address.isChoosed = true;
                    self.choose_id = self.now_address.aid;
                    console.log(result);
                    console.log("in promise:"+self.choose_id);

                  }, 200);
                  self.close_modal();

                }).catch(function () {
                console.log("error");
              })


            }

          }).catch(function (error) {
            console.log(error);
          })


          this.close_modal();
        },

        add_address() {
          this.isModalVisible = true;
          this.title = "添加新地址";
          this.pcd = {
            province:'',
            city:'',
            district:'',
          };
          this.address_form = {};
        },

        edit_address: function(info) {
          this.isModalVisible = true;
          this.title = "编辑地址";
          //this.pcd = info.province + " " + info.city + " " + info.district;
          console.log(info);
          this.address_form = info;
          this.pcd.province = info.province;
          this.pcd.city = info.city;
          this.pcd.district = info.district;
        },

        setAddress (pcd){
          this.pcd = pcd;
        },

        close_modal:function() {
          this.isModalVisible = false;
        },

        test(num, index) {
          console.log("test");

          if(num === 0) {
            this.delete_food(index);
          }else {
            this.cal_sum();
          }

        },

        delete_food(index) {
          this.basket.splice(index, 1);
          this.cal_sum();
          console.log(this.basket);
        },
        cal_sum() {
          let basket = this.basket;
          console.log(basket);
          let sum = 0;
          for(let i = 0; i < basket.length; i++) {
            sum += basket[i].num * basket[i].cost;
          }
          console.log("sum:"+sum);

          let email = localStorage.user_email;
          let level = 1;
          this.$axios.get('/user/get_level',{
            params: {
              email: email
            }
          }).then(
            function (response) {
              level = response.data;
            }
          ).catch(function (error) {
            console.log(error);
          });

          let restId = this.info.rid;
          let self = this;
          this.$axios.post('/rest/cal_order',{
            restId: restId,
            level: level,
            sum: sum,
          }).then(
            function (response) {
              console.log(response.data);
              let order = response.data;
              self.all = order.sum + 3.5;
              self.disMoneyByLevel = order.disMoneyByLevel;
              self.fullMoney = order.fullMoney;
              self.disMoneyByRest = order.disMoneyByRest;
            }
          ).catch(function (error) {
            console.log(error);
          })

        },

        get_time(){

          let self = this;
          this.$axios.post('/time/get_time').then(
            function (response) {
              console.log(response.data);
              self.time = response.data;
            }
          )
        },

        submit() {

          if(!this.showAddress){
            this.$alert('请先选择收货地址！', '', {
              confirmButtonText: '确定',
              callback: action => {
                return;
              }
            })
            return;
          }
          let email = localStorage.user_email;
          let restId = this.info.rid;
          let sum = this.all;
          let foodList = this.basket;
          let disByLevel = this.disMoneyByLevel;
          let disByRest = this.disMoneyByRest;
          let fullMoney = this.fullMoney;
          let address = this.now_address.district + " " + this.now_address.address;
          let phone = this.now_address.phone;
          let remark = this.other_form.remark;
          let receiverName = this.now_address.name;

          let self = this;
          this.$axios.post('/order/new_order',{
            email: email,
            restId: restId,
            sum: sum,
            foodList: foodList,
            disByLevel: disByLevel,
            disByRest: disByRest,
            fullMoney: fullMoney,
            address: address,
            phone: phone,
            remark: remark,
            receiverName:receiverName
          }).then(
            function (response) {
              let self2 = self;
              self.$alert('订单提交完成！\n请在2分钟内在‘我的订单’中完成支付', '', {
                confirmButtonText: '确定',
                callback: action => {
                  self2.$router.push({name: 'order'});
                }
              })
            }
          ).catch(
            function (error) {
              console.log(error);
            }
          )
        },

        return_to_rest() {
          this.$router.push({name:'restInfo', params: {basket: this.basket, info: this.info}})
        },

        handleChange() {
          console.log(this.basket);
        }
      },

      computed: {
        a:function() {
          console.log(this.basket);
        }
      }
    }
</script>

<style scoped>
/*Vue中表格修改一项数据后，另一项如何实时变化*/

  .tip{
    margin-bottom: 20px;
  }

  .box{
    margin-left: 20px;
    margin-top: 20px;
  }

  .title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 20px;
  }

  .show{
    /*cursor: pointer;*/
    font-size: 14px;
    color: #7e7e7e;
    margin-top: 10px;
  }

  .show > span:hover {
    cursor: pointer;
  }

.address{
  display: flex;
  width: 95%;
  border: 1px solid #dadada;
  height: 50px;
  padding: 10px;
}




</style>

<style>
  .el-form-item__label{
    color:black !important;
    font-size: 16px !important;
  }
</style>
