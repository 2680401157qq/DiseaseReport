package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.entity.PunchHistory;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 21:45
 * @description:
 */
public interface PunchTableListService {

    /**
     * 将打卡表的名称存入List表中
     *
     * @param tableName
     */
    int insertPunchTableName(String tableName, int state);

    /**
     * 获取打卡表名称列表
     */
    List<PunchHistory> getPunchTableNameList();

    /**
     * 将这个打卡人物状态设置为stop
     *
     * @param tableName
     */
    boolean stopPunch(String tableName);

    /**
     * 开启打卡任务
     *
     * @param tableName
     */
    boolean activePunch(String tableName);

    /**
     * 删除打卡任务
     *
     * @param tableName
     */
    boolean deletePunch(String tableName);

    String getActivePunch();
}
