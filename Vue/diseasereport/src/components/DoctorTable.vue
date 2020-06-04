<template>
    <div>
        <el-table
                :data="tableData"
                border="1"
                style="margin: auto">
            <el-table-column
                    prop="id"
                    label="账号"
                    width="140">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="姓名"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    width="80">
            </el-table-column>
            <el-table-column
                    label="操作"
                    width="120">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteById(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                style="text-align: center"
                background
                layout="prev, pager, next"
                :total="total"
                @current-change="pageChange">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            deleteById(row){
                const _this = this;
                axios.get('http://localhost:8001/diseasereport/doctor/delete?id='+row.id).then(function (response) {
                    if (response.data){
                        _this.$alert('删除成功','消息',{
                            confirmButtonText:'确定',
                            callback:action => {
                                window.location.reload();
                            }
                        })
                    }else {
                        _this.$alert('删除失败','消息',{
                            confirmButtonText:'确定',
                            callback:action => {
                                window.location.reload();
                            }
                        })
                    }
                })
            },
            edit(row) {
                this.$router.push({
                    path:'/useredit',
                    query:{
                        studentId:row.studentId
                    }
                })
            },
            pageChange(currentPage){
                const _this = this
                axios.get('http://localhost:8001/diseasereport/doctor/get/list?pageNum='+currentPage+'&pageSize=10').then(function (response) {
                    _this.tableData = response.data.list
                    console.log(_this.tableData)
                })
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8001/diseasereport/doctor/get/list?pageNum=1&pageSize=10').then(function (response) {
                _this.tableData = response.data.list
                _this.total = response.data.total
                console.log(response)
            })
        },
        data() {
            return {
                total: null,
                tableData:[]
            };
        },
    }
</script>

