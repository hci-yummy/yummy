<template>
    <div style="width: 100%; margin-top: 50px;">
      <p style="margin-left: auto; margin-right: auto; font-size: 30px; width: 30%">即将跳转到登录页面，{{lastTime}}</p>
    </div>
</template>

<script>
    export default {
      name: "loading-page",
      data() {
        return {
          lastTime: 5,
          timer: {}
        }
      },

      mounted() {
        console.log("before");
        let basket = this.$route.params.basket;
        let info = this.$route.params.info;

        let timer = setInterval(() => {
          this.lastTime--;
          console.log(this.lastTime);
          if(this.lastTime <= 0) {
            console.log("结束");
            clearInterval(timer);
            this.$router.push({name: 'login', params:{basket: basket, info: info}});
          }
        }, 1000)
      }
    }
</script>

<style scoped>

</style>
