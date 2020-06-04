<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="账号"
                    width="140">
            </el-table-column>
            <el-table-column
                    prop="studentId"
                    label="学号"
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
                    prop="institute"
                    label="学院"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="major"
                    label="专业"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="grade"
                    label="年级"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="dormitory"
                    label="宿舍"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="clazz"
                    label="班级"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="操作">
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
                axios.get('http://localhost:8001/diseasereport/user/delete?id='+row.id).then(function (response) {
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
                axios.get('http://localhost:8001/diseasereport/user/get/list?pageNum='+currentPage+'&pageSize=10').then(function (response) {
                    _this.tableData = response.data.list
                    console.log(response.data.list)
                })
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8001/diseasereport/user/get/list?pageNum=1&pageSize=10').then(function (response) {
                _this.tableData = response.data.list
                _this.total = response.data.total
            })
        },
        data() {
            return {
                total: null,
                tableData:[]
            };
        }
    }
</script>

