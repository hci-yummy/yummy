<template>
    <div>
      <restTopBar></restTopBar>
      <div class="main_body">
        <h3>发布信息 > 发布套餐</h3>
        <hr class="hr1">
        <el-form style="width: 600px;margin-left: 50px" ref="setmeal_info" :model="setmeal_info" label-width="80px">

          <el-form-item label="套餐名称" >

            <el-autocomplete
              style="width:520px;"
              v-model="setmeal_info.name"
              placeholder="请输入商品名称"
              :fetch-suggestions="querySearch">
            </el-autocomplete>
          </el-form-item>

          <el-form-item label="套餐价格">
            <el-input v-model="setmeal_info.price"></el-input>
          </el-form-item>
          <el-form-item label="套餐数量">
            <el-input v-model="setmeal_info.amount"></el-input>
          </el-form-item>

           <el-form-item label="在售时段">
            <div style="display: flex">
            <el-date-picker
              v-model="date1"
              type="date"
              placeholder="选择开始日期"
              style="width:260px;">
            </el-date-picker>
            <div>-</div>
            <el-date-picker
              v-model="date2"
              type="date"
              placeholder="选择结束日期"
              style="width:260px;">
            </el-date-picker>
          </div>

        </el-form-item>

          <div class="title" style="margin-top: 20px; margin-bottom: 10px">添加商品：</div>
          <el-table
            :data="setmeal_info.food_list"
            stripe=""
            style="width: 100%"
          >
            <el-table-column
              prop="name"
              label="名称"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="price"
              label="单价"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="num"
              label="数量"
              align="center"
            >
              <template slot-scope="scope">
                <el-input-number size="mini" v-model="scope.row.num"></el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="操作"
              align="center"
            >
              <template slot-scope="scope">
                <el-button size="mini" @click="add_food(scope.row.id, scope.row.name, scope.row.price, scope.row.num)">加入套餐</el-button>
              </template>
            </el-table-column>

          </el-table>
        </el-form>

        <el-form style="width: 600px; margin-top: 50px;margin-left: 50px">
          <div class="title">套餐内容:</div>

          <el-table
            :data="real_setmeal.food_list"
            stripe=""
            style="margin-bottom: 30px"
          >
            <el-table-column
              prop="name"
              label="名称"
              align="center"
            >
            </el-table-column>
            <el-table-column
              prop="price"
              label="单价"
              align="center"
            ></el-table-column>
            <el-table-column
              prop="num"
              label="数量"
              align="center"
            ></el-table-column>
            <el-table-column
              label="操作"
              align="center"
            >
              <template slot-scope="scope">
                <el-button size="mini" type="danger" @click="delete_food(scope.$index)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-form-item label="商品图片">
            <el-upload
              class="upload-demo"
              drag
              action="http://localhost:8000/upload/image"
              :onSuccess="uploadSuccess"
              multiple
            >
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
              <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
          </el-form-item>
          <div>
            <el-button style="margin-left: 45%; margin-top: 30px" type="primary" v-on:click="submit">提交</el-button>
          </div>
        </el-form>

      </div>
    </div>
</template>

<script>
  import restTopBar from '../components/restTopBar'
    export default {
      name: "launch-setmeal",
      components:{ restTopBar},
      mounted: function() {

        let restId = localStorage.rest_id;
        let self = this;
        console.log("restId:" + restId);
        this.$axios.get("/rest/is_approved", {
          params: {
            restId: restId
          }
        }).then(
          function(response) {
            let is_approved = response.data;
            if( !is_approved) {
              let self2 = self;
              self.$alert('餐厅修改信息暂未通过审核请稍后！', '', {
                confirmButtonText: '确定',
                callback: action => {
                  self2.$router.push({name: 'restPage'});
              }
              })
            }else {
                self.get_food_list();
            }
          }
        ).catch(function(error){
            console.log(error);
        });
      },

      data() {
        return {
          nameList:[],
          date1:'',
          date2:'',
          setmeal_info:{
            name: '',
            price: 0.0,
            amount: 0,
            food_list: [
              {
                name:'土豆',
                price:10,
                num:1,
              }
            ],
          },
          real_setmeal: {
            food_list:[],
            image:'',
          }
        }
      },
      methods: {
        uploadSuccess(response, file, fileList) {
          console.log("uploadSuccess");
          this.real_setmeal.image += 'http://localhost:8000/';
          this.real_setmeal.image += response;
          console.log("this.proof:" + this.real_setmeal.image);
        },
        add_food(id, name, price, num) {

          let isNew = true;
          for(let i = 0; i < this.real_setmeal.food_list.length; i++){
            if(this.real_setmeal.food_list[i].name === name && this.real_setmeal.food_list[i].price === price){
              this.real_setmeal.food_list[i].num += num;
              isNew = false;
              break;
            }else {
              isNew = true;
            }
          }

          if(isNew){
            let food = {
              id: id,
              name: name,
              price: price,
              num: num
            }

            this.real_setmeal.food_list.push(food);
          }

        },

        delete_food(index) {
          console.log(index);
          this.real_setmeal.food_list .splice(index, 1);
        },

        submit(){
          let rest_id = localStorage.rest_id;
          let name = this.setmeal_info.name;
          let price = this.setmeal_info.price;
          let amount = this.setmeal_info.amount;
          let image = this.real_setmeal.image;
          let food_list = this.real_setmeal.food_list;
          let startDate = this.date1;
          let endDate = this.date2;

          this.$axios.post('/rest/new_setmeal',{
            name: name,
            restId: rest_id,
            price: price,
            amount: amount,
            image:image,
            foodList: food_list,
            startDate: startDate,
            endDate: endDate
          }).then(
            function (response) {
              alert("发布成功！");
              window.location.reload();
            }
          ).catch(function (error) {
            console.log(error);
          })
        },
        querySearch(queryString, cb) {
          var foods = this.nameList;
          var results = queryString ? foods.filter(this.createFilter(queryString)) :foods;
          console.log(foods);
          cb(results);
        },

        createFilter(queryString) {
          return (restaurant) => {
            return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase())>-1);
          };

        },

        get_food_list() {
          let id = localStorage.rest_id;
          let self = this;
          this.$axios.get('/rest/get_food_list',{
            params:{
              id:id
            }
          }).then(
            function (response) {
              console.log(response.data);
              self.setmeal_info.food_list = response.data;

              for(let i=0;i<self.setmeal_info.food_list.length;i++){
                self.nameList.push({
                  value:self.setmeal_info.food_list[i].name
                });
              }
            }
          ).catch(function (error) {
            console.log(error);
          })
        },
      }
    }
</script>

<style scoped>
  .hr1{
    border:none;
    border-bottom: 1px solid #d5d5d5;
    margin-bottom: 20px;
    margin-top: 20px;
    margin-right:15px;
  }
  .title{
    font-size: 24px;
    color: #7e7e7e;
  }

  .main_body{
    margin-top: 30px;
    margin-left: 175px;
    margin-bottom: 50px;

    padding-left: 50px;
    padding-bottom: 40px;
    width:900px;
    border: 1px solid gainsboro;
    box-shadow:
      0 1px 6px 0 rgba(0,0,0, .12),
      0 1px 6px 0 rgba(0,0,0, .12);
    border-radius: 3px;

  }

</style>
<style>
.el-form-item__label{
    color:black !important;
    font-size: 16px !important;
  }
</style>
