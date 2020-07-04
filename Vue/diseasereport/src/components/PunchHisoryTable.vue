<template>
    <el-main>
        <el-button @click="addUser()" type="primary" plain icon="el-icon-circle-plus-outline">新增</el-button>
        <el-table
                :data="tableData"
                border
                style="width: 100%;margin-top: 15px">
            <el-table-column
                    prop="id"
                    label="名称"
                    width="140">
            </el-table-column>
            <el-table-column
                    prop="state"
                    label="状态"
                    width="140">
            </el-table-column>
            <el-table-column
                    prop="date"
                    label="发布时间"
                    width="100">
            </el-table-column>
        </el-table>
    </el-main>
</template>

<script>
    export default {
        name: "PunchHistory",
        data() {
            return {
                tableData:[]
            };
        }
    }
</script>

<style scoped>

</style>
