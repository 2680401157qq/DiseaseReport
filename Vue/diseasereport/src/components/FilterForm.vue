<template>
    <el-main>
        <el-form :inline="true" :model="filterInfo" :rules="rules" class="demo-form-inline">
            <el-form-item label="学号">
                <el-input v-model="filterInfo.id" placeholder="请输入学生学号"></el-input>
            </el-form-item>
            <el-form-item label="学院" v-show="isUserFilterOn">
                <el-select v-model="filterInfo.institute" clearable>
                    <el-option v-for="item in institute" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="专业" v-show="isUserFilterOn">
                <el-select v-model="filterInfo.major" clearable>
                    <div v-if="filterInfo.institute === ''">
                        <div v-for="item in major">
                            <el-option v-for="subitem in item" :label="subitem" :value="subitem"></el-option>
                        </div>
                    </div>
                    <div v-else>
                        <el-option v-for="item in major[institute.indexOf(filterInfo.institute)]" :label="item" :value="item"></el-option>
                    </div>
                </el-select>
            </el-form-item>
            <el-form-item label="班级" v-show="isUserFilterOn">
                <el-input placeholder="请输入内容" v-model="filterInfo.clazz" clearable></el-input>
            </el-form-item>
            <el-form-item label="宿舍" prop="dormitory" v-show="isUserFilterOn">
                <el-input placeholder="请输入内容" v-model="filterInfo.dormitory" clearable></el-input>
            </el-form-item>
            <el-form-item label="等级" v-show="isCaseFilterOn">
                <el-select v-model="filterInfo.diseaseLevel" clearable>
                    <el-option v-for="item in diseaseLevel" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submit">查询</el-button>
            </el-form-item>
        </el-form>
    </el-main>
</template>

<script>
    export default {
        name: "FilterForm",
        props: {
            isUserFilterOn: {
                type: Boolean,
                default: true
            },
            isCaseFilterOn: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return {
                institute: this.Common.institute,
                major: this.Common.major,
                diseaseLevel: this.Common.diseaseLevel,
                filterInfo: {
                    id: 0,
                    grade: "",
                    clazz: "",
                    institute: "",
                    major: "",
                    dormitory: "",
                    diseaseLevel: ""
                },
                rules: {
                    dormitory: [
                        { pattern: /^C[1-9][0-9]?-[1-9][0-9]{2}/, message: '输入格式错误，应类似 C1-101', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            submit() {
                let form = new FormData();
                if (this.isUserFilterOn) {
                    form.append('')
                }
            }
        }
    }
</script>

<style scoped>

</style>
