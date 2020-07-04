package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.PunchTableListDao;
import cn.edu.scut.diseasereport.entity.PunchHistory;
import cn.edu.scut.diseasereport.service.PunchTableListService;
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
public class PunchTableListServiceImpl implements PunchTableListService {
    @Autowired
    PunchTableListDao mPunchTableListDao;

    @Override
    public boolean insertPunchTableName(String tableName, int state) {
        int i = mPunchTableListDao.insertPunchTableName(tableName, state);
        List<PunchHistory> punchTableNameList = mPunchTableListDao.getPunchTableNameList();
        for (PunchHistory punchHistory : punchTableNameList) {
            if (!punchHistory.getPunchName().equals(tableName)) {
                mPunchTableListDao.stopPunch(punchHistory.getPunchName());
            }
        }
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public List<PunchHistory> getPunchTableNameList() {
        List<PunchHistory> punchTableNameList = mPunchTableListDao.getPunchTableNameList();
        return punchTableNameList;
    }

    @Override
    public boolean stopPunch(String tableName) {
        int i = mPunchTableListDao.stopPunch(tableName);
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public boolean activePunch(String tableName) {
        int i = mPunchTableListDao.activePunch(tableName);
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public boolean deletePunch(String tableName) {
        int i = mPunchTableListDao.deletePunch(tableName);
        return SqlUtils.isOperationSuccess(i);
    }

    @Override
    public String getActivePunch() {
        return mPunchTableListDao.getActivePunch();
    }
}
