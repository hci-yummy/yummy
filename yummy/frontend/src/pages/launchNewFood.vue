<template>
  <div>
    <restTopBar></restTopBar>
    <div class="main-body">
      <h3>发布信息 > 发布新品</h3>
      <hr class="hr1">
      <el-form style="display: flex;" ref="food_info" :model="food_info" label-width="80px">


        <div>
          <el-form-item label="商品名称">
            <el-autocomplete
              style="width: 320px"
              v-model="food_info.name"
              placeholder="请输入商品名称"
              :fetch-suggestions="querySearch">
            </el-autocomplete>
          </el-form-item>

          <el-form-item label="商品类型">
            <el-select style="width: 320px"
                       v-model="food_info.type"
                       filterable
                       allow-create
                       default-first-option
                       placeholder="请选择商品类型">
              <el-option
                v-for="item in food_info.type_list"
                :key="item.value"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="商品单价">
            <el-input v-model="food_info.price"  style="width: 320px"></el-input>
          </el-form-item>

          <el-form-item label="商品数量">
            <el-input v-model="food_info.num"  style="width: 320px"></el-input>
          </el-form-item>

          <el-form-item label="商品描述">
            <el-input v-model="food_info.desc"  style="width: 320px"></el-input>
          </el-form-item>


          <el-form-item>
            <el-button type="primary" v-on:click="launch" style="margin-left: 60px">发布</el-button>
          </el-form-item>
        </div>


        <div style="margin-left: 40px">
          <el-form-item label="在售时段">
            <div style="display: flex;width: 360px ">
              <el-date-picker
                v-model="date1"
                type="date"
                placeholder="选择开始日期"

              >
              </el-date-picker>
              <div>-</div>
              <el-date-picker
                v-model="date2"
                type="date"
                placeholder="选择结束日期"
              >
              </el-date-picker>
            </div>
          </el-form-item>

          <el-form-item label="商品图片">
            <el-upload
              class="upload-demo2"
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

        </div>


      </el-form>
    </div>
  </div>
</template>

<script>
    import restTopBar from '../components/restTopBar'
    export default {
      name: "launch-new-food",
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
          foodList:[ {
            name:'土豆',
            price:10,
            num:1,
          }],
          date1: '',
          date2: '',
          food_info:{
            desc:'',
            image:'',
            name:'',
            price:0.0,
            num:0,
            type:'',
            type_list:[{
              value:'1',
              label:'主食'
            },{
              value:'2',
              label:'小食'
            },{
              value:'3',
              label:'甜品'
            },{
              value:'4',
              label:'饮品'
            }],
          }
        }
      },
      methods:{
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
              self.foodList = response.data;

              for(let i=0;i<self.foodList.length;i++){
                self.nameList.push({
                  value:self.foodList[i].name
                });
              }
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

        uploadSuccess(response, file, fileList) {
          console.log("uploadSuccess");
          this.food_info.image += 'http://localhost:8000/';
          this.food_info.image += response;
          console.log("this.proof:" + this.food_info.image);
        },
        launch() {
          let restId = localStorage.rest_id;
          let name = this.food_info.name;
          let type = this.food_info.type;
          let price = this.food_info.price;
          let amount = this.food_info.num;
          let startDate = this.date1;
          let endDate = this.date2;
          let image = this.food_info.image;
          let descript=this.food_info.desc;

          this.$axios.post('/rest/new_food',{
            restId: restId,
            name: name,
            type: type,
            price: price,
            amount: amount,
            startDate: startDate,
            endDate: endDate,
            image: image,
            description:descript
          }).then(
            function (response) {
              alert("发布成功！");
              window.location.reload();
            }
          ).catch(function (error) {

          })
        }
      }
    }
</script>

<style scoped>
  .main-body{
    margin-top: 30px;
    margin-left: 175px;
    margin-bottom: 50px;

    padding-left: 30px;
    padding-right: 30px;
    padding-bottom: 40px;
    width:900px;
    border: 1px solid gainsboro;
    box-shadow:
      0 1px 6px 0 rgba(0,0,0, .12),
      0 1px 6px 0 rgba(0,0,0, .12);
    border-radius: 3px;
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

.upload-demo2  .el-upload-dragger{
  width: 360px;
  height: 220px;
  padding: 40px;
}
</style>
