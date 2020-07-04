<template>
    <el-container>
        <el-header height="120px" style="border-bottom: 1px solid #DCDFE6; padding-bottom: 10px">
            <el-form :inline="true" :model="filterForm">
                <el-form-item label="疾病等级:">
                    <el-select v-model="filterForm.diseaseLevel" clearable>
                        <el-option v-for="item in diseaseLevelList" :label="item" :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="学院:">
                    <el-select v-model="filterForm.institute" clearable>
                        <el-option v-for="item in instituteList" :label="item" :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="专业:" v-show="filterForm.institute !== ''">
                    <el-select v-model="filterForm.major" clearable>
                        <el-option v-for="item in majorList[instituteList.indexOf(filterForm.institute)]" :key="item"
                                   :label="item" :value="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="年级:">
                    <el-input v-model.trim="filterForm.grade" placeholder="请输入年级" clearable></el-input>
                </el-form-item>
                <el-form-item label="班级:" v-show="filterForm.grade !== ''">
                    <el-input v-model.trim="filterForm.clazz" placeholder="请输入班级" clearable></el-input>
                </el-form-item>
                <el-form-item label="宿舍:">
                    <el-input v-model.trim="filterForm.dormitory" placeholder="宿舍格式应为 Cx-xxx" clearable></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" style="width: 100px" @click="getDiseaseCase">查询</el-button>
                </el-form-item>
            </el-form>
        </el-header>
        <el-main>
            <el-table border stripe :data="tableData" style="width: 100%" max-height="250" v-loading="loading">
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
                        prop="user.dormitory"
                        label="宿舍"
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
                <el-table-column fixed="right" label="操作" width="160px">
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
        <el-dialog title="编辑案例信息" :visible.sync="dialogVisible" width="40%" v-loading="dialogLoading">
            <el-form :model="currentDiseaseCase" label-width="auto" style="padding-right: 20px;padding-left: 20px">
                <el-form-item label="学生学号: ">
                    <el-input disabled v-model="currentDiseaseCase.user.studentNum"></el-input>
                </el-form-item>
                <el-form-item label="学生姓名: ">
                    <el-input disabled v-model="currentDiseaseCase.user.name"></el-input>
                </el-form-item>
                <el-form-item label="疾病名称">
                    <el-input v-model="currentDiseaseCase.diseaseName"></el-input>
                </el-form-item>
                <el-form-item label="疾病等级">
                    <el-select v-model="currentDiseaseCase.diseaseLevel" clearable>
                        <el-option v-for="item in diseaseLevelList" :label="item" :value="item" :key="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="录入时间">
                    <el-date-picker type="date" placeholder="选择日期" v-model="currentDiseaseCase.createTime" style="width: 100%;">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="备注">
                    <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容"
                              v-model="currentDiseaseCase.remark">
                    </el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="edit">确 定</el-button>
            </div>
        </el-dialog>
    </el-container>
</template>

<script>
    import Common from "../components/Common";

    export default {
        data() {
            return {
                tableData: [
                    {
                        user: {
                            id: '',
                            name: '',
                            studentNum: '',
                            password: '',
                            sex: '',
                            institute: '',
                            major: '',
                            dormitory: '',
                            clazz: '',
                            grade: ''
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
                loading: false,
                dialogVisible: false,
                currentDiseaseCase: {
                    user: {
                        id: '',
                        name: '',
                        studentNum: '',
                        password: '',
                        sex: '',
                        institute: '',
                        major: '',
                        dormitory: '',
                        clazz: '',
                        grade: ''
                    },
                    id: '',
                    diseaseLevel: '',
                    diseaseName: '',
                    createTime: new Date(),
                    remark: ''
                },
                diseaseLevelList: Common.diseaseLevel,
                instituteList: Common.institute,
                majorList: Common.major,
                dialogLoading: false,
                currentPage: 1,
                filterForm: {
                    diseaseLevel: '',
                    institute: '',
                    major: '',
                    dormitory: '',
                    clazz: '',
                    grade: ''
                }
            }
        },
        created() {
            this.getDiseaseCase(1);
        },
        methods: {
            page(currentPage) {
                this.currentPage = currentPage;
                this.getDiseaseCase()
            },
            getDiseaseCase() {
                const _this = this;
                let form = new FormData();
                form.append('page_no', this.currentPage);
                form.append('page_size', this.pageSize);

                if (this.filterForm.diseaseLevel !== '') {
                    form.append('disease_level', this.filterForm.diseaseLevel);
                }
                if (this.filterForm.institute !== '') {
                    form.append('institute', this.filterForm.institute);
                    if (this.filterForm.major !== '') {
                        form.append('major', this.filterForm.major);
                    }
                }
                if (this.filterForm.grade !== '') {
                    form.append('grade', this.filterForm.grade);
                    if (this.filterForm.clazz !== '') {
                        form.append('clazz', this.filterForm.clazz);
                    }
                }
                if (this.filterForm.dormitory !== '') {
                    form.append('dormitory', this.filterForm.dormitory);
                }

                this.loading = true;

                axios.post('/case/list/get', form).then(function (response) {
                    if (response.data !== 0) {
                        _this.tableData = response.data.list;
                        _this.pageTotal = response.data.total;
                    } else {
                        _this.$message.error('获取案例失败！')
                    }
                    _this.loading = false;
                }).catch(function (error) {
                    _this.loading = false;
                })
            },
            showDialog(index) {
                this.dialogVisible = true;
                this.currentDiseaseCase = this.tableData[index];
            },
            edit() {
                const _this = this;
                this.dialogLoading = true;
                axios.post('/case/edit/request', this.currentDiseaseCase).then(function (response) {
                    console.log(response)
                    if (response.data !== 0) {
                        _this.$message({message: '修改案例成功！', type: 'success'});
                        _this.dialogLoading = false;
                        _this.dialogVisible = false;
                        _this.getDiseaseCase()
                    } else {
                        _this.$message.error('修改案例失败！');
                    }
                }).catch(function (error) {
                    _this.dialogLoading = false;
                })
            },
            deleteDiseaseCase(id) {
                this.$confirm('此操作将永久删除该案例, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    const _this = this;
                    this.loading = true;
                    axios.get('/case/delete', {params:{id: id}}).then(function (response) {
                        if (response.data !== 0) {
                            _this.$message({message: '删除案例成功！', type: 'success'});
                            _this.loading = false;
                            _this.getDiseaseCase();
                        } else {
                            _this.$message.error('删除失败！');
                            _this.loading = false;
                        }
                    }).catch(function (error) {
                        _this.loading = false;
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            }
        }
    }
</script>

<style scoped>

</style>
