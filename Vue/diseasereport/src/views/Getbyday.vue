<template>
    <div id="getbyday">
        <div id="pick"> 
            <Daypick/>
            <h1>近四天的我校的数据</h1>
        </div>
        <div id="chart1"></div>
    </div>
</template>

<script>
import Daypick from "../components/Daypick.vue"
var echarts = require('echarts');

export default {
    name:'Getbyday',
    components:{
        Daypick,
    },
    data(){
        return{

        }
    },
    mounted(){
        this.$chart.zhu('chart1');
    }
}
</script>

<style scoped>
#getbyday{
    width:80vw;
    height:100vh;
}
#chart1{
    width:80%;
    height:80%;
    margin:0 auto ;
}
#pick{
    margin: 0 auto !important;
}
</style>