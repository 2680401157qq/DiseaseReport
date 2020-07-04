package cn.edu.scut.diseasereport.service;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 21:45
 * @description:
 */
public interface PunchTableService {

    /**
     * 创建打卡表
     *
     * @param tableName
     * @param columns
     */
    public boolean createPunchTable(String tableName, List<String> columns);

    /**
     * 停止打卡
     *
     * @param tableName
     */
    public boolean deletePunchTable(String tableName);

    /**
     * 插入数据
     *
     * @param tableName 要插入的表的名字
     * @param data      要插入的数据
     * @return
     */
    public boolean insertPunch(String tableName, List<String> data);

    public List<String> getColumnNames(String tableName);
}
