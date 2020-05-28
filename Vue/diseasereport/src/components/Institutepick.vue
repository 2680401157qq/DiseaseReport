<template>
  <el-select v-model="value8" @change="getlabel" filterable placeholder="选择要查询的学院">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
</template>

<script>
  export default {
    data() {
      return {
        options: [{
          value: '软件学院',
          label: '软件学院'
        }, {
          value: '计算机学院',
          label: '计算机学院'
        }, {
          value: '土木学院',
          label: '土木学院'
        }, {
          value: '数学学院',
          label: '数学学院'
        }, {
          value: '设计学院',
          label: '设计学院'
        }],
        value8: '',
        label_get: '',
      }
    },
    methods:{
        getlabel(label_get){  
        this.$axios.get('/data/getbyinstitute?institute='+label_get)
        .then(function(Response){
          console.log(Response.data);
        })
        .catch(function (error) { // 请求失败处理
         console.log("the error info:"+error);
      });
            console.log(typeof(label_get));
        }
    }
  }
</script>