package cn.edu.scut.diseasereport.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:04
 * @description:
 */
@Mapper
public interface PunchTableDao {
    int createPunchTable(@Param("tableName") String tableName, @Param("columns") List<String> columns);

    int deletePunchTable(@Param("tableName") String tableName);

    int insertPunch(@Param("tableName") String tableName, @Param("data") List<String> data);

    List<String> getColumnNames(@Param("tableName") String tableName);

    List<Map<String, Object>> selectPunchList(@Param(value = "sqlStr") String sqlStr);

    List<Map<String, Object>> isPunched(@Param("id") String id, @Param("tableName") String tableName, @Param("date") String date);
}
