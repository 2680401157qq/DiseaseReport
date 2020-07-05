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

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class HealthService {
    @Autowired
    StuDao stuDao;

    public List<Healthful> getHData(String day) {
        String reg = "(\\d{4})(\\d{2})(\\d{2})";
        day=day.replace(reg, "$1-$2-$3");
        System.out.println(day);
        return stuDao.getHData(day);
    }

    public List<Healthful> getByInstitute(String institute) { return stuDao.getByInstitute(institute);}

    public Healthful getByDay(String day) {

        String reg = "(\\d{4})(\\d{2})(\\d{2})";
        day=day.replace(reg, "$1-$2-$3");
        return stuDao.getByDay(day);
    }
}
