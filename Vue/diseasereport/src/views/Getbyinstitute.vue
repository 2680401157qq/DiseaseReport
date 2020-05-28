<template>
    <div id="getbyinstitute">
        <h1>学院数据展示</h1>
        <Inspick/>
        <div style="text-align:center;"><h2>近几天该学院数据</h2></div>
        <div id="chart1"></div>
    </div>
</template>

<script>
var echarts = require('echarts');
import Inspick from "../components/Institutepick.vue"

export default {
    name:'Getbyinstitute',
    components:{
        Inspick,
    },
    data(){
        return{

        }
    },
    mounted(){
        this.$chart.zhu("chart1");
    }
}
</script>

<style scoped>
#getbyinstitute{
    width:80vw;
    height:100vh;
}
#chart1{
    width:80%;
    height:80%;
    margin:0 auto ;
}
</style>