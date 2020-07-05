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
        health: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
        ser:[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
        light: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
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
                var institute=new Array();
                 
               
                institute[0]="机械与汽车工程学院";
                institute[1]="建筑学院";
                institute[2]="土木与交通学院"
                institute[3]="电子与信息学院";
                institute[4]="材料科学与工程学院"
                institute[5]="化学与化工学院"
                institute[6]="轻工科学与工程学院"
                institute[7]="食品科学与工程学院"
                institute[8]="数学学院"
                institute[9]="物理与光电学院"
                institute[10]="经济与贸易学院"
                institute[11]="自动化科学与工程学院"
                institute[12]="计算机科学与工程学院"
                institute[13]="电力学院"
                institute[14]="生物科学与工程学院"
                institute[15]="环境与能源学院"
                institute[16]="软件学院"
                institute[17]="工商管理学院"
                institute[18]="公共管理学院"
                institute[19]="马克思主义学院"
                institute[20]="外国语学院"
                institute[21]="法学院"
                institute[22]="新闻与传播学院"
                institute[23]="艺术学院"
                institute[24]="体育学院"
                institute[25]="设计学院"
                
                for(i;i<Response.data.length;i++){
                  for(var j=0;j<26;j++){
                    if(Response.data[i].institute===institute[j]){
                      health[j]=Response.data[i].healthNum;
                      ser[j]=Response.data[i].seriousNum;
                      light[j]=Response.data[i].lightNum;
                    }
                  }
                  
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
                dataZoom: {
                  show: true,
                  realtime: true,
                  y: 36,
                  height: 20,
                  start: 20,
                  end: 80
                },
                legend: {
                  data: ['甲', '乙', '丙']
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
                data: [
            "机械与汽车工程学院", "建筑学院", "土木与交通学院", "电子与信息学院", "材料科学与工程学院", "化学与化工学院",
            "轻工科学与工程学院", "食品科学与工程学院", "数学学院", "物理与光电学院", "经济与贸易学院",
            "自动化科学与工程学院", "计算机科学与工程学院", "电力学院", "生物科学与工程学院", "环境与能源学院",
            "软件学院", "工商管理学院", "公共管理学院", "马克思主义学院", "外国语学院", "法学院", "新闻与传播学院",
            "艺术学院", "体育学院", "设计学院"
        ]
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                {
                    name: '甲',
                    type: 'line',
                    stack: '总量',
                    data: this.ser,
                },
                {
                    name: '乙',
                    type: 'line',
                    stack: '总量',
                    data: this.light,
                },
                {
                    name: '丙',
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