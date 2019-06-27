<template>
  <div>
    <memberTopBar></memberTopBar>

    <div class="member_info" v-show="!editable">
      <h3>个人中心 > 基本信息</h3>
      <hr class="hr1">

      <div style="display: flex">
        <div style="margin: 50px">
          <img src="/static/user1.png" style="width: 200px"/>
        </div>

        <div>
          <div class="info_item">
            用户名：{{this.member_info.username}}
          </div>
          <div class="info_item">
            邮箱：{{this.member_info.email}}
          </div>
          <div class="info_item">
            手机：{{this.member_info.phone}}
          </div>
          <div class="info_item"
               v-for="(add ,index) in member_info.addressList"
               :key="add.key"
          >
            地址{{(index + 1)}}：{{add.province}}{{add.city}}{{add.district}} {{add.address}}
          </div>
          <div class="info_item">
            当前等级：{{this.member_info.level}}
          </div>
          <div class="info_item">
            当前积分：{{this.member_info.score}}
          </div>

          <div style="margin-left: 50px; display: flex">
            <el-button type="info" plain v-on:click="edit" size="middle">修改信息</el-button>
            <el-button type="danger" plain="" v-on:click="deleteMember" size="middle">注销账号</el-button>
          </div>
        </div>
      </div>
    </div>

    <div style="position: absolute; z-index: -999; width: 100%; background: red; opacity: 0.2;top: 50px">
      <img src="../assets/cake.jpg" style="width: 100%; height: 100%;opacity: 0.6;"/>
    </div>

    <div v-show="editable" class="member_info">
      <h3>个人中心 > 修改信息</h3>
      <hr class="hr1">

      <div style="display: flex">
        <div style="margin-top: 30px">
          <img src="/static/user1.png" style="width: 200px"/>
        </div>


        <div>
          <el-form class="member_form" ref="member_info" :model="member_info" :label-position="labelPosition" label-width="80px">
            <el-form-item label="用户名">
              <el-input class="input_box" v-model="member_info.username"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
              <el-input class="input_box" v-model="member_info.email" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="手机">
              <el-input class="input_box" v-model="member_info.phone"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary"  v-on:click="submit">保存</el-button>
              <el-button v-on:click="add_address">管理地址</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>

    </div>

  </div>
</template>



<script>
  import memberTopBar from '../components/memberTopBar'
  import restNavi from '../components/restNavi'
  export default {
    name: "member-info",
    components: { restNavi,memberTopBar},
    mounted: function () {
      /*    this.district_list = JSON.parse(localStorage.district_list);*/
      this.get_info();
    },
    data() {
      return {
        labelPosition: "left",
        editable: false,
        member_info: {},
        district_list:[],
      }
    },
    methods: {
      edit() {
        this.editable = true;
      },
      deleteMember() {
        let email = localStorage.user_email;
        let self = this;
        this.$confirm('注销账户后该账户永不可用，是否注销账户？','提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(()=>{
            let self2 = self;
            self.$axios.get('/user/delete_member', {
              params: {
                email: email,
              }
            }).then(
              function (response) {
                self2.$message({
                  message: '注销成功！',
                  type: 'success'
                });
                setTimeout("window.location.href = 'http://localhost:3000/#/login'", 3000);
              }
            ).catch(function (error) {
              console.log(error);
            })
          }
        ).catch(
        )
      },
      submit() {
        this.editable = false;
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
            })
          }).catch(function (error) {
          console.log(error);
        })
      },
      add_address(){
        /*      this.member_info.addressList.push({
                id: -1,
                province:'',
                city:'',
                district: '',
                address: '',
              });*/
        this.$router.push({name: "memberAddress"})
      },
      get_info() {
        let email = localStorage.user_email;
        console.log("aaa"+email);
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
  .member_info{
    background-color: white;
    padding-left: 20px;
    padding-bottom: 20px;
    width:900px;
    border: 1px solid gainsboro;
    box-shadow:
      0 1px 6px 0 rgba(0,0,0, .12),
      0 1px 6px 0 rgba(0,0,0, .12);
    border-radius: 3px;
    margin-top: 30px;
    margin-left: 200px;
    margin-bottom: 50px;
  }
  .info_item{
    margin-bottom: 30px;
  }
  .member_form{
    /*width: 500px;*/
    margin-top: 40px;
    margin-left: 20px;
  }
  .input_box{
    width: 420px;
  }

  .hr1{
    border:none;
    border-bottom: 1px solid #d5d5d5;
    margin-bottom: 20px;
    margin-top: 20px;
    margin-right:15px;
  }
</style>

<style>
  .el-form-item__label{
    color:black !important;
    font-size: 16px !important;
  }
</style>
