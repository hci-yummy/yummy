<template>
  <div>
    <visitorTopBar></visitorTopBar>
    <div class="top">
      <div style="padding-left: 40px">
        <i>Take Out</i> 餐厅注册
      </div>
    </div>
    <div>
      <div class="member">
        <!--<div class="tab_title">
          餐厅基本信息填写：
        </div>-->
        <el-form :label-position="rest_form.labelPosition" ref="rest_form" :model="rest_form" label-width="100px" style="width: 430px;">
          <el-form-item class="form-label" label="餐厅名">
            <el-input style="width: 300px;margin-left: 30px" v-model="rest_form.rest_name"></el-input>
          </el-form-item>
          <el-form-item class="form-label" label="所在城区">
            <addressSelector :pcd="rest_form.pcd" @setPcd="setAddress" style="margin-left: 30px"></addressSelector>
          </el-form-item>
          <el-form-item class="form-label" label="详细地址">
            <el-input style="width: 300px;margin-left: 30px" v-model="rest_form.address"></el-input>
          </el-form-item>
          <el-form-item class="form-label" label="餐厅类型">
            <el-select v-model="rest_form.value" style="width: 300px;margin-left: 30px">
              <el-option
                v-for="item in rest_form.type"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <div style="margin-top: 20px;float: right">
              <el-button type="primary" v-on:click="rest_register">注册</el-button>
              <el-button v-on:click=clear>清空</el-button>
            </div>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
    import visitorTopBar from '../components/visitorTopBar'
    import addressSelector from '../components/addressSelector'
    export default {
        name: "restaurantRegister",
        components: {visitorTopBar,addressSelector},
        data() {
          return {
            rest_form:{
              labelPosition:'right',
              rest_name:'',
              address:'',
              type:[
                {
                  value:'甜品饮品',
                  label:'甜品饮品'
                },
                {
                  value:'快餐便当',
                  label:'快餐便当'
                },
                {
                  value:'小吃夜宵',
                  label:'小吃夜宵'
                },
                {
                  value:'特色菜系',
                  label:'特色菜系'
                },
                {
                  value:'欧美西餐',
                  label:'欧美西餐'
                },
                {
                  value:'日韩美食',
                  label:'日韩美食'
                },
                {
                  value:'异域美味',
                  label:'异域美味'
                }
              ],
              value:'',
              province:'',
              city:'',
              district:'',
            },
          }
        },

        methods: {
          setAddress (pcd){
            var token = pcd.split(' ');
            if(token.length===3){
              this.rest_form.province = token[0];
              this.rest_form.city = token[1];
              this.rest_form.district = token[2];
            }
          },
          rest_register() {
            if(this.rest_form.province===""||this.rest_form.city===""||this.rest_form.district===""){
              this.$message({
                message: "请选择完整的省-市-区！",
                type: "error"
              })
            }else{
              console.log(this.rest_form)
            }

            let name = this.rest_form.rest_name;
            let district = this.rest_form.district;
            let address = this.rest_form.address;
            let type = this.rest_form.value;

            let self = this;
            /*this.$axios.post('/rest/register',{
              name: name,
              district:district,
              address: address,
              type: type
            }).then(
              function (response) {
                console.log(response.data);
                let id = response.data;
                alert("您餐厅的7位识别码是："+id+"\n 你可使用该识别码登录");
                self.$router.push({name:'restLogin'});
              }
            ).catch(function (error) {
              console.log(error);
            })*/
          },
          clear() {

          }
        }
    }
</script>

<style scoped>

  .top{
    color: white;
    font-size: 50px;
    width: 100%;
    height: 180px;
    line-height: 200px;
    background-color: #409EFF;
    margin-bottom: 30px;
    /*background-image: url("/static/top-back.jpg");*/
    /* background-size: 100% 100%;*/
  }

  .member{
    width: 500px;
    height: 600px;
    /*margin-top: 10px;*/
    margin: 80px auto;
    /*border: 1px solid black;*/
  }

/*  .tab_title{
    color: #b7b7b7;
    font-size: 20px;
    margin-bottom: 20px;
  }*/

</style>
