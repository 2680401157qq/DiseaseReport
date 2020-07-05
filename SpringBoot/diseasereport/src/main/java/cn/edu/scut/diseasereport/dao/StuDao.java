package cn.edu.scut.diseasereport.dao;/*
 *@author:123
 *@date:2020/5/16
 *@description:diseasereport
 *@time:23:53
 */

import cn.edu.scut.diseasereport.entity.Healthful;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper

@Repository
public interface StuDao {
    List<Healthful> getHData(String day);//查询各个学院的情况，需要加个日期上去，就查询默认当前这个日期
    List<Healthful> getByInstitute(String institute);
    Healthful getByDay(String day);

    //插入学校的数据
    @Insert("insert into sumdata (healthNum,day) select count(*),time from disease_case where level=\"health\" and time=#{day}")
    int taskInsert(String day);

    //更新学校的轻微的数据
    @Update("update sumdata set lightNum=(select count(*) from disease_case where level='light') where day=#{day}")
    int taskUpdateLight(String day);

    //更新学校的严重的数据
    @Update("update sumdata set seriousNum=(select count(*) from disease_case where level='serious') where day=#{day}")
    int taskUpdateSerious(String day);

    //更新全学校的健康数据
    @Update("update sumdata set healthNum=(select count(*) from disease_case where level='serious') where day=#{day}")
    int taskUpdateHealth(String day);

    //插入学院数据
    @Insert("insert into adata (healthNum,day,institute) (select count(*), createtime, institute from acase where level =\"health\" and createtime=#{day})")
    int taskInsertData(String institute, String day);

    //更新学院的health数据
    @Update("update adata set healthNum=(select count(*) from acase where level ='health') where day=#{day} and institute=#{institute}")
    int taskUpdateHealthACase(String institute,String day);

    //更新学院的light数据
    @Update("update adata set lightNum=(select count(*) from acase where level ='light') where day=#{day} and institute=#{institute}")
    int taskUpdateLightACase(String institute,String day);

    //更新学院的serious数据
    @Update("update adata set seriousNum=(select count(*) from acase where level ='serious') where day=#{day} and institute=#{institute}")
    int taskUpdateSeriousACase(String institute,String day);
}
