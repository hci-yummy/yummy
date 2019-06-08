<template>
  <div style="display:flex;width: 100%;margin-top: 10px">
    <div style="width: 80%">{{food.name}}</div>
    <div style="width: 11%">x{{food.num}}</div>
    <div style="width: 9%">{{food.sum}}</div>
  </div>
</template>

<script>
    export default {
      name: "food-in-wait-order",
      props:["food"]
    }
</script>

<style scoped>

</style>
