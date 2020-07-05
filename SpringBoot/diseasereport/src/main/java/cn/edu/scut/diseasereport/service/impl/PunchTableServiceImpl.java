package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.PunchTableDao;
import cn.edu.scut.diseasereport.dao.PunchTableListDao;
import cn.edu.scut.diseasereport.entity.Punch;
import cn.edu.scut.diseasereport.entity.SelectResult;
import cn.edu.scut.diseasereport.service.PunchTableService;
import cn.edu.scut.diseasereport.utils.BeanUtils;
import cn.edu.scut.diseasereport.utils.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 21:45
 * @description:
 */
@Service
public class PunchTableServiceImpl implements PunchTableService {
    @Autowired
    PunchTableDao mPunchTableDao;
    @Autowired
    PunchTableListDao mPunchTableListDao;
    private Object mObject;

    @Override
    public int createPunchTable(String tableName, List<String> columns) {
        int result = mPunchTableDao.createPunchTable(tableName, columns);
//        return SqlUtils.isOperationSuccess(i);
        if (result == 0) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public boolean deletePunchTable(String tableName) {
        int i = mPunchTableDao.deletePunchTable(tableName);
        return i == 0;
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

    @Override
    public SelectResult selectPunchList(String sqlStr) {
        List<Object> punches = new ArrayList<>();
        List<Map<String, Object>> maps = mPunchTableDao.selectPunchList(sqlStr);
        Set<String> strings = maps.get(0).keySet();
        for (Map<String, Object> map : maps) {
            Object bean = createBean(map);
            punches.add(bean);
        }
        return new SelectResult(new ArrayList<>(strings), punches);
    }

    @Override
    public boolean isPunched(String id, String tableName, String date) {
        List<Map<String, Object>> mapList = mPunchTableDao.isPunched(id, tableName, date);
        return mapList.size() != 0;
    }

    public Object createBean(Map<String, Object> tempMap) {
        Punch punch = new Punch();
        Set<String> keySet = tempMap.keySet();
        HashMap addMap = new HashMap();
        HashMap addValMap = new HashMap();
        try {
            for (String s : keySet) {
                if (s.equals("date")) {
                    System.out.println("date");
                    addMap.put(s, Class.forName("java.util.Date"));
                } else {
                    addMap.put(s, Class.forName("java.lang.String"));
                }
                addValMap.put(s, tempMap.get(s));
            }
            mObject = new BeanUtils().createPunchBean(punch, addMap, addValMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mObject;
    }
}
