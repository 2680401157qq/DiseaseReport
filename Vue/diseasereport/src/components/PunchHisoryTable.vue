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
            <el-table-column
                    label="操作"
                    width="auto">
                <template slot-scope="scope">
                    <el-button @click="view(scope.row)" type="text" size="small">查看</el-button>
                    <el-button @click="deleteTable(scope.row)" type="text" size="small">删除</el-button>
                </template>
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
        methods: {
            view(row) {
                this.$router.push({
                    path: '/detail',
                    query: {
                        tableName: row.name
                    }
                })
            },
            deleteTable(row) {
                const _this = this;
                axios.get('http://localhost:8001/diseasereport/punch/delete?tableName=' + row.name).then(function (response) {
                    if (response.data) {
                        _this.$alert('删除成功', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                location.reload();
                            }
                        })
                    } else {
                        _this.$alert('删除失败', '消息', {
                            confirmButtonText: '确定'
                        })
                    }
                });
            }
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
