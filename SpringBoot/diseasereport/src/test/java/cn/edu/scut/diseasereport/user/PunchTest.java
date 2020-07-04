package cn.edu.scut.diseasereport.user;

import cn.edu.scut.diseasereport.service.PunchTableListService;
import cn.edu.scut.diseasereport.service.PunchTableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
        List<String> punchTableNameList = mPunchTableListService.getPunchTableNameList();
        System.out.println(punchTableNameList);
    }

    @Test
    public void getPunchTableListTest() {
        List<String> punchTableNameList = mPunchTableListService.getPunchTableNameList();
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
}
