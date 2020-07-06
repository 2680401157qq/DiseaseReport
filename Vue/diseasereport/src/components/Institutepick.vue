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
                    value: '机械与汽车工程学院',
                    label: '机械与汽车工程学院'
                }, {
                    value: '建筑学院',
                    label: '建筑学院'
                }, {
                    value: '土木与交通学院',
                    label: '土木与交通学院'
                }, {
                    value: '电子与信息学院',
                    label: '电子与信息学院'
                }, {
                    value: '材料科学与工程学院',
                    label: '材料科学与工程学院'
                }, {
                    value: '化学与化工学院',
                    label: '化学与化工学院'
                }, {
                    value: '轻工科学与工程学院',
                    label: '轻工科学与工程学院'
                }, {
                    value: '食品科学与工程学院',
                    label: '食品科学与工程学院'
                }, {
                    value: '数学学院',
                    label: '数学学院'
                }, {
                    value: '物理与光电学院',
                    label: '物理与光电学院'
                }, {
                    value: '经济与贸易学院',
                    label: '经济与贸易学院'
                }, {
                    value: '自动化科学与工程学院',
                    label: '自动化科学与工程学院'
                }, {
                    value: '计算机科学与工程学院',
                    label: '计算机科学与工程学院'
                }, {
                    value: '电力学院',
                    label: '电力学院'
                }, {
                    value: '生物科学与工程学院',
                    label: '生物科学与工程学院'
                }, {
                    value: '环境与能源学院',
                    label: '环境与能源学院'
                }, {
                    value: '软件学院',
                    label: '软件学院'
                }, {
                    value: '工商管理学院',
                    label: '工商管理学院'
                }, {
                    value: '公共管理学院',
                    label: '公共管理学院'
                }, {
                    value: '马克思主义学院',
                    label: '马克思主义学院'
                }, {
                    value: '外国语学院',
                    label: '外国语学院'
                }, {
                    value: '法学院',
                    label: '法学院'
                }, {
                    value: '新闻与传播学院',
                    label: '新闻与传播学院'
                }, {
                    value: '艺术学院',
                    label: '艺术学院'
                }, {
                    value: '体育学院',
                    label: '体育学院'
                }, {
                    value: '设计学院',
                    label: '设计学院'
                }],
                value8: '',
                label_get: '',
                Insdata: [
                    ['day', '甲', '乙', '丙'],
                    ['', 0, 0, 0],
                    ['', 0, 0, 0],
                    ['', 0, 0, 0],
                    ['', 0, 0, 0]
                ],
            }
        },
        methods: {
            getlabel(label_get) {
                var aInsdata = this.Insdata;
                this.$axios.get('/api/getbyinstitute?institute=' + label_get)
                    .then(function (Response) {
                        console.log(Response.data);
                        console.log(aInsdata[1][1]);
                        var i = 0;
                        console.log(Response.data.length);
                        for (i; i < 4; i++) {
                            if ((Response.data.length != 0) && (label_get === Response.data[Response.data.length - i - 1].institute)) {

                                //console.log("1111111111111111111"+(label_get===Response.data[Response.data.length-i-1].institute))
                                aInsdata[i + 1][3] = Response.data[Response.data.length - i - 1].healthNum;
                                aInsdata[i + 1][2] = Response.data[Response.data.length - i - 1].lightNum;
                                aInsdata[i + 1][1] = Response.data[Response.data.length - i - 1].seriousNum;
                                aInsdata[i + 1][0] = Response.data[Response.data.length - i - 1].day;
                            } else {
                                aInsdata[i + 1][3] = 0;
                                aInsdata[i + 1][2] = 0;
                                aInsdata[i + 1][1] = 0;
                                aInsdata[i + 1][0] = 0;
                            }
                        }
                    }).then(setTimeout(() => {
                    var i = 0, j = 0;
                    for (i; i < 3; i++) {
                        for (j; j < 4; j++) {
                            this.Insdata[i][j] = aInsdata[i][j];
                        }
                    }
                    this.showByIns();
                }, 1000))
                    .catch(function (error) { // 请求失败处理
                        console.log("the error info:" + error);
                    });
                console.log(typeof (label_get));
            },
            showByIns() {
                console.log("showbyIns is uesd");
                var myChart = echarts.init(document.getElementById("chart2"));
                myChart.setOption({
                    legend: {},
                    tooltip: {},
                    title: {
                        text: "近几天学院的数据"
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
        mounted() {
            this.showByIns();
        }
    }
</script>

<style scoped>
    #PickIns {
        width: 80vw;
        height: 80vh;
    }

    #fa-chart2 {
        width: 80vw;
        height: 80vh;
        display: flex;
        justify-content: center;
    }

    #chart2 {
        width: 80%;
        height: 100%;
    }
</style>
