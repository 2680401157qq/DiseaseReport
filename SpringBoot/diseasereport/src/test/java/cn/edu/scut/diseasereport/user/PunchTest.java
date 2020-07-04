package cn.edu.scut.diseasereport.user;

import cn.edu.scut.diseasereport.dao.PunchTableDao;
import cn.edu.scut.diseasereport.entity.Punch;
import cn.edu.scut.diseasereport.entity.PunchHistory;
import cn.edu.scut.diseasereport.service.PunchTableListService;
import cn.edu.scut.diseasereport.service.PunchTableService;
import cn.edu.scut.diseasereport.utils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @author: lshuang.SE Lsun
 * @date: 2020/7/3 21:57
 * @description:
 */
@SpringBootTest
public class PunchTest {
    @Autowired
    PunchTableService mPunchTableService;
    @Autowired
    PunchTableListService mPunchTableListService;
    @Autowired
    PunchTableDao mPunchTableDao;

    @Test
    public void createPunchTableTest() {
        List<String> temp = new ArrayList<>();
        temp.add("testOne");
        temp.add("testTwo");
        temp.add("testThree");
        //mPunchTableService.createPunchTable("test", temp);
        //mPunchTableService.createPunchTable("test2", temp);
        //mPunchTableService.createPunchTable("test3", temp);
        //mPunchTableService.createPunchTable("test4", temp);
        mPunchTableService.createPunchTable("test5", temp);
        //mPunchTableService.deletePunchTable("test");
    }

    @Test
    public void insertPunchTableListTest() {
        //mPunchTableListService.insertPunchTableName("test", 1);
        //mPunchTableListService.insertPunchTableName("test2", 1);
        //mPunchTableListService.insertPunchTableName("test3", 1);
        //mPunchTableListService.insertPunchTableName("test4", 1);
        mPunchTableListService.insertPunchTableName("test5", 1);
        List<PunchHistory> punchTableNameList = mPunchTableListService.getPunchTableNameList();
        System.out.println(punchTableNameList);
    }

    @Test
    public void getPunchTableListTest() {
        List<PunchHistory> punchTableNameList = mPunchTableListService.getPunchTableNameList();
        System.out.println(punchTableNameList);
    }

    @Test
    public void insertPunchTest() {
        String activePunch = mPunchTableListService.getActivePunch();
        List<String> data = new ArrayList<>();
        data.add("test1");
        data.add("test2");
        data.add("test3");
        mPunchTableService.insertPunch(activePunch, data);
    }

    @Test
    public void selectPunchesTest() {
        Punch punch = new Punch();
        String sqlStr = "select * from fifthPunch";
        List<Map<String, Object>> maps = mPunchTableDao.selectPunchList(sqlStr);
        Map<String, Object> tempMap = maps.get(0);
        Set<String> keySet = tempMap.keySet();
        try {
            HashMap addMap = new HashMap();
            HashMap addValMap = new HashMap();
            for (String s : keySet) {
                if (s.equals("date")) {
                    System.out.println("date");
                    addMap.put(s, Class.forName("java.util.Date"));
                } else {
                    addMap.put(s, Class.forName("java.lang.String"));
                }
                addValMap.put(s, tempMap.get(s));
            }
            Object o = new BeanUtils().createPunchBean(punch, addMap, addValMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectTest() {
        String sqlStr = "select * from fifthPunch";
        //List<Object> objects = mPunchTableService.selectPunchList(sqlStr);
        //System.out.println(objects);
    }
}
