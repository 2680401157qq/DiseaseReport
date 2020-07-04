package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.PunchHistory;
import cn.edu.scut.diseasereport.service.PunchTableListService;
import cn.edu.scut.diseasereport.service.PunchTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public boolean publishPunch(@RequestBody List<String> punchList) {
        temp.clear();
        temp.addAll(1, punchList);
        mPunchTableListService.insertPunchTableName(punchList.get(0), 1);
        return mPunchTableService.createPunchTable(punchList.get(0), temp);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean deletePunch(@RequestParam String tableName) {
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

}
