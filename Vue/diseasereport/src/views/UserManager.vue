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
                    fixed="right"
                    label="操作">
                <template slot-scope="scope">
                    <el-button type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
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
            handleClick(row) {
                console.log(row);
            },
            pageChange(currentPage){
                const _this = this
                axios.get('http://localhost:8001/diseasereport/user/get/list?pageNum='+currentPage+'&pageSize=10').then(function (response) {
                    _this.tableData = response.data.list
                    _this.totalPage = response.data.pages
                })
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8001/diseasereport/user/get/list?pageNum=1&pageSize=10').then(function (response) {
                _this.tableData = response.data.list
                _this.total = response.data.total
                console.log(response)
            })
        },
        data() {
            return {
                total: null,
                tableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1518 弄',
                    zip: 200333
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1517 弄',
                    zip: 200333
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1519 弄',
                    zip: 200333
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1516 弄',
                    zip: 200333
                }]
            };
        }
    }
</script>

