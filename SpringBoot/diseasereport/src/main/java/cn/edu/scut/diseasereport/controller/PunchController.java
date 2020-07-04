package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.PunchHistory;
import cn.edu.scut.diseasereport.entity.SelectResult;
import cn.edu.scut.diseasereport.service.PunchTableListService;
import cn.edu.scut.diseasereport.service.PunchTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 18:00
 * @description:
 */
@RequestMapping(value = "/punch")
@RestController
public class PunchController {
    @Autowired
    PunchTableService mPunchTableService;
    @Autowired
    PunchTableListService mPunchTableListService;
    List<String> temp = new ArrayList<>();

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public int publishPunch(@RequestBody String[] punchList) {
        temp = Arrays.asList(punchList);;
        // 使用当前时间作为表名
        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置日期格式
        String tableName = df.format(date);

        try {
            mPunchTableListService.insertPunchTableName(tableName, 1);
            return mPunchTableService.createPunchTable(tableName, temp);
        } catch (Exception e) {
            return 0;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean deletePunch(@RequestParam String tableName) {
        mPunchTableListService.deletePunch(tableName);
        return mPunchTableService.deletePunchTable(tableName);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public boolean stopPunch(@RequestParam String tableName) {
        return mPunchTableListService.stopPunch(tableName);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PunchHistory> getAllPunchList() {
        List<PunchHistory> punchTableNameList = mPunchTableListService.getPunchTableNameList();
        return punchTableNameList;
    }

    @RequestMapping(value = "/insert")
    public boolean insertPunch(@RequestBody List<String> data) {
        String activePunch = mPunchTableListService.getActivePunch();
        return mPunchTableService.insertPunch(activePunch, data);
    }

    @RequestMapping(value = "/items")
    public List<String> getPunchColumns() {
        String activePunch = mPunchTableListService.getActivePunch();
        List<String> columnNames = mPunchTableService.getColumnNames(activePunch);
        return columnNames;
    }

    @RequestMapping(value = "/punches", method = RequestMethod.GET)
    public SelectResult getPunches(@RequestParam String tableName) {
        String strSql = "select * from " + tableName;
        return mPunchTableService.selectPunchList(strSql);
    }
}
