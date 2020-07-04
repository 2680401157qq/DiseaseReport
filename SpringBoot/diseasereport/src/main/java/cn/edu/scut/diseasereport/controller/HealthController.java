package cn.edu.scut.diseasereport.controller;/*
 *@author:123
 *@date:2020/5/17
 *@description:diseasereport
 *@time:0:35
 */

import cn.edu.scut.diseasereport.entity.Healthful;
import cn.edu.scut.diseasereport.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HealthController {
    @Autowired
    private HealthService healthService;


    @RequestMapping(value="/data",method = RequestMethod.GET)
    public List<Healthful> getHData(@RequestParam String day) {
        return healthService.getHData(day);
    }

    @RequestMapping(value="/getbyinstitute",method = RequestMethod.GET)
    public List<Healthful> getByInstitute(@RequestParam String institute){
        return healthService.getByInstitute(institute);
    }

    @RequestMapping(value = "/getbyday",method = RequestMethod.GET)
    public Healthful getByDay(@RequestParam String day){
        return healthService.getByDay(day);
    }


}
