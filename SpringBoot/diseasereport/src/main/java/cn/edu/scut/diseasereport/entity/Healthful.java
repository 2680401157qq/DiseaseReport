package cn.edu.scut.diseasereport.entity;/*
 *@author:123
 *@date:2020/5/16
 *@description:diseasereport
 *@time:23:42
 */

/**
 * 每一个学院的实体类
 * 健康人数int
 * 轻症人数int
 * 重症人数int
 * 学院名string
 * 记录数据日期string
 * **/

import lombok.Data;

@Data
public class Healthful {
    private int healthNum;
    private int lightNum;
    private int seriousNum;
    private String institute;
    private String day;
}
