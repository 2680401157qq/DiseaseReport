package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.PunchHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:04
 * @description:
 */
@Mapper
public interface PunchTableListDao {

    int insertPunchTableName(@Param("tableName") String tableName, @Param("state") int state);

    List<PunchHistory> getPunchTableNameList();

    int stopPunch(@Param("tableName") String tableName);

    int activePunch(@Param("tableName") String tableName);

    int deletePunch(@Param("tableName") String tableName);

    String getActivePunch();
}
