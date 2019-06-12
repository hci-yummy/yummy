<template>
  <div>
    <div v-if="visitorMode">
      <visitorTopBar></visitorTopBar>
    </div>
    <div v-else>
      <memberTopBar></memberTopBar>
    </div>
    <div style="width: 100%;margin-top: 50px;margin-left: 20px">
      <div  style="display: flex">
        <div class="pane">
          <foodInfo :food_info="item" v-for="(item, index) in food_list" :key="index" v-on:getFoodEvent="add_basket"></foodInfo>
        </div>

      </div>

      <div class="basket">
        <div style="border-top: 2px solid #409EFF;background-color: #f4f4f4">
          <div style="margin-top: 10px; margin-left: 10px; padding-bottom: 10px; font-size: 14px;">购物车</div>
        </div>

        <div>
          <foodInCart :food="item" v-for="item in basket" :key="item.id" v-on:changeNumEvent="change_num"></foodInCart>
        </div>

        <div style="height: 50px;display: flex">
          <div class="cart">
            <div>
              <i class="el-icon-shopping-cart-2" style="font-size: 25px"></i>
            </div>
            <div style="margin-top:-2px;">
              <span v-show="sum > 0" >&nbsp;￥<span style="font-size: 25px">{{sum}}</span></span>
            </div>
            <div style="font-size: 14px;margin-left: 10px;margin-top: 5px"> | 配送费￥1.5</div>
          </div>

          <div class="waitPay" v-show="sum === 0">
            <div style="font-size: 14px;" align="center">
              <strong>购物车是空的</strong>
            </div>
          </div>

          <div class="waitPay" v-show="sum < 20 && sum > 0">
            <div style="font-size: 14px;" align="center">
              <strong>还差 {{20-sum}} 元起送</strong>
            </div>
          </div>
          <div class="toPay" v-show="sum >= 20" v-on:click="get_basket">
            <div style="margin-left: 30px;color: white"><strong>去结算></strong></div>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>

    import visitorTopBar from '../components/visitorTopBar'
    import memberTopBar from '../components/memberTopBar'
    import foodInfo from '../components/foodInfo'
    import foodInCart from '../components/foodInCart'
    export default {
      name: "rest-info",
      components: {foodInfo, foodInCart, visitorTopBar, memberTopBar},
      mounted:function () {

        this.info = this.$route.params.info;
        console.log(this.info);

        this.id = this.info.rid;
        console.log(this.id);

        this.get_food_list();

        let basket = this.$route.params.basket;
        console.log(basket);
        if(basket === undefined){
          basket = [];
          this.sum = 0;
        }

        this.basket = basket;
        this.cal_sum();

      },
      data() {
        return {

          visitorMode: localStorage.username === undefined || localStorage.username === null ||  localStorage.username === "",

          info:{},
          id:'',
          sum: 0,

          food_list:[],
          basket:[]
        }
      },
      methods: {
        get_food_list() {
          let id = this.id;
          let self = this;
          this.$axios.get('/rest/get_food_list',{
            params:{
              id:id
            }
          }).then(
            function (response) {
              console.log(response.data);
              self.food_list = response.data;
            }
          ).catch(function (error) {
            console.log(error);
        })
        },

        change_num: function(food) {
          for(let i = 0; i < this.basket.length; i++) {
            if(this.basket[i].id === food.id) {
              this.basket[i] = food;
              if(this.basket[i].num === 0) {
                // delete
                this.basket.splice(i, 1);
                i--;
              }
            }
          }

          this.cal_sum();
        },

        cal_sum() {
          this.sum = 0;
          for(let i = 0; i < this.basket.length; i++) {
            this.sum += this.basket[i].price;
          }
        },

        add_basket:function(food) {
          if(food.num > food.amount){
            alert("数量不足！");
          }else {
            let f = {
              id: food.id,
              name: food.name,
              price: food.price * food.num,
              cost: food.price,
              num: food.num,
              amount: food.amount,
            };
            this.check_basket(f);
          }
          this.cal_sum();
        },
        check_basket(f) {

          if(this.basket.length === 0){
            this.basket.push(f);
          }else {
            let isNew = true;
            for(let i = 0; i < this.basket.length; i++) {

              if(this.basket[i].name === f.name) {
                isNew = false;
                let sum = this.basket[i].num + f.num;
                if(sum <= f.amount){
                  this.basket[i].num = sum;
                  this.basket[i].price += f.price;
                  break;
                }else{
                  alert("数量不足！");
                  break;
                }
              }else {
                isNew = true;
              }
            }

            if(isNew) {
              this.basket.push(f);
            }
          }
          /*console.log(this.basket);*/
        },
        get_basket() {

          if(this.visitorMode) {
            // visitor
            this.$router.push({name: 'login', params:{basket: this.basket, info: this.info}});
          }else {
            // member
            this.$router.push({name: 'basket', params:{basket: this.basket, id: this.id}});
          }


        }
      }
    }
</script>

<style scoped>

  .pane {
    width: 100%;
    min-height: 200px;
    display: grid;
    grid-template-columns: 530px 170px;
  }

  .basket{
    width: 320px;
    min-height: 80px;
    position: fixed;
    right: 0px;
    bottom: 0px;
  }

  .cart{
    width: 200px;
    height: 50px;
    background-color: #454342;
    padding-top: 15px;
    padding-left: 5px;
    display: flex;
    color: white;
  }

  .toPay{
    width: 120px;
    height:50px;
    line-height:55px;
    background-color: #55e851;
  }

  .toPay:hover{
    cursor: pointer;
  }

  .waitPay{
    width: 120px;
    height:50px;
    line-height:55px;
    background-color: #dadada;
  }

  .waitPay strong {
    cursor: default;
  }

  .myspace{
    /*个人中心*/
    /*text-indent: 6.3%;*/
    color: black;
    background-color: white;
    margin: 0px;
    border: 0px;
    padding: 5px;
    box-shadow:
      0 1px 6px 0 rgba(0,0,0, .12),
      0 1px 6px 0 rgba(0,0,0, .12);
    border-radius: 3px;
    padding-left: 5%;
  }

  .myspace p{
    font-size: 15px;
    color: #505050;
  }

</style>
