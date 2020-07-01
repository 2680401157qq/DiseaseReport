<template>
<div id="PickIns">
  <el-select v-model="value8" @change="getlabel" filterable placeholder="选择或输入要查询的学院">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  <br/>
  <br/>
  <div id="fa-chart2">
    <div id="chart2"></div>
  </div>
</div>
</template>

<script>
var echarts = require('echarts');

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
        Insdata:[
                    ['day', '严重', '轻微', '健康'],
                    ['20200515', 43, 85, 93],
                    ['20200516', 83, 73, 55],
                    ['20200517', 86, 65, 82],
                    ['20200518', 72, 53, 39]
          ],
      }
    },
    methods:{
        getlabel(label_get){  
        var aInsdata=this.Insdata;
        this.$axios.get('/api/getbyinstitute?institute='+label_get)
        .then(function(Response){
          console.log(Response.data);
          console.log(aInsdata[1][1]);
          var i=0;
          console.log(Response.data.length);
          for(i;i<4;i++){
            aInsdata[i+1][3]=Response.data[Response.data.length-i-1].healthNum;
            aInsdata[i+1][2]=Response.data[Response.data.length-i-1].lightNum;
            aInsdata[i+1][1]=Response.data[Response.data.length-i-1].seriousNum;
            aInsdata[i+1][0]=Response.data[Response.data.length-i-1].day;
          }
        }).then(setTimeout(()=>{
          var i=0,j=0;
            for(i;i<3;i++){
              for(j;j<4;j++){
                this.Insdata[i][j]=aInsdata[i][j];
              }
            }
            this.showByIns();
        },1000))
        .catch(function (error) { // 请求失败处理
         console.log("the error info:"+error);
      });
            console.log(typeof(label_get));
        },
        showByIns(){
          console.log("showbyIns is uesd");
          var myChart = echarts.init(document.getElementById("chart2"));
          myChart.setOption({
                legend: {},
                tooltip: {},
                title:{
                  text:"近几天学院的数据"
                },
                dataset: {
                source: this.Insdata
            },
            xAxis: {type: 'category'},
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: [
                {type: 'bar'},
                {type: 'bar'},
                {type: 'bar'}
            ]
          })
        }
    },
    mounted(){
      this.showByIns();
    }
  }
</script>

<style scoped>
#PickIns{
  width:80vw;
  height: 80vh;
}
#fa-chart2{
  width:80vw;
  height:80vh;
  display: flex;
  justify-content: center;
}
#chart2{
    width:80%;
    height:100%;
}
</style>