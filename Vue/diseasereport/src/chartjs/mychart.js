

import echarts from 'echarts'
const install = function(Vue) {
    Object.defineProperties(Vue.prototype, {
        $chart: {
            get() {
                return {
                    
                    //画一条简单的线
                    line1: function (id) {
                        
                        this.chart = echarts.init(document.getElementById(id));
                        this.chart.clear();
    
                        const optionData = {
                            legend: {},
                            tooltip: {},
                            dataset: {
                                source: [
                                    ['product', '2015', '2016', '2017'],
                                    ['Matcha Latte', 43.3, 85.8, 93.7],
                                    ['Milk Tea', 83.1, 73.4, 55.1],
                                    ['Cheese Cocoa', 86.4, 65.2, 82.5],
                                    ['Walnut Brownie', 72.4, 53.9, 39.1]
                                ]
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
                        };

                        this.chart.setOption(optionData);
                    },
                    //柱形图
                    zhu: function (id) {
                        this.chart = echarts.init(document.getElementById(id));
                        this.chart.clear();

                        const optionData = {
                            legend: {},
                            tooltip: {},
                            dataset: {
                                source: [
                                    ['product', '轻微', '严重', '健康'],
                                    ['20200518', 43, 8, 193],
                                    ['20200519', 83, 7, 193],
                                    ['20200520', 86, 6, 182],
                                    ['20200521', 72, 5, 199]
                                ]
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
                        };

                        this.chart.setOption(optionData);
                    },
                }
            }
        }
    })
}

export default {
    install
}