<template>
    <div>
        <el-row type="flex" justify="center" :gutter="20" style="border-bottom: 1px solid #DCDFE6; padding-bottom: 15px">
            <el-col :span="6">
                <el-input v-model="studentNum" placeholder="请输入学生学号"></el-input>
            </el-col>
            <el-col :span="4">
                <el-button type="primary" style="width: 100px" @click="search">查询</el-button>
            </el-col>
        </el-row>
        <el-row type="flex" justify="center" v-loading="loading">
            <el-col :span="10">
                <el-form ref="form" :model="diseaseInfoForm.user" label-width="auto"
                         style="border-right: 1px solid #DCDFE6; padding-right: 40px">
                    <el-form-item label="姓名">
                        <el-input v-model="diseaseInfoForm.user.name" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="学号">
                        <el-input v-model="diseaseInfoForm.user.studentNum" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-input v-model="diseaseInfoForm.user.sex" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="学院">
                        <el-input v-model="diseaseInfoForm.user.institute" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="专业">
                        <el-input v-model="diseaseInfoForm.user.major" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="年级">
                        <el-input v-model="diseaseInfoForm.user.grade" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="班级">
                        <el-input v-model="diseaseInfoForm.user.clazz" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="宿舍">
                        <el-input v-model="diseaseInfoForm.user.dormitory" disabled></el-input>
                    </el-form-item>
                </el-form>
            </el-col>
            <el-col :span="11">
                <el-form ref="form" :model="diseaseInfoForm" label-width="auto" style="margin-left: 15px">
                    <el-form-item label="疾病名称">
                        <el-input v-model="diseaseInfoForm.diseaseName"></el-input>
                    </el-form-item>
                    <el-form-item label="疾病等级">
                        <el-select v-model="diseaseInfoForm.diseaseLevel" clearable>
                            <el-option v-for="item in diseaseLevelList" :label="item" :value="item" :key="item"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="录入时间">
                        <el-date-picker type="date" placeholder="选择日期" v-model="diseaseInfoForm.createTime" style="width: 100%;">
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item label="备注">
                        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容"
                                  v-model="diseaseInfoForm.remark">
                        </el-input>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="4" :offset="8">
                <el-button type="primary" @click="addDiseaseCase">录入案例</el-button>
            </el-col>
        </el-row>
    </div>
</template>

<script>

    import Common from "../components/Common";

    export default {
        data() {
            return {
                studentNum: '',
                diseaseInfoForm: {
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
                loading: false
            }
        },
        methods: {
            search() {
                const _this = this;
                if (this.studentNum) {
                    this.loading = true;
                    axios.get('/user/get', {params:{studentNum: this.studentNum}}).then(function (response) {
                        _this.diseaseInfoForm.user = response.data;
                        _this.loading = false;
                    }).catch(function (error) {
                        _this.loading = false;
                    })
                }
            },
            addDiseaseCase() {
                const _this = this;
                this.loading = true;
                axios.post('/case/add/request', this.diseaseInfoForm).then(function (response) {
                    if (response.data !== 0) {
                        _this.$message({
                            message: '添加案例成功！',
                            type: 'success'
                        });
                    } else {
                        _this.$message.error('添加案例失败！');
                    }
                    _this.loading = false;
                }).catch(function (error) {
                    _this.loading = false;
                })
            }
        }
    }
</script>

<style>
    .el-row {
        margin-bottom: 20px;
    }

    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
</style>
