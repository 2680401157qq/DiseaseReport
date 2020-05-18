package cn.edu.scut.diseasereport.dao;/*
 *@author:123
 *@date:2020/5/16
 *@description:diseasereport
 *@time:23:53
 */

import cn.edu.scut.diseasereport.entity.Healthful;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuDao {
    List<Healthful> getHData();
    Healthful getByInstitute(String institute);
    Healthful getByDay(String day);
}
