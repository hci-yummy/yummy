<template>
  <div>
    <visitorTopBar></visitorTopBar>
    <div class="back">
      <div class="main">
        <div>
          <img src="../assets/logo.png" style="width: 400px"/>
          <!--<h1 class="title">登 录</h1>-->
        </div>
        <div class="login">
          <el-form ref="login_form" :model="login_form" label-width="80px">
            <el-form-item label="用户邮箱">
              <el-input v-model="login_form.email"></el-input>
            </el-form-item>
            <el-form-item label="用户密码">
              <el-input type="password" v-model="login_form.password"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div>
          <p> <router-link :to="{name:'memberRegister'}"><i> >>>没有账号，去注册</i></router-link><!--<a v-on:click="go"><i> >>>没有账号，去注册</i></a>--></p>
        </div>
        <div class="enter">
          <el-button v-on:click="login">登录</el-button>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
    import visitorTopBar from '../components/visitorTopBar'
    export default {
      name: "login",
      components: {visitorTopBar},
      mounted: function () {
        this.rest_info = this.$route.params.info;
        this.basket = this.$route.params.basket;

        console.log(this.rest_info);
        console.log(this.basket);

      },
      data() {
        return {
          login_form:{
            email:'',
            password:''
          },
          rest_info:{},
          basket:[],
        }
      },
      methods: {

        test() {
          this.$message({
            message: '注销成功！',
            type: 'success'
          });



          setTimeout("console.log('AAAA')", 1000);
        },

        login() {
          let email = this.login_form.email;
          let password = this.login_form.password;
          let self = this;
          console.log("login");
          this.$axios.get('/user/login',{
            params:{
              email:email,
              password:password
            }
          }).then(
            function(response) {
              console.log(response.data);
              if(response.data === ""){
                self.$alert('用户名或者密码错误！', '', {
                  confirmButtonText: '确定',
                })
              }else if(response.data === -1){
                self.$alert('该用户已被注销！', '', {
                  confirmButtonText: '确定',
                })
              }else {
                localStorage.user_email = email;
                localStorage.username = response.data;

                if(self.basket !== undefined && self.rest_info !== undefined) {
                  self.$router.push({name:'restInfo',params:{info:self.rest_info, basket:self.basket}});
                }else {
                  self.$router.push({name:'welcome'});
                }

              }
              /*if(response.data !== "" && response.data !== "-1") {

              }else {

              }*/
            }
          ).catch(function(error){

          })
        },
        go(){
          window.location.href = "http://localhost:3000/#/memberRegister";
        },
      }
    }
</script>

<style scoped>
  .back{
    height: 700px;
    background-image: url("/static/index-back.jpg");
    background-size:100% 100%;
    min-height: 750px;
    border: 1px solid white;
    /*opacity: 0.35;*/
  }

  .main{
    margin-top: 5%;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    width: 50%;
    height: 50%;
    border: 1px solid #409EFF;
    background: rgba(255,255,255,0.7);
  }

/*  .title{
    margin-top: 4%;
    margin-left: 3%;
    color: #409EFF;
  }*/

  .login{
    width:400px;
    margin-left: auto;
    margin-right: auto;
  }

  .enter{
    margin-top: 10px;
  }
</style>

<style>

  /*.el-form-item__label{
    color:white ;
    font-size: 16px !important;
  }*/
  /*.el-form-item__label{
    color:white;
    font-size: 16px;
  }

  .el-input{
    font-size: 18px;
    line-height: 20px;
  }*/
</style>
