<template>
  <div>
    <!--TODO 登录后切换top bar-->
    <visitorTopBar></visitorTopBar>
    <div class="main-body">
      <div style="display: flex">
        <span>当前位置：{{address}}</span>
      </div>
    </div>
  </div>

</template>

<script>
    import visitorTopBar from '../components/visitorTopBar';
    export default {
        name: "nearbyRestaurant",
        components: {visitorTopBar},
        data(){
          return{
            address:"",
          }
        }
    }
</script>

<style scoped>
  .main-body{
    margin-top: 20px;
    margin-left: 50px;
  }
</style>
