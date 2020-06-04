<template>
    <el-main>
        <el-form ref="form" :model="caseForm" label-width="auto">
            <el-form-item label="疾病名称">
                <el-input v-model="caseForm.name"></el-input>
            </el-form-item>
            <el-form-item label="疾病等级">
                <el-select v-model="caseForm.level" clearable>
                    <el-option v-for="item in diseaseLevel" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="录入时间">
                <el-date-picker type="date" placeholder="选择日期" v-model="caseForm.createTime" style="width: 100%;">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="备注">
                <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容"
                        v-model="caseForm.remark">
                </el-input>
            </el-form-item>
        </el-form>
    </el-main>
</template>

<script>
    export default {
        name: "CaseInfoForm",
        data() {
            return {
                caseForm: {
                    name: "",
                    level: "",
                    createTime: "",
                    remark: ""
                },
                diseaseLevel: this.Common.diseaseLevel
            }
        }
    }
</script>

<style scoped>

</style>