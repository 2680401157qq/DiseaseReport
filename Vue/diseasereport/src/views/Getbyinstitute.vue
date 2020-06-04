<template>
    <div id="getbyinstitute">
        <div><Inspick /></div>
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
        
        
    }
}
</script>

<style scoped>
#getbyinstitute{
    width:80vw;
    height:100%;
}
#chart1{
    width:80%;
    height:80%;
    margin:0 auto ;
}
</style>