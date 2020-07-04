<template>
    <div>
        <el-form :model="dynamicPunchForm" ref="dynamicValidateForm" label-width="auto" v-loading="loading">
            <el-form-item style="border-bottom: 1px solid #DCDFE6; padding-bottom: 15px">
                <el-button type="primary" style="width: 100px" @click="submitForm">提交</el-button>
                <el-button @click="addInput">新增输入框</el-button>
                <el-button type="danger" plain style="width: 80px;" @click="resetForm">重置</el-button>
            </el-form-item>
            <el-form-item v-for="(item, index) in dynamicPunchForm.parameters" :label="item"
                          :key="index" :prop="'parameters[' + index + ']'">
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-input :v-model="item" placeholder="输入字段名称"></el-input>
                    </el-col>
                    <el-col :span="6">
                        <el-button type="danger" @click.prevent="removeDomain(item)">删除</el-button>
                    </el-col>
                </el-row>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "PublishPunch",
        data() {
            return {
                dynamicPunchForm: {
                    parameters: [

                    ]
                },
                loading: false
            }
        },
        methods: {
            submitForm() {
                if (this.dynamicPunchForm.parameters.length !== 0) {
                    const _this = this;
                    this.loading = true;
                    axios.post('/punch/publish', this.dynamicPunchForm.parameters).then(function (response) {
                        console.log(response)
                        _this.$message({message: '创建打卡任务成功！', type: 'success'});
                        _this.loading = false;
                        _this.resetForm()
                    }).catch(function (error) {
                        _this.loading = false;
                    })
                }
            },
            resetForm() {
                this.$confirm('此操作将清空已添加的输入框, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.dynamicPunchForm.parameters = [];
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消重置'
                    });
                });
            },
            removeDomain(item) {
                var index = this.dynamicPunchForm.parameters.indexOf(item)
                if (index !== -1) {
                    this.dynamicPunchForm.parameters.splice(index, 1)
                }
            },
            addInput() {
                this.$prompt('请输入字段名称', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    inputPattern: /\S+/,
                    inputErrorMessage: '请输入字段名称'
                }).then(({ value }) => {
                    this.dynamicPunchForm.parameters.push(value.trim());
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '取消输入'
                    });
                });
            }
        }
    }
</script>

<style scoped>

</style>
