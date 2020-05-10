package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:04
 * @description:
 */
@Mapper
public interface TestMapper {
    @Select("select id ,password as password from admin")
    List<Admin> getAdminList();
}
