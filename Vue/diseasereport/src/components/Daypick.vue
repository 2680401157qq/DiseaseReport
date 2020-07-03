nu<template>
<div id="pick">
  <div class="block">
    <span class="demonstration">查看某一天的具体情况</span>
    <el-date-picker
      v-model="value2"
      @change="getSum"
      value-format="yyyyMMdd"
      align="right"
      type="date"
      placeholder="选择日期"
      :picker-options="pickerOptions1"
      >
    </el-date-picker>
  </div>
</div>
</template>

<script>
  export default {
    name:"Daypick",
    data() {
      return {
        pickerOptions1: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        value2: '',
      };
    },
    methods:{
        getTime(value2){
            //在这个地方的方法，通过get将选取的日期传送到后台
            var aday=parseInt(value2);
            this.$axios.get('/data/getbyday?day='+aday)
            .then(function(Response){
            console.log(Response.data);
        })
        .catch(function (error) { // 请求失败处理
         console.log("the error info:"+error);
      });
        },
        getInstime(value2){
            //在这个地方的方法，通过get将选取的日期传送到后台
            var aday=parseInt(value2);
            this.$axios.get('/data?day='+aday)
            .then(function(Response){
            console.log(Response.data);
        })
        .catch(function (error) { // 请求失败处理
         console.log("the error info:"+error);
      });
        },
        getSum(value2){
          this.getTime(value2);
          this.getInstime(value2);
        }
    },
    mounted(){
    }
  };
</script>

<style scoped>
#pick{
  margin: 0 auto;
}
</style>>
