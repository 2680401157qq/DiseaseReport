<template>
    <div style="width: 30%;margin: 0 auto">
        <el-form ref="form" :model="userForm" label-width="auto">
            <el-form-item label="姓名">
                <el-input v-model="userForm.name" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="学号">
                <el-input v-model="userForm.studentNum" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-input v-model="userForm.sex" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="年级">
                <el-input v-model="userForm.grade" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="学院">
                <el-input v-model="userForm.institute" clearable :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="专业">
                <el-input v-model="userForm.major" clearable :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="班级">
                <el-input v-model="userForm.clazz" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="宿舍">
                <el-input v-model="userForm.dormitory" :disabled="disableChange"></el-input>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        props: {
            disableChange: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return {
                userForm: {
                    studentNum: "",
                    name: "",
                    sex: "",
                    grade: "",
                    clazz: "",
                    institute: "",
                    major: "",
                    dormitory: ""
                }
            }
        },
        mounted: function () {
            const _this = this
            axios.get('http://localhost:8001/diseasereport/user/get?studentNum=' + sessionStorage.getItem("id")).then(function (response) {
                console.log(response.data)
                _this.userForm = response.data;
            });
        }
    }
</script>
<style scoped>

</style>
