package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.PunchTableDao;
import cn.edu.scut.diseasereport.service.PunchTableService;
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
    public void createPunchTable(String tableName, List<String> columns) {
        mPunchTableDao.createPunchTable(tableName, columns);
    }
}
