package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.service.PunchTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    List<String> temp = new ArrayList<>();

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public void publishPunch(@RequestBody List<String> punchList) {
        temp.clear();
        temp.addAll(1, punchList);
        mPunchTableService.createPunchTable(punchList.get(0), temp);
    }
}
