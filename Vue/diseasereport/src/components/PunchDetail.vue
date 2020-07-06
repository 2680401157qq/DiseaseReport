<template>
    <el-table
            :data="tableData"
            border
            label-width="auto"
            :default-sort="{prop: 'date', order: 'descending'}"
    >
        <el-table-column
                v-for="(item,index) in columns" v-if="item!=='date'"
                :prop="columns[index]"
                :label="item"
                sortable
                width="auto">
        </el-table-column>
    </el-table>
</template>

<script>
    export default {
        name: "PunchDetail",
        data() {
            return {
                tableData: [],
                columns: []
            }
        },
        methods: {},
        created() {
            const _this = this;
            axios.get('http://localhost:8001/diseasereport/punch/punches?tableName=' + this.$route.query.tableName).then(function (response) {
                console.log(response.data)
                _this.columns = response.data.columns;
                _this.tableData = response.data.dataList;

            });
        }
    }

</script>

<style scoped>

</style>
