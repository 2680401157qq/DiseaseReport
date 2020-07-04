<template>
    <div>
<!--        <h1 style="text-align: center">疾病直报系统</h1>-->
<!--        <div style="width: 25%;margin: 100px auto 0;">-->
<!--            <el-form :model="ruleForm" :rules="rules" ref="ruleForm"-->
<!--                     label-width="60px"-->
<!--                     class="demo-ruleForm">-->
<!--                <el-form-item label="账号" prop="id">-->
<!--                    <el-input v-model="ruleForm.id"></el-input>-->
<!--                </el-form-item>-->
<!--                <el-form-item label="密码" prop="password">-->
<!--                    <el-input placeholder="请输入密码" v-model="ruleForm.password" show-password></el-input>-->
<!--                </el-form-item>-->
<!--            </el-form>-->
<!--            <div style="text-align: center">-->
<!--                <el-radio-group style="margin-left: 30px" v-model="radio">-->
<!--                    <el-radio :label="0">学生</el-radio>-->
<!--                    <el-radio :label="1">医生</el-radio>-->
<!--                    <el-radio :label="2">管理员</el-radio>-->
<!--                </el-radio-group>-->
<!--            </div>-->
<!--        </div>-->
<!--        <el-button style="margin: 50px auto 0 730px;" @click="submitForm('ruleForm')">登陆</el-button>-->
        <el-form label-width="60px" class="login-box" :model="ruleForm" :rules="rules" ref="ruleForm">
            <h3 class="login-title">疾病直报系统</h3>
            <el-form-item label="账号" prop="id">
                <el-input v-model="ruleForm.id"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input placeholder="请输入密码" v-model="ruleForm.password" show-password></el-input>
            </el-form-item>
            <el-form-item>
                <el-radio-group v-model="radio">
                    <el-radio :label="0">学生</el-radio>
                    <el-radio :label="1">医生</el-radio>
                    <el-radio :label="2">管理员</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="width: 90px; margin-left: 40px"
                           @click="submitForm('ruleForm')">登陆</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                radio: 0,
                ruleForm: {
                    id: '',
                    password: '',
                },
                rules: {
                    id: [
                        {required: true, message: '请输入账号', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        let url = '';
                        switch (_this.radio) {
                            case 0:
                                url = '/user/login';
                                sessionStorage.setItem("permission", 0);
                                break;
                            case 1:
                                url = '/doctor/login';
                                sessionStorage.setItem("permission", 1);
                                break;
                            case 2:
                                url = '/admin/login';
                                sessionStorage.setItem("permission", 2);
                                break;
                        }
                        axios.post(url, _this.ruleForm).then(function (response) {
                            if (response.data.success) {
                                _this.$alert(response.data.message, '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        sessionStorage.setItem('token', "true");
                                        sessionStorage.setItem('id', _this.ruleForm.id);
                                        _this.$router.push({path: '/'});
                                        console.log(response.data);
                                    }
                                });
                            } else {
                                _this.$alert(response.data.message, '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {

                                    }
                                });
                            }
                        });
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .login-title {
        text-align: center;
        margin: 0 auto 30px auto;
        color: black;
    }
    .login-box {
        border: 1px solid #DCDFE6;
        width: 300px;
        margin: 180px auto;
        /*margin-top: 80px;*/
        padding: 25px 25px 10px 25px;
        border-radius: 5px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        box-shadow: 0 0 25px #909399;
    }
</style>
