<template>
    <div id="getbyday">
        <div id="pick"> 
            <Daypick/>
        </div>
    </div>
</template>

<script>
import Daypick from "../components/Daypick.vue"
//import Chart from "echarts"


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
        //this.$chart.zhu("chart2");
        
    },
    methods:{

    }
}
</script>

<style scoped>
#getbyday{
    width:80vw;
    height:90%;
}
#pick{
    
}
#chart1{
    width:45%;
    height:50%;
    margin:0 auto ;
}
#chart2{
    width:45%;
    height:100%;
    margin:80 10 20 10px;
}

</style>