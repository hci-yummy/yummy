<template>
  <div>
    <memberTopBar></memberTopBar>
    <el-form class="member_form" ref="member_info" :model="member_info" :label-position="labelPosition" label-width="80px">

<!--      <el-form-item
        v-for="(add ,index) in member_info.addressList"
        :label="'地址' + (index + 1)"
        :key="add.key"
      >

        <div style="display: flex">

          <el-select v-model="add.province" style="width: 120px">
            <el-option
              v-for="item in district_list"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>


          <el-select v-model="add.city" style="width: 120px">
            <el-option
              v-for="item in district_list"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>


          <el-select v-model="add.district" style="width: 120px">
            <el-option
              v-for="item in district_list"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
          <el-input v-model="add.address" style="width: 300px"></el-input>
        </div>
      </el-form-item>-->


<!--      <div class="info_item"
           v-for="(add ,index) in member_info.addressList"
           :key="add.key"
      >
        地址{{(index + 1)}}：{{add.province}}{{add.city}}{{add.district}} {{add.address}}
        <el-button style="margin: 20px" type="primary"   v-on:click="editAddress">删除</el-button>
      </div>

      <el-form-item>
        <el-button type="primary"  v-on:click="submit">保存</el-button>
        <el-button v-on:click="back2Info">返回</el-button>
        <el-button style="margin: 20px" type="primary"   v-on:click="newAddress">添加</el-button>
      </el-form-item>-->


      <el-table
        :data="member_info.addressList"
        stripe=""
        style="width: 100%"
      >
        <el-table-column
          prop="province"
          label="省"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="city"
          label="市"
          align="center"
        >
        </el-table-column>

        <el-table-column
          prop="district"
          label="区"
          align="center"
        >
<!--
          <template slot-scope="scope">
            <el-input-number size="mini" v-model="scope.row.num"></el-input-number>
          </template>-->
        </el-table-column>

        <el-table-column
          prop="address"
          label="地址"
          align="center"
        >
        </el-table-column>

        <el-table-column
          label="操作"
          align="center"
        >
          <template slot-scope="scope">
            <el-button size="mini" @click="delAddress">删除</el-button>
          </template>
        </el-table-column>

        <el-table-column
          label="操作"
          align="center"
        >
          <template slot-scope="scope">
            <el-button size="mini" @click="editAddress">编辑</el-button>
          </template>
        </el-table-column>

      </el-table>
      <el-button style="margin: 20px 20px 20px 500px" type="primary"   v-on:click="newAddress">添加新地址</el-button>

      <el-form-item label="所在地" v-if="editable">

        <div class="selector" style="width: 300px;border: 1px solid gainsboro;border-radius: 5px;color: #7e7e7e;font-size: 16px;height: 40px;line-height: 40px;display: flex" @click="changeShowPcdChoice">
          <div style="width: 265px; height: 40px; margin-left: 10px;overflow: hidden;text-overflow: ellipsis;" v-if="pcd.province !=='' ">{{pcd.province+" "+pcd.city+" "+pcd.district}}</div>
          <div v-else style="width: 265px; height: 40px; margin-left: 10px;overflow: hidden;text-overflow: ellipsis;">请选择所在地</div>
          <div><i class="el-icon-arrow-down" style="font-size: 16px"></i></div>
        </div>

        <div  v-if="showPcdChoice" style="min-height: 100px;margin:5px auto;font-size: 20px; position: absolute;z-index:9999">
          <addressChoice :pcd="pcd" @changeAddress="setPcd" @changeState="changeShowPcdChoice"></addressChoice>
        </div>


      </el-form-item>

      <el-form-item label="具体地址" v-if="editable">
        <el-input v-model="newaddress"></el-input>
      </el-form-item>

      <el-form-item  v-if="editable">
        <el-button  type="primary"   v-on:click="newAddress">确认</el-button>
        <el-button  type="primary"   v-on:click="cancelAddress">取消</el-button>
      </el-form-item>


    </el-form>



  </div>
</template>

<script>
  import memberTopBar from '../components/memberTopBar'
  import addressChoice from '../components/addressChoice'
  export default {
    components: {memberTopBar,
      addressChoice},
    name: "member-address",
    mounted: function () {
      this.get_info();
    }
    ,
    data() {
      return {
        showPcdChoice: false,
        newaddress:'',
        pcd: {
          province: "",
          city: "",
          district: ""
        },
        labelPosition: "left",
        member_info: {},
        district_list:[],
        editable:false
      }
    },
    methods: {
      cancelAddress(){
        this.editable=false;
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
      submit() {
        let username = this.member_info.username;
        let email = this.member_info.email;
        let phone = this.member_info.phone;
        let addressList = this.member_info.addressList;
        let self = this;


        this.$axios.post('/user/edit_info',{
          username: username,
          email: email,
          phone: phone,
          addressList: addressList
        }).then(
          function (response) {
            self.$alert('保存成功！', '', {
              confirmButtonText: '确定'
            });
            self.$router.push({name: "memberInfo"});
          }).catch(function (error) {
          console.log(error);
        })
      },

      editAddress(){
        this.editable=true;
      },

      newAddress(){
        this.editable=true;

      },
      delAddress(){

      },
      back2Info(){
        this.$router.push({name: "memberInfo"})
        /*      this.member_info.addressList.push({
                id: -1,
                province:'',
                city:'',
                district: '',
                address: '',
              });*/
      },


      get_info() {
        let email = localStorage.user_email;
        let self = this;
        this.$axios.get('/user/get_info',{
          params: {
            email: email
          }
        }).then(
          function (response) {
            console.log(response.data);
            self.member_info = response.data;
          }
        ).catch(function (error) {
          console.log(error);
        })
      }
    }
  }
</script>

<style scoped>
  .member_form{
    /*width: 500px;*/
    margin-top: 50px;
    margin-left: 40px;
  }
</style>
