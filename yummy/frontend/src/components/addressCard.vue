<template>
  <div class="address" @mousemove="move_in" @mouseleave="move_out" @click="choose_address">
    <div style="display: flex;width: 90%">
      <div style="margin-top: 5px;margin-left: 5px"><i class="el-icon-location-information" style="font-size: 35px; color: #c1c1c1"></i></div>
      <div style="border-left: 1px solid #dadada;height: 50px; width: 0px;margin-left: 15px"></div>
      <div style="margin-left: 20px">
        <div class="content">{{info.name}} {{info.tele}}</div>
        <div class="content">{{info.address}}</div>
      </div>
    </div>
    <div style="width: 50px">
      <div style="width: 50px;height: 30px">
        <div v-show="is_move" class="edit" v-on:click="edit_address">
          修改
        </div>
      </div>

      <div v-show="test">
        <div class="tick">
        </div>
        <div style="margin-top: -18px;margin-left: 48px">
          <strong><i class="el-icon-check" style="color: white;font-size: 16px;"></i></strong>
        </div>
      </div>

    </div>


  </div>
</template>

<script>
    export default {
      name: "address-card",
      props: ["info", "test"],
      data() {
        return {
          is_move: false,
        }
      },
      methods: {
        move_in: function() {
          // console.log("in");
          this.is_move = true;
        },

        move_out: function () {
          // console.log("out");
          this.is_move = false;
        },

        choose_address() {
          //console.log("id:"+this.info.id);
          this.$emit("chooseAddressEvent", this.info.id);
        },

        edit_address() {
          this.$emit("editAddressEvent", this.info);
        }
      }
    }
</script>

<style scoped>
  .address{
    display: flex;
    width: 95%;
    border: 1px solid #dadada;
    height: 50px;
    padding: 10px;
  }

  .address:hover{
    cursor: pointer;
  }

  .content{
    font-size: 14px;
    color: #7e7e7e;
    margin-bottom: 10px;
  }

  .edit{
    font-size: 15px;
    color: #409EFF
  }

  .edit:hover{
    cursor: pointer;
  }

  .tick{
    border: 15px solid transparent;
    border-right: 15px solid #409EFF;
    border-bottom: 15px solid #409EFF;
    width: 0px;
    height: 0px;
    margin-left: 36px;
    /*margin-top: 5px;*/
  }
</style>
