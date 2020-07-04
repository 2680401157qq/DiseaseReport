package cn.edu.scut.diseasereport.task;/*
 *@author:123
 *@date:2020/7/4
 *@description:diseasereport
 *@time:0:57
 */

import cn.edu.scut.diseasereport.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskUpdateSerious {
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    String theda = dayFormat.format(new Date());

    @Autowired
    StuDao studao;

    @Scheduled(cron = "33 * * * * ?")
    public void taskUpdateSerious(){
        int aday=studao.taskUpdateSerious(theda);
        System.out.println("每分钟的第30秒更新一次seriousDay数据"+aday);
    }
}
