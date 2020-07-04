package cn.edu.scut.diseasereport.task;/*
 *@author:123
 *@date:2020/7/3
 *@description:diseasereport
 *@time:21:49
 */

import cn.edu.scut.diseasereport.dao.StuDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//对于sumdata表的操作： 每天的12点插入当前当天健康人数，然后每分钟的30秒 33秒 36秒更新light serious health的数据

@Component
public class TaskInsert {
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyyMMdd");
    String theda = dayFormat.format(new Date());


    @Autowired
    StuDao studao;

    @Scheduled(cron = "0 0 12 * * ?")
    public void taskInsert(){

        int iday=studao.taskInsert(theda);

        System.out.println("插入数据时间是 everyday 12.00.00---"+iday);
        System.out.println("现在day是：" + dayFormat.format(new Date()));

    }

}
