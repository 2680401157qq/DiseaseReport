package cn.edu.scut.diseasereport.task;/*
 *@author:123
 *@date:2020/7/4
 *@description:diseasereport
 *@time:20:14
 */

import cn.edu.scut.diseasereport.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class InsertAData {
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    String theda = dayFormat.format(new Date());

    @Autowired
    StuDao studao;

    @Scheduled(cron = "0 0 12 * * ?")
    public void taskInsertAData() {
        studao.taskInsertData(theda);
        System.out.println("插入数据");
    }
}
