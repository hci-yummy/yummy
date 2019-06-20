<template>
  <div >
    <memberTopBar></memberTopBar>
    <el-form class="member_form" ref="member_info" :model="member_info" :label-position="labelPosition" label-width="80px">

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
            <el-button size="mini"  type="danger" @click="delAddress(scope.$index)">删除</el-button>
          </template>
        </el-table-column>

<!--        <el-table-column
          label="操作"
          align="center"
        >
          <template slot-scope="scope">
            <el-button size="mini" @click="editAddress">编辑</el-button>
          </template>
        </el-table-column>-->

      </el-table>
      <el-button style="margin: 20px 20px 20px 450px" type="primary"   v-on:click="newAddress">添加新地址</el-button>
      <el-button style="margin: 20px 20px 20px 100px" type="primary"   v-on:click="back2Info">返回</el-button>
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
        <el-input v-model="newAdd"></el-input>
      </el-form-item>

      <el-form-item  v-if="editable" >
        <el-button  type="primary"   v-on:click="confirmAddress">确认</el-button>
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
        newAdd:'',
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

      confirmAddress(){
        let email = localStorage.user_email;
        let username = this.member_info.username;
        let phone = this.member_info.phone;
        let district = this.pcd.district;
        let city=this.pcd.city;
        let province=this.pcd.province;
        let address = this.newAdd;

        let self = this;

        this.$axios.post('/user/new_address',{
            email: email,
            province:province,
            city:city,
            district:district,
            address:address,
            name:username,
            phone:phone

        }).then(
          function (response) {
            self.$router.go(0);
          }
        ).catch(function (error) {
          console.log(error);
        })
      },

      delAddress(index){
        console.log(index);
        let self = this;
        let aid = this.member_info.addressList[index].id;
        console.log(aid);

        this.$axios.get('/user/delete_address',{
          params: {
            aid:aid
          }

        }).then(
          function (response) {
            self.$router.go(0);
          }
        ).catch(function (error) {
          console.log(error);
        })
      },

      back2Info(){
        this.$router.push({name: "memberInfo"})
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
