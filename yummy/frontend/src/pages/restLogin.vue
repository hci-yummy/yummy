<template>
  <div>
    <visitorTopBar></visitorTopBar>
    <div class="back">
      <div class="main">
        <div>
          <img src="../assets/logo.png" style="width: 700px"/>
          <!--<h1 class="title">登 录</h1>-->
        </div>
        <div>
          <p> <router-link :to="{name:'restaurantRegister'}"><i> >>>没有账号，去注册</i></router-link><!--<a v-on:click="go"><i> >>>没有账号，去注册</i></a>--></p>
        </div>
        <div class="login">
          <el-form ref="login_form" :model="login_form" label-width="100px" style="margin-top: 30px">
            <el-form-item label="餐厅识别码" style="width: 400px">
              <div style="display: flex">
                <el-input v-model="login_form.id" placeholder="请输入7位识别码"></el-input>
                <el-button v-on:click="login" style="margin-left: 10px">登录</el-button>
              </div>
              </el-form-item>
          </el-form>
        </div>
        <div class="enter">

        </div>
      </div>

    </div>
  </div>
</template>

<script>
    import visitorTopBar from '../components/visitorTopBar'
    export default {
      name: "rest-login",
      components: {visitorTopBar},
      data() {
        return {
          login_form:{
            id:''
          }
        }
      },
      mounted() {
        //预填充
        if(localStorage.rest_register_id !== undefined){
          this.login_form.id = localStorage.rest_register_id;
        }
      },
      methods: {
        login() {
          let id = this.login_form.id;
          let self = this;
          console.log("login");
          this.$axios.get('/rest/login',{
            params:{
             id:id
            }
          }).then(
            function(response) {
              console.log(response.data);
              let rest = response.data;
              if(rest === "") {
                alert("该识别码不存在！");
              }else {
                let usable = rest.usable;
                if(usable === true) {
                  localStorage.rest_id = id;
                  localStorage.rest_name = rest.name;
                  self.$router.push({name:'restPage'});
                }else {
                  alert("该餐厅还在审核中，请等待！")
                }
              }
            }
          ).catch(function(error){

          })
        },
        go(){
          window.location.href = "http://localhost:3000/#/restaurantRegister";
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
    width: 60%;
    height: 60%;
    border: 1px solid #409EFF;
    background: rgba(255,255,255,0.7);
  }

/*  .title{
    margin-top: 8%;
    margin-left: 2%;
    color: white;
  }*/

  .login{
    width:400px;
    margin-left: auto;
    margin-right: auto;
  }

  .enter{
    margin-top: 10px;
    margin-left: 30px;
  }
</style>

<!--<style>
  .el-form-item__label{
    color:white ;
    font-size: 16px !important;
  }
</style>-->
