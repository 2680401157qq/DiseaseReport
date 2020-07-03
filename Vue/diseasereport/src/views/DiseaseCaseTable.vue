<template>
    <el-main>
        <el-table
                :data="tableData"
                style="width: 100%"
                max-height="250">
            <el-table-column
                    prop="id"
                    label="案例id"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.name"
                    label="用户名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.studentNum"
                    label="学号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.sex"
                    label="性别"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.grade"
                    label="年级"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.institute"
                    label="学院"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.major"
                    label="专业"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user.clazz"
                    label="班级"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="diseaseName"
                    label="疾病名称"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="diseaseLevel"
                    label="疾病等级"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="createTime"
                    label="录入时间"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="remark"
                    label="备注"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="160">
                <template slot-scope="scope">
                    <el-button plain type="primary" size="mini">编辑</el-button>
                    <el-button plain type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
            <div style="text-align: center; margin-top: 10px">
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size= "1"
                        :total="3"
                        @current-change="page">
                </el-pagination>
            </div>
    </el-main>
</template>

<script>
    export default {
        data() {
            return {
                total: 0,
                tableData: null,
                pageSize: 50,
            }
        },
        created() {
            const _this = this;

            let form = new FormData();
            form.append("page_no", 1);
            form.append("page_size", this.pageSize);
            axios.post("case/list/get", form).then(function (response) {
                console.log(response.data.list)
                _this.tableData = response.data.list;
                _this.total = response.data.total;
            })
        },
        methods: {
            page(currentPage) {
                const _this = this;
                let form = new FormData();
                form.append("page_no", currentPage + "");
                form.append("page_size", "1");
                axios.post("case/list/get", form).then(function (response) {
                    _this.tableData = response.data.list;
                    _this.total = response.data.total;
                })
            },
            formatter(row, column) {
                return row.address;
            },
            filterTag(value, row) {
                return row.tag === value;
            },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] === value;
            }
        }
    }
</script>

<style scoped>

</style>
