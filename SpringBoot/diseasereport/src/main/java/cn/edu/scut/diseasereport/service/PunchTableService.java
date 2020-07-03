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
    public void createPunchTable(String tableName, List<String> columns);
}
