<template>
    <el-form style="width: 30%;margin: 0 auto 0;" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
             class="demo-ruleForm">
        <el-form-item label="学号" prop="studentId">
            <el-input v-model="ruleForm.studentNum"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
            <el-select v-model="ruleForm.sex" placeholder="请选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item label="学院" prop="institute">
            <el-select v-model="ruleForm.institute" placeholder="请选择学院">
                <el-option v-for="item in instituteList" :label="item" :value="item" :key="item"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="专业" prop="major">
            <el-input v-model="ruleForm.major"></el-input>
        </el-form-item>
        <el-form-item label="宿舍" prop="dormitory">
            <el-input v-model="ruleForm.dormitory"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="clazz">
            <el-input v-model="ruleForm.clazz"></el-input>
        </el-form-item>
        <el-form-item label="年级" prop="grade">
            <el-input v-model="ruleForm.grade"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">添加用户</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    import Common from "./Common";

    export default {
        data() {
            return {
                instituteList: Common.institute,
                ruleForm: {
                    id: '',
                    studentNum: '',
                    name: '',
                    sex: '',
                    password: '',
                    institute: '',
                    major: '',
                    dormitory: '',
                    clazz: '',
                    grade: ''
                },
                rules: {
                    studentNum: [
                        {required: true, message: '请输入学号', trigger: 'blur'},
                        {min: 12, max: 12, message: '长度为 12 个数字', trigger: 'blur'}
                    ],
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
                    ],
                    sex: [
                        {required: true, message: '请选择性别', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ],
                    institute: [
                        {required: true, message: '请选择学院', trigger: 'blur'}
                    ],
                    major: [
                        {required: true, message: '请输入专业', trigger: 'blur'}
                    ],
                    dormitory: [
                        {required: true, message: '请输入宿舍号', trigger: 'blur'}
                    ],
                    clazz: [
                        {required: true, message: '请输入班级', trigger: 'blur'}
                    ],
                    grade: [
                        {required: true, message: '请选择年级', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        axios.post('http://localhost:8001/diseasereport/user/create', _this.ruleForm).then(function (response) {
                            if (response.data) {
                                _this.$alert('添加成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/usertable');
                                    }
                                })
                            } else {
                                _this.$alert('添加失败', '消息', {
                                    confirmButtonText: '确定',
                                })
                            }
                        });
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>
