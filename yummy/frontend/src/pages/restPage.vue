<template>
<div>
  <restTopBar></restTopBar>
  <div class="rest_info" v-show="!editable">
    <h3>我的餐厅 > 基本信息</h3>
    <hr class="hr1">
    <div style="display: flex">
      <div style="margin-right: 75px;margin-left: 150px">
        <img :src="rest_info.image" style="width: 240px; height: 240px; border: 1px solid gainsboro;margin-bottom: 20px"/>
      </div>
      <div>
        <div class="info_item">
          餐厅名称：{{this.rest_info.name}}
        </div>
        <div class="info_item">
          餐厅编码：{{this.rest_info.id}}
        </div>
        <div class="info_item">
          所在地区：{{this.rest_info.province}}{{this.rest_info.city}}{{this.rest_info.district}}
        </div>
        <div class="info_item">
          餐厅地址：{{this.rest_info.address}}
        </div>
        <div class="info_item">
          餐厅类型：{{this.rest_info.type}}
        </div>
        <div >
          <el-button type="info" plain v-on:click="edit">修改信息</el-button>

        </div>
      </div>
    </div>


  </div>


  <div class="rest_form" v-show="editable">
    <h3>我的餐厅 > 修改信息</h3>
    <hr class="hr1">
    <el-form style="display: flex" :label-position="labelPosition" ref="this.rest_form" :model="rest_form" label-width="100px">

      <div>
        <el-form-item label="餐厅名称">
          <el-input v-model="rest_form.name"></el-input>
        </el-form-item>
        <el-form-item label="餐厅编码">
          <el-input v-model="rest_form.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="所在地区" >
          <div class="selector" style="width: 300px;border: 1px solid gainsboro;border-radius: 5px;color: #7e7e7e;font-size: 16px;height: 40px;line-height: 40px;display: flex" @click="changeShowPcdChoice">
            <div style="width: 265px; height: 40px; margin-left: 10px;overflow: hidden;text-overflow: ellipsis;" v-if="pcd.province !=='' ">{{pcd.province+" "+pcd.city+" "+pcd.district}}</div>
            <div v-else style="width: 265px; height: 40px; margin-left: 10px;overflow: hidden;text-overflow: ellipsis;">请选择所在地</div>
            <div><i class="el-icon-arrow-down" style="font-size: 16px"></i></div>
          </div>
          <div v-if="showPcdChoice" style="min-height: 100px;margin:5px auto;font-size: 20px; position: absolute;z-index:9999">
            <addressChoice :pcd="pcd" @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
          </div>
        </el-form-item>
        <el-form-item label="餐厅地址">
          <el-input v-model="rest_form.address"></el-input>
        </el-form-item>
        <el-form-item label="餐厅类别" >
          <el-select v-model="rest_form.type" style="width: 300px">
            <el-option
              v-for="item in rest_form.type_list"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <div style="margin-top: 40px;margin-left: 43%">
          <el-button type="primary" v-on:click="submit">保存</el-button>
          <el-button type="info" plain v-on:click="back2Info">返回</el-button>
        </div>
      </div>

      <div style="margin-left: 40px">
        <el-form-item label="餐厅图片" >
          <el-upload
            class="upload-demo"
            drag
            action="http://localhost:8000/upload/image"
            :onSuccess="uploadSuccess"

          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
      </div>

    </el-form>
  </div>

</div>

</template>

<script>
  import addressChoice from '../components/addressChoice'
  import restTopBar from '../components/restTopBar'
  export default {
    name: "rest-page",
    components:{
      restTopBar,
      addressChoice},
    mounted:function () {
      this.get_info();
    },
    data() {
      return {
        pcd: {
          province: "",
          city: "",
          district: ""
        },
        showPcdChoice: false,
        editable: false,
        labelPosition:'left',
        rest_info: {
          id:'12345',
          name:'宽窄巷子',
          district:'鼓楼区',
          city:'南京市',
          province:'江苏省',
          address:'南京市鼓楼区湖北路店',
          type:'特色菜系',
          url:''
        },
        rest_form: {
          id:'',
          name:'',
          district:'',
          city:'',
          province:'',
          district_list:[],
          address:'',
          type:'',
          image:'',
          type_list:[],
        }
      }
    },
    methods: {
      back2Info(){
        this.editable = false;
      },
      uploadSuccess(response, file, fileList) {
        console.log("uploadSuccess");
        this.rest_form.image = "";
        this.rest_form.image += 'http://localhost:8000/';
        this.rest_form.image += response;
        console.log("this.rest_form.image:" + this.rest_form.image);
      },
      changeShowPcdChoice () {
        this.showPcdChoice = !this.showPcdChoice;
        document.getElementsByClassName("selector")[0].style.border = "1px solid #DCDCDC"
      },
      setPcd(pcdChoice){
        console.log("pcd: "+pcdChoice);
        this.pcd = pcdChoice;
        document.getElementsByClassName("selector")[0].style.border = "1px solid #409EFF"
      },
      get_info() {
        let id = localStorage.rest_id;
        let self = this;
        this.$axios.get('/rest/login', {
          params: {
            id: id
          }
        }).then(
          function (response) {
            self.rest_info = response.data;
            console.log(self.rest_info.image);
          }
        )
      },
      edit(){
        this.editable = true;
        this.pcd.province=this.rest_info.province;
        this.pcd.city=this.rest_info.city;
        this.pcd.district=this.rest_info.district;
        let obj = {
          name: this.rest_info.name,
          id: this.rest_info.id,
          district: this.rest_info.district,
          address: this.rest_info.address,
          type: this.rest_info.type,
          district_list: [],
          type_list: [
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
          ]
        };
        this.rest_form = obj;
        /*       this.rest_form.district_list = JSON.parse(localStorage.district_list);*/
        /*          this.rest_form.type_list = JSON.parse(localStorage.type_list);*/
      },
      submit(){
        this.editable = false;
        let id = localStorage.rest_id;
        let name = this.rest_form.name;
        let district = this.pcd.district;
        let city=this.pcd.city;
        let province=this.pcd.province;
        let address = this.rest_form.address;
        let type = this.rest_form.type;
        let image = this.rest_form.image;

        let self = this;

        console.log(this.pcd.province);

        this.$axios.post('/rest/save_info',{
          id: id,
          name: name,
          district: district,
          address: address,
          type: type,
          city:city,
          province:province,
          imageUrl:image
        }).then(


          function (response) {
            self.$alert('信息待管理员审核完毕后呈现！','', {
              confirmButtonText: '确定',
              callback: action => {
              }
            });
          }
        ).catch(function (error) {
          console.log(error);
        })
      }
    }
  }
</script>

<style scoped>
  .rest_info{
    margin-top: 30px;
    margin-left: 200px;
    margin-bottom: 50px;

    padding-left: 20px;
    padding-bottom: 40px;
    width:900px;
    border: 1px solid gainsboro;
    box-shadow:
      0 1px 6px 0 rgba(0,0,0, .12),
      0 1px 6px 0 rgba(0,0,0, .12);
    border-radius: 3px;
    margin-bottom: 50px;
  }
  .info_item{
    margin-bottom: 30px;
  }
  .rest_form{
    width: 1060px;
    margin-top: 30px;
    margin-left: 90px;
    margin-bottom: 50px;
    padding-bottom: 40px;
    padding-left: 45px;

    border: 1px solid gainsboro;
    box-shadow:
      0 1px 6px 0 rgba(0,0,0, .12),
      0 1px 6px 0 rgba(0,0,0, .12);
    border-radius: 3px;
  }
</style>

<style>
  .el-form-item__label{
    color: black ;
  }

  .upload-demo  .el-upload-dragger{
    width: 425px;
    height: 300px;
    padding: 60px;
  }

  .hr1{
    border:none;
    border-bottom: 1px solid #d5d5d5;
    margin-bottom: 20px;
    margin-top: 20px;
    margin-right:15px;
  }
</style>
