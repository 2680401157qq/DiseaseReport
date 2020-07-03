<template>
<div id="pick">
  <div class="block">
    <span class="demonstration">查看某一天的具体情况</span>
    <el-date-picker
      v-model="value2"
      @change="getTime"
      value-format="yyyyMMdd"
      align="right"
      type="date"
      placeholder="选择日期"
      :picker-options="pickerOptions1"
      >
    </el-date-picker>
  </div>
  <br/>
  <div id="fa-chart3">
    <div id="chart3"></div>
  </div>
  
</div>
</template>

<script>
var echarts = require('echarts');
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
        health: [150, 232, 201, 154, 190, 330, 410],
        ser:[20, 32, 31, 34, 40, 30, 40],
        light: [100, 82, 91, 94, 90, 90, 80],
      };
      
    },
    mounted(){
      this.showByday();
    },
    methods:{
      getTime(value2){
            //在这个地方的方法，通过get将选取的日期传送到后台
            var aday=parseInt(value2);
            console.log("value2 is"+value2);
            var health = this.health;
            var ser = this.ser;
            var light = this.light;
            this.$axios.get('/api/data?day='+aday).then(
              function(Response){
                console.log(Response.data);
                console.log(Response.data[1].healthNum);
                var i=0;
                //var health = [];
                for(i;i<Response.data.length;i++){
                  health[i]=Response.data[i].healthNum;
                  ser[i]=Response.data[i].seriousNum;
                  light[i]=Response.data[i].lightNum;
                }
                console.log("health is"+health);
            }  
            ).then(setTimeout(() => {
                    this.health=health;
                    this.ser=ser;
                    this.light=light;
                    this.showByday();
                    console.log("this.health1+health+"+health);
                    console.log("this.health1+"+this.health);
                  }, 1000),
            ).catch(function (error) { // 请求失败处理
                console.log("the error info1:"+error);
            });
            
        },
      showByday(){
            var myChart = echarts.init(document.getElementById("chart3"));
            console.log("isUsed");
            myChart.setOption({
                title: {
                    text: '各个学院的情况'
                },
                tooltip: {
                  trigger: 'axis'
                },
                legend: {
                  data: ['严重', '轻微', '健康']
                },
                grid: {
                  left: '3%',
                  right: '4%',
                  bottom: '3%',
                  containLabel: true
                },
                toolbox: {
                feature: {
                    saveAsImage: {}
                }
                },
                xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['1学院', '2学院', '3学院', '4学院', '5学院', '6学院', '7学院']
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                {
                    name: '严重',
                    type: 'line',
                    stack: '总量',
                    data: this.ser,
                },
                {
                    name: '轻微',
                    type: 'line',
                    stack: '总量',
                    data: this.light,
                },
                {
                    name: '健康',
                    type: 'line',
                    stack: '总量',
                    data: this.health,
                },
            ]
            })
        }
      },
    
  };
</script>

<style scoped>
#pick{
  width:80vw;
  height:80vh;

}
#fa-chart3{
  width:80vw;
  height:80vh;
  display: flex;
  justify-content: center;
}
#chart3{
    width:80%;
    height:100%;
    
}
</style>>