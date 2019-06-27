<template>
  <div>
    <visitorTopBar></visitorTopBar>
    <div class="top">
      <div style="padding-left: 40px; padding-bottom: 30px">
        会员注册
      </div>
    </div>
    <div>
      <div class="member">
       <!-- <div class="tab_title">会员基本信息填写：</div>-->
        <el-form :label-position="member_form.labelPosition" ref="member_form" :model="member_form" label-width="80px">
          <el-form-item class="form-label" label="会员名">
            <el-input v-model="member_form.username"></el-input>
          </el-form-item>
          <el-form-item class="form-label" label="邮箱">
            <el-input v-model="member_form.email"></el-input>
          </el-form-item>
          <el-form-item class="form-label" label="手机">
            <el-input v-model="member_form.phone"></el-input>
          </el-form-item>
          <el-form-item class="form-label" label="密码">
            <el-input type="password" v-model="member_form.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <div style="margin-top: 20px; float: right">
              <el-button>清空</el-button>
              <el-button type="primary" v-on:click="member_register" v-loading.fullscreen.lock="fullscreenLoading">注册</el-button>
            </div>
          </el-form-item>
        </el-form>
      </div>
      <div style="position: absolute; z-index: -999; width: 100%; background: red; opacity: 0.1;top: 150px">
        <img src="../assets/cake.jpg" style="width: 100%; height: 560px;opacity: 0.8;"/>
      </div>
    </div>
  </div>
</template>

<script>
    import visitorTopBar from '../components/visitorTopBar'
    export default {
        name: "memberRegister",
        components: {visitorTopBar},
        data() {
          return {
            member_form: {
              labelPosition: 'right',
              username: '',
              email: '',
              password: '',
              phone: ''
            },
            fullscreenLoading: false
          }
      },
      methods: {
        member_register() {
          let a = "a";
          let username = this.member_form.username;
          let email = this.member_form.email;
          let password = this.member_form.password;
          let phone = this.member_form.phone;
          console.log(username, email, password);

          this.fullscreenLoading = true;//遮罩

          let self = this;

          this.$axios.post("/user/register",{
            username: username,
            password: password,
            email: email,
            phone: phone
          }).then(
            function (response) {
              self.fullscreenLoading = false;
              let self2 = self;
              self.$alert('注册成功，点击邮箱链接后账号生效！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  self2.$router.push({name: 'login'});
                }
              })
            }
          )
        },
      }
    }
</script>

<style scoped>

  .top{
    color: white;
    font-size: 50px;
    width: 100%;
    height: 120px;
    line-height: 100px;
    background-color: #409EFF;
    margin-bottom: 60px;
    /*background-image: url("/static/top-back.jpg");*/
    /* background-size: 100% 100%;*/
  }

  .member{
    width: 500px;
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

<style>
  .form-label .el-form-item__label{
    font-size: 12px !important;
  }
</style>
