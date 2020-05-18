package cn.edu.scut.diseasereport.service;/*
 *@author:123
 *@date:2020/5/16
 *@description:diseasereport
 *@time:23:56
 */

import cn.edu.scut.diseasereport.dao.StuDao;
import cn.edu.scut.diseasereport.entity.Healthful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {
    @Autowired
    private StuDao stuDao;

    public List<Healthful> getHData() {
        return stuDao.getHData();
    }

    public Healthful getByInstitute(String institute) { return stuDao.getByInstitute(institute);}

    public Healthful getByDay(String day) {return stuDao.getByDay(day);}
}
