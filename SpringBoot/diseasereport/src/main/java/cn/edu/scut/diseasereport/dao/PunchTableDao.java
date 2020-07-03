package cn.edu.scut.diseasereport.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:04
 * @description:
 */
@Mapper
public interface PunchTableDao {
    void createPunchTable(@Param("tableName") String tableName, @Param("columns") List<String> columns);
}
