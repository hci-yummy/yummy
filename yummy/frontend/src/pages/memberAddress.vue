<template>
<div>
  <memberTopBar></memberTopBar>
  <el-form class="member_form" ref="member_info" :model="member_info" :label-position="labelPosition" label-width="80px">

    <el-form-item
      v-for="(add ,index) in member_info.addressList"
      :label="'地址' + (index + 1)"
      :key="add.key"
    >
      <div style="display: flex">
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
    </el-form-item>


    <el-form-item>
      <el-button type="primary"  v-on:click="submit">保存</el-button>
      <el-button v-on:click="back2Info">返回</el-button>
    </el-form-item>
  </el-form>


</div>
</template>

<script>
  import memberTopBar from '../components/memberTopBar'
    export default {
      components: {memberTopBar},
        name: "member-address",
      mounted: function () {
        /*    this.district_list = JSON.parse(localStorage.district_list);*/
        this.get_info();
      }
      ,
      data() {
        return {
          labelPosition: "left",
          member_info: {},
          district_list:[],
        }
      },
      methods: {

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

</style>
