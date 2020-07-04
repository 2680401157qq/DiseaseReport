<template>
<<<<<<< Updated upstream
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
=======
    <el-container>
        <el-header height="120px" style="border-bottom: 1px solid #DCDFE6">
            <el-form :inline="true" :model="filterForm">
                <el-form-item label="疾病等级:" prop="diseaseLevel">
                    <el-select v-model="filterForm.diseaseLevel" clearable >
                        <el-option v-for="item in diseaseLevelList" :label="item" :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="学院:" prop="institute">
                    <el-select v-model="filterForm.institute" clearable>
                        <el-option v-for="item in instituteList" :label="item" :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="专业:" prop="major" v-show="filterForm.institute !== ''">
                    <el-select v-model="filterForm.major" clearable>
                        <el-option v-for="item in majorList[instituteList.indexOf(filterForm.institute)]" :label="item"
                                   :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="年级:" prop="grade">
                    <el-input v-model.trim="filterForm.grade" placeholder="请输入年级" clearable></el-input>
                </el-form-item>
                <el-form-item label="班级:" prop="clazz" v-show="filterForm.grade !== ''">
                    <el-input v-model.trim="filterForm.clazz" placeholder="请输入班级" clearable></el-input>
                </el-form-item>
                <el-form-item label="宿舍:" prop="clazz">
                    <el-input v-model.trim="filterForm.dormitory" placeholder="宿舍格式例如 Cx-xxx" clearable></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getDiseaseCase" style="width: 80px">筛选</el-button>
                </el-form-item>
            </el-form>
        </el-header>
        <el-main>
            <el-table v-loading="loading" border stripe
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
                        <el-button type="primary" plain size="small" @click="showDialog(scope.$index)">编辑</el-button>
                        <el-button type="danger" plain size="small" @click="deleteDiseaseCase(scope.row.id)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div style="text-align: center; margin-top: 15px">
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :page-size= "pageSize"
                        :total="pageTotal"
                        @current-change="page">
                </el-pagination>
            </div>
        </el-main>
        <el-dialog title="案例信息" :visible.sync="dialogVisible" width="40%" v-loading="dialogLoading">
            <el-form :model="currentDiseaseForm" label-width="80px">
                <el-form-item label="学生学号: " prop="user.studentNum">
                    <el-input disabled v-model="currentDiseaseForm.user.studentNum"></el-input>
                </el-form-item>
                <el-form-item label="学生姓名: " prop="user.name">
                    <el-input disabled v-model="currentDiseaseForm.user.name"></el-input>
                </el-form-item>
                <el-form-item label="疾病名称: " prop="diseaseName">
                    <el-input v-model="currentDiseaseForm.diseaseName"></el-input>
                </el-form-item>
                <el-form-item label="疾病等级: " prop="diseaseLevel">
                    <el-select v-model="currentDiseaseForm.diseaseLevel" clearable>
                        <el-option v-for="item in diseaseLevelList" :label="item" :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="录入时间: " prop="createTime">
                    <el-date-picker type="date" placeholder="选择日期" v-model="currentDiseaseForm.createTime"
                                    :default-value="currentDiseaseForm.createTime" style="width: 100%;">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="备注: " prop="=remark">
                    <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容"
                              v-model="currentDiseaseForm.remark">
                    </el-input>
                </el-form-item>
            </el-form>
            <div style="text-align: center">
                <el-button type="primary" @click="edit">确认修改</el-button>
                <el-button @click="this.dialogVisible=false">取消</el-button>
            </div>
        </el-dialog>
    </el-container>
>>>>>>> Stashed changes
</template>

<script>
    import Common from "../components/Common";

    export default {
        data() {
            return {
<<<<<<< Updated upstream
                total: 0,
                tableData: null,
                pageSize: 50,
=======
                tableData: [
                    {
                        user: {
                            id: '',
                            name: '',
                            sex: '',
                            institute: '',
                            major: '',
                            dormitory: '',
                            clazz: '',
                            grade: '',
                            studentNum: ''
                        },
                        id: '',
                        diseaseLevel: '',
                        diseaseName: '',
                        createTime: new Date(),
                        remark: ''
                    }
                ],
                pageSize: 30,
                pageTotal: 0,
                currentPage: 1,
                loading: false,
                dialogVisible: false,
                currentDiseaseForm: {
                    user: {
                        id: '',
                        name: '',
                        sex: '',
                        institute: '',
                        major: '',
                        dormitory: '',
                        clazz: '',
                        grade: '',
                        studentNum: ''
                    },
                    id: '',
                    diseaseLevel: '',
                    diseaseName: '',
                    createTime: '',
                    remark: ''
                },
                diseaseLevelList: Common.diseaseLevel,
                instituteList: Common.institute,
                majorList: Common.major,
                dialogLoading: false,
                filterForm: {
                    grade: '',
                    institute: '',
                    major: '',
                    clazz: '',
                    dormitory: '',
                    diseaseLevel: ''
                }
>>>>>>> Stashed changes
            }
        },
        created() {
            const _this = this;

            let form = new FormData();
            form.append("page_no", 1);
            form.append("page_size", this.pageSize);
<<<<<<< Updated upstream
            axios.post("case/list/get", form).then(function (response) {
                console.log(response.data.list)
=======
            this.loading = true;
            axios.post("/case/list/get", form).then(function (response) {
                _this.pageTotal = response.data.total;
>>>>>>> Stashed changes
                _this.tableData = response.data.list;
                _this.loading = false;
            }).catch(function (error) {
                _this.loading = false;
            })
        },
        methods: {
            page(currentPage) {
                this.currentPage = currentPage;
                this.getDiseaseCase()
            },
            getDiseaseCase() {
                const _this = this;
                let form = new FormData();
<<<<<<< Updated upstream
                form.append("page_no", currentPage + "");
                form.append("page_size", "1");
                axios.post("case/list/get", form).then(function (response) {
=======
                form.append("page_no", this.currentPage);
                form.append("page_size", this.pageSize);

                if (this.filterForm.diseaseLevel) {
                    form.append("disease_level", this.filterForm.diseaseLevel);
                }
                if (this.filterForm.institute) {
                    form.append("institute", this.filterForm.institute);
                }
                if (this.filterForm.major) {
                    form.append("major", this.filterForm.major);
                }
                if (this.filterForm.grade) {
                    form.append("grade", this.filterForm.grade);
                }
                if (this.filterForm.clazz) {
                    form.append("clazz", this.filterForm.clazz);
                }
                if (this.filterForm.dormitory) {
                    form.append("dormitory", this.filterForm.dormitory);
                }

                this.loading = true;

                axios.post("/case/list/get", form).then(function (response) {
                    _this.loading = false;
>>>>>>> Stashed changes
                    _this.tableData = response.data.list;
                    _this.pageTotal = response.data.total;
                }).catch(function (error) {
                    _this.loading = false;
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
            },
            showDialog(index) {
                this.currentDiseaseForm = this.tableData[index];
                this.dialogVisible = true;
            },
            edit() {
                const _this = this;
                this.dialogLoading = true;
                axios.post('/case/edit/request', this.currentDiseaseForm).then(function (response) {
                    _this.dialogLoading = false;
                    if (response.data !== 0) {
                        _this.dialogVisible = false;
                        _this.$message({message: '修改案例成功！', type: 'success'});
                        _this.getDiseaseCase()
                    } else {
                        _this.$message.error('修改案例失败！')
                    }
                }).catch(function (error) {
                    _this.dialogLoading = false;
                    _this.$message.error('修改案例失败！')
                })
            },
            deleteDiseaseCase(id) {
                this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    const _this = this;

                    axios.get('/case/delete', {params:{id: id}}).then(function (response) {
                        if (response.data !== 0) {
                            _this.$message({message: '删除案例成功！', type: 'success'});
                            _this.getDiseaseCase()
                        } else {
                            _this.$message.error('删除案例失败！')
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
        }
    }
</script>

<style scoped>

</style>
