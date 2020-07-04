package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.PunchTableDao;
import cn.edu.scut.diseasereport.service.PunchTableService;
import cn.edu.scut.diseasereport.utils.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 21:45
 * @description:
 */
@Service
public class PunchTableServiceImpl implements PunchTableService {
    @Autowired
    PunchTableDao mPunchTableDao;

    @Override
    public boolean createPunchTable(String tableName, List<String> columns) {
        int i = mPunchTableDao.createPunchTable(tableName, columns);
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public boolean deletePunchTable(String tableName) {
        int i = mPunchTableDao.deletePunchTable(tableName);
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public boolean insertPunch(String tableName, List<String> data) {
        int i = mPunchTableDao.insertPunch(tableName, data);
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public List<String> getColumnNames(String tableName) {
        List<String> columnNames = mPunchTableDao.getColumnNames(tableName);
        return columnNames;
    }
}
