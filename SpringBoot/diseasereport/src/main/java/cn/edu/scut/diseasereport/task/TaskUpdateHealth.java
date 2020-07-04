package cn.edu.scut.diseasereport.task;/*
 *@author:123
 *@date:2020/7/4
 *@description:diseasereport
 *@time:1:49
 */

import cn.edu.scut.diseasereport.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskUpdateHealth {
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    String theda = dayFormat.format(new Date());

    @Autowired
    StuDao studao;

    @Scheduled(cron = "36 * * * * *")
    public void taskUpdateLight(){
        int aday=studao.taskUpdateHealth(theda);
        System.out.println("每分钟的第33秒更新一次lightNum数据"+aday);
    }
}
