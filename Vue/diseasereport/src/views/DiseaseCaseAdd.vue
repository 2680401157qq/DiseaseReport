<template>
    <el-main>
        <el-row :gutter="15" type="flex" justify="center" style="border-bottom: 1px solid #DCDFE6; padding-bottom: 15px">
            <el-col :span="9">
                <el-input placeholder="请输入学生学号" v-model="studentId" clearable></el-input>
            </el-col>
            <el-col :span="3">
                <el-button type="primary" style="width: 100px" @click="search">查询</el-button>
            </el-col>
        </el-row>
<<<<<<< Updated upstream
        <el-row type="flex" justify="center" :gutter="30" v-loading="loading">
            <el-col :span="11" style="border-right: 1px solid #DCDFE6; margin-right: 20px">
                <el-form ref="form" :model="userForm" label-width="auto">
                    <el-form-item label="姓名">
                        <el-input v-model="userForm.name" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="学号">
                        <el-input v-model="userForm.id" disabled></el-input>
                    </el-form-item>
                    <el-form :inline="true">
                        <el-form-item label="性别">
                            <el-select v-model="userForm.sex" disabled>
=======
        <el-row type="flex" justify="center" :gutter="30" v-loading="loading" style="margin-top: 50px">
            <el-col :span="11" style="border-right: 1px solid #DCDFE6; margin-right: 20px">
                <el-form ref="form" :model="diseaseForm.user" label-width="auto" v-loading="loading">
                    <el-form-item label="姓名">
                        <el-input v-model="diseaseForm.user.name" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="学号">
                        <el-input v-model="diseaseForm.user.studentNum" disabled></el-input>
                    </el-form-item>
                    <el-form :inline="true">
                        <el-form-item label="性别">
                            <el-select v-model="diseaseForm.user.sex" disabled>
>>>>>>> Stashed changes
                                <el-option label="男" value="男"></el-option>
                                <el-option label="女" value="女"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="年级">
<<<<<<< Updated upstream
                            <el-input v-model="userForm.grade" disabled></el-input>
=======
                            <el-input v-model="diseaseForm.user.grade" disabled></el-input>
>>>>>>> Stashed changes
                        </el-form-item>
                    </el-form>
                    <el-form :inline="true">
                        <el-form-item label="学院">
<<<<<<< Updated upstream
                            <el-select v-model="userForm.institute" clearable disabled>
                                <el-option v-for="item in instituteList" :label="item" :value="item"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="专业">
                            <el-select v-model="userForm.major" clearable disabled>
                                <el-option v-for="item in majorList[instituteList.indexOf(userForm.institute)]" :label="item" :value="item">
=======
                            <el-select v-model="diseaseForm.user.institute" clearable disabled>
                                <el-option v-for="(item, index) in instituteList" :label="item" :value="item"
                                           :key="index"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="专业">
                            <el-select v-model="diseaseForm.user.major" clearable disabled>
                                <el-option v-for="(item, index) in majorList[instituteList.indexOf(diseaseForm.institute)]"
                                           :label="item" :value="item" :key="index">
>>>>>>> Stashed changes
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-form>
                    <el-form-item label="班级">
<<<<<<< Updated upstream
                        <el-input v-model="userForm.clazz" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="宿舍">
                        <el-input v-model="userForm.dormitory" disabled></el-input>
=======
                        <el-input v-model="diseaseForm.user.clazz" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="宿舍">
                        <el-input v-model="diseaseForm.user.dormitory" disabled></el-input>
>>>>>>> Stashed changes
                    </el-form-item>
                </el-form>
            </el-col>
            <el-col :span="11">
<<<<<<< Updated upstream
                <el-form ref="form" :model="caseForm" label-width="auto">
                    <el-form-item label="疾病名称">
                        <el-input v-model="caseForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="疾病等级">
                        <el-select v-model="caseForm.level" clearable>
                            <el-option v-for="item in diseaseLevelList" :label="item" :value="item"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="录入时间">
                        <el-date-picker type="date" placeholder="选择日期" v-model="caseForm.createTime"
                                        :default-value="caseForm.createTime" style="width: 100%;">
=======
                <el-form ref="form" :model="diseaseForm" label-width="auto">
                    <el-form-item label="疾病名称">
                        <el-input v-model="diseaseForm.diseaseName"></el-input>
                    </el-form-item>
                    <el-form-item label="疾病等级">
                        <el-select v-model="diseaseForm.diseaseLevel" clearable>
                            <el-option v-for="item in diseaseLevelList" :label="item" :value="item" :key="item"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="录入时间">
                        <el-date-picker type="date" placeholder="选择日期" v-model="diseaseForm.createTime"
                                        :default-value="diseaseForm.createTime" style="width: 100%;">
>>>>>>> Stashed changes
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item label="备注">
                        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容"
<<<<<<< Updated upstream
                                  v-model="caseForm.remark">
=======
                                  v-model="diseaseForm.remark">
>>>>>>> Stashed changes
                        </el-input>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
        <div style="text-align: center">
            <el-button type="primary" style="width: 100px" @click="addCase">录入病例</el-button>
        </div>
    </el-main>
</template>

<script>
    import Common from "../components/Common";

    export default {
        data() {
            return {
                studentId: '',
                diseaseForm: {
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
<<<<<<< Updated upstream
                    id: '',
                    diseaseLevel: '',
                    diseaseName: '',
                    createTime: '',
                    remark: ''
                },
                diseaseLevelList: Common.diseaseLevelList,
                instituteList: Common.instituteList,
                majorList: Common.majorList,
=======
                    diseaseLevel: '',
                    diseaseName: '',
                    createTime: new Date(),
                    remark: ''
                },
                diseaseLevelList: Common.diseaseLevel,
                instituteList: Common.institute,
                majorList: Common.major,
>>>>>>> Stashed changes
                loading: false
            }
        },
        methods: {
            addCase(pointer) {
<<<<<<< Updated upstream
                let form = new FormData();
                form.append('id_user', this.userForm.id);
                form.append('level', this.caseForm.level);
                form.append('disease', this.caseForm.name);
                form.append('time', this.caseForm.createTime);
                form.append('explanation', this.caseForm.remark);

                axios.post('/case/add/request', form).then(function (response) {
                    if (response.data !== 0) {
                        console.log(response.data)
                    }
=======
                const _this = this;
                this.loading = true;

                axios.post('/case/add/request', this.diseaseForm).then(function (response) {
                    if (response.data === 0) {
                        _this.$message.error('添加案例失败！');
                    } else {
                        _this.$message({message: '添加案例成功！', type: 'success'});
                    }
                    _this.loading = false;
>>>>>>> Stashed changes
                })
            },
            search() {
                const _this = this;
                if (this.studentId) {
                    this.loading = true;
<<<<<<< Updated upstream

                    axios.get('user/get', {params: {'id': this.studentId}}).then(function (response) {
                        _this.userForm = response.data
=======
                    axios.get('/user/get', {params:{studentNum: this.studentId}}).then(function (response) {
                        _this.diseaseForm.user = response.data
>>>>>>> Stashed changes
                        _this.loading = false;
                    }).catch(function (error) {
                        _this.loading = false;
                    })
                }
            }
        },
        created() {

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
