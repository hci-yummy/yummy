<template>
  <div>
    <visitorTopBar></visitorTopBar>
    <div class="top">
      <div style="padding-left: 40px">
        餐厅注册
      </div>
    </div>
    <div>
      <el-card class="member">
        <!--<div class="tab_title">
          餐厅基本信息填写：
        </div>-->
        <el-form :inline="true" :label-position="rest_form.labelPosition" ref="rest_form" :rules="rules" :model="rest_form" label-width="130px" style="width: 1000px;margin-right: 20px;">
          <el-form-item class="form-label" label="餐厅名" prop="rest_name">
            <el-input style="width: 300px;" v-model="rest_form.rest_name"></el-input>
          </el-form-item>
          <el-form-item class="form-label" label="餐厅类型" prop="value">
            <el-select v-model="rest_form.value" style="width: 300px;">
              <el-option
                v-for="item in rest_form.type"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item class="form-label" label="所在城区" prop="pcd">
            <addressSelector :pcd="rest_form.pcd" @setPcd="setAddress"></addressSelector>
          </el-form-item>
          <el-form-item class="form-label" label="详细地址" prop="address">
            <el-input style="width: 300px;" v-model="rest_form.address"></el-input>
          </el-form-item>


          <el-form-item class="form-label" label="餐厅图片" prop="pic">
            <el-upload
              class="register-pic"
              drag
              action="http://localhost:8000/upload/image"
              :onSuccess="uploadSuccess"
            >
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em>【只能上传jpg/png文件，且不超过500kb】</div>
              <!--<div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>-->
            </el-upload>
          </el-form-item>


          <el-form-item>
            <div style="width: 875px;margin-top: 10px;">
              <div style="float: right">
                <el-button v-on:click=clear>清空</el-button>
                <el-button type="primary" v-on:click="rest_register">注册</el-button>
              </div>
            </div>
          </el-form-item>
        </el-form>


      </el-card>
      <div style="position: absolute; z-index: -999; width: 100%; background: red; opacity: 0.1;top: 150px">
        <img src="../assets/cake.jpg" style="width: 100%; height: 690px;opacity: 0.8;"/>
      </div><
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
              pcd:{
                province:'',
                city:'',
                district:'',
              },
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
              image:''
            },
            rules:{
              rest_name: [
                { required: true, message: '请输入餐厅名称', trigger: 'blur' },
              ],
              address: [
                { required: true, message: '请填写详细地址', trigger: 'blur' }
              ],
              value: [
                { required: true, message: '请选择餐厅类型', trigger: 'change' }
              ],
              pcd: [
                {required: true }
              ],
              pic:[
                {required: true }
              ]
            }
          }
        },

        methods: {
          uploadSuccess(response, file, fileList) {
            console.log("uploadSuccess");
            this.rest_form.image = "";
            this.rest_form.image += 'http://localhost:8000/';
            this.rest_form.image += response;
            console.log("this.rest_form.image:" + this.rest_form.image);
          },
          setAddress (pcd){
            this.rest_form.pcd = pcd;
          },
          rest_register() {
            if(this.rest_form.province===""||this.rest_form.city===""||this.rest_form.district===""){
              this.$message({
                message: "请选择完整的省-市-区！",
                type: "error"
              })
            }else{
              let name = this.rest_form.rest_name;
              let address = this.rest_form.address;
              let type = this.rest_form.value;
              let self = this;
              this.$axios.post('/rest/register',{
                name: name,
                province: self.rest_form.pcd.province,
                city: self.rest_form.pcd.city,
                district: self.rest_form.pcd.district,
                address: address,
                type: type,
                imageUrl: self.rest_form.image
              }).then(
                function (response) {
                  console.log(response.data);
                  let id = response.data;
                  alert("您餐厅的7位识别码是："+id+"\n 你可使用该识别码登录");
                  localStorage.rest_register_id = id;
                  self.$router.push({name:'restLogin'});
                }
              ).catch(function (error) {
                console.log(error);
              })
            }
          },
          clear() {

          }
        }
    }
</script>

<style scoped>

  .top{
    color: white;
    font-size: 40px;
    width: 100%;
    height: 100px;
    line-height: 100px;
    background-color: #409EFF;
    /*background-image: url("/static/top-back.jpg");*/
    /* background-size: 100% 100%;*/
  }

  .member{
    width: 1000px;
    height: 500px;
    /*margin-top: 10px;*/
    margin: 20px auto;
   /* border: 1px solid black;*/
  }

/*  .tab_title{
    color: #b7b7b7;
    font-size: 20px;
    margin-bottom: 20px;
  }*/
  .register-pic{
    ;
  }

</style>


<style>
  .form-label .el-form-item__label{
    font-size: 14px !important;
  }

  .register-pic .el-upload-dragger{
    width: 745px;
    height: 200px;
  }
</style>
