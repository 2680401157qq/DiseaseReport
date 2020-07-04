<template>
    <div style="width: auto;margin: 0 auto">
        <el-table
                :data="tableData"
                border
                style="width: 100%;margin-top: 15px">
            <el-table-column
                    prop="name"
                    label="名称"
                    width="auto">
            </el-table-column>
            <el-table-column
                    prop="state"
                    label="状态"
                    width="auto">
            </el-table-column>
            <el-table-column
                    prop="date"
                    label="发布时间"
                    width="auto">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "PunchHistory",
        data() {
            return {
                tableData: []
            };
        },
        created() {
            const _this = this
            axios.get('http://localhost:8001/diseasereport/punch/list').then(function (response) {
                console.log(response);
                let dataList = response.data;
                for (let i = 0; i < dataList.length; i++) {
                    dataList[i].state = (dataList[i].state == '1' ? "正在进行" : "已结束");
                }
                _this.tableData = dataList;
            })
        }
    }
</script>

<style scoped>

</style>
