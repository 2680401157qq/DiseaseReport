package cn.edu.scut.diseasereport.task;/*
 *@author:123
 *@date:2020/7/3
 *@description:diseasereport
 *@time:1:04
 */

import cn.edu.scut.diseasereport.entity.Healthful;
import cn.edu.scut.diseasereport.service.HealthService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component

public class task1 {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyyMMdd");
    private HealthService healthService;


    @Scheduled(cron = "31 0 0 * * ?")
    public void reportTime(){

        System.out.println("现在时间：" + dateFormat.format(new Date()));
        System.out.println("现在day是：" + dayFormat.format(new Date()));
    }


}
