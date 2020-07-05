<template>
    <div style="width: 30%;margin: 0 auto">
        <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="auto" class="demo-dynamic">
            <el-form-item
                    v-for="(domain, index) in dynamicValidateForm.domains"
                    :label="domain.name"
                    :key="domain.index"
                    :prop="'domains.' + index + '.value'"
                    :rules="{
                    required: true, message: '不能为空', trigger: 'blur'
                }"
            >
                <el-input v-model="domain.value"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('dynamicValidateForm')">提交</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                dynamicValidateForm: {
                    domains: []
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        let dataList = [];
                        for (let i = 0; i < this.dynamicValidateForm.domains.length; i++) {
                            let domain = this.dynamicValidateForm.domains[i];
                            dataList[i] = domain.value;
                        }
                        dataList.push(sessionStorage.getItem('id'));
                        console.log(dataList);
                        axios.post('http://localhost:8001/diseasereport/punch/insert', dataList).then(function (response) {
                            if (response.data) {
                                _this.$alert("打卡成功", '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {

                                    }
                                });
                            } else {
                                _this.$alert("打卡失败，请重试", '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {

                                    }
                                });
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8001/diseasereport/punch/isPunched?id=' + sessionStorage.getItem('id')).then(function (response) {
                console.log(response);
                if (response.data) {
                    _this.$alert("您当天已完成打卡", '消息', {
                        confirmButtonText: '确定',
                        callback: action => {

                        }
                    });
                }
            })
            axios.get('http://localhost:8001/diseasereport/punch/items').then(function (response) {
                console.log(response);
                for (let i = 0; i < response.data.length; i++) {
                    let data = response.data;
                    if (data[i] !== ('date') && data[i] !== ('id') && data[i] !== ('id_user')) {
                        _this.dynamicValidateForm.domains.push({
                            name: data[i],
                            value: '',
                        });
                    }
                }
            })
        }
    }
</script>

<style scoped>

</style>
