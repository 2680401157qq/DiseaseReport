<template>
    <el-main>
        <el-form ref="form" :model="userForm" label-width="auto">
            <el-form-item label="姓名">
                <el-input v-model="userForm.name" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="学号">
                <el-input v-model="userForm.id" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form inline="true">
                <el-form-item label="性别">
                    <el-select v-model="userForm.sex" :disabled="disableChange">
                        <el-option label="男" value="男"></el-option>
                        <el-option label="女" value="女"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="年级">
                    <el-input v-model="userForm.grade" :disabled="disableChange"></el-input>
                </el-form-item>
            </el-form>
            <el-form inline="true">
                <el-form-item label="学院">
                    <el-select v-model="userForm.institute" clearable :disabled="disableChange">
                        <el-option v-for="item in institute" :label="item" :value="item"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="专业">
                    <el-select v-model="userForm.major" clearable :disabled="disableChange">
                        <el-option v-for="item in major[institute.indexOf(userForm.institute)]" :label="item" :value="item">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <el-form-item label="班级">
                <el-input v-model="userForm.clazz" :disabled="disableChange"></el-input>
            </el-form-item>
            <el-form-item label="宿舍">
                <el-input v-model="userForm.dormitory" :disabled="disableChange"></el-input>
            </el-form-item>
        </el-form>
    </el-main>
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
                    id: 0, //学号
                    name: "",
                    sex: "",
                    grade: "",
                    clazz: "",
                    institute: "",
                    major: "",
                    dormitory: ""
                },
                institute: this.Common.institute,
                major: this.Common.major,
                diseaseLevel: this.Common.diseaseLevel
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        }
    }
</script>
<style scoped>

</style>