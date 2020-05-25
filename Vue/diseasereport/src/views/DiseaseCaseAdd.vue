<template>
    <el-main>
        <filter-form :is-user-filter-on="false" :is-case-filter-on="false"></filter-form>
        <el-row align="middle">
            <el-col span="12">
                <userinfo-form></userinfo-form>
            </el-col>
            <el-col span="12">
                <caseinfo-form></caseinfo-form>
            </el-col>
        </el-row>
        <el-row>
            <el-col span="4" offset="9">
                <el-button type="primary">录入案例</el-button>
                <el-button>清空</el-button>
            </el-col>
        </el-row>
    </el-main>
</template>

<script>
    import FilterForm from "../components/FilterForm";
    export default {
        components: {FilterForm},
        data() {
            return {
                studentNum: null
            }
        },
        methods: {
            checkStudentNum() {
                if (this.studentNum != null) {
                    axios.get("http://localhost:8001/diseasereport/user/get?id=" + this.studentNum).then(function (response) {
                        if (response.data.size === 0) {
                            alert("学号错误！")
                        } else {
                            console.log(response);
                        }
                    })
                }
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