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

    @Scheduled(cron = "5 * * * * ?")
    public void taskInsertAData(){
        int size=26;
        String[] insList = new String[size];

        insList[0]="机械与汽车工程学院";
        insList[1]="建筑学院";
        insList[2]="土木与交通学院";
        insList[3]="电子与信息学院";
        insList[4]="材料科学与工程学院";
        insList[5]="化学与化工学院";
        insList[6]="轻工科学与工程学院";
        insList[7]="食品科学与工程学院";
        insList[8]="数学学院";
        insList[9]="物理与光电学院";
        insList[10]="经济与贸易学院";
        insList[11]="自动化科学与工程学院";
        insList[12]="计算机科学与工程学院";
        insList[13]="电力学院";
        insList[14]="生物科学与工程学院";
        insList[15]="环境与能源学院";
        insList[16]="软件学院";
        insList[17]="工商管理学院";
        insList[18]="公共管理学院";
        insList[19]="马克思主义学院";
        insList[20]="外国语学院";
        insList[21]="法学院";
        insList[22]="新闻与传播学院";
        insList[23]="艺术学院";
        insList[24]="体育学院";
        insList[25]="设计学院";


        for(int i=0;i<size;i++){
            studao.taskInsertData(insList[i],theda);
            System.out.println("插入"+insList[i]+"数据");
        }
    }



}
