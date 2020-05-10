package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:04
 * @description:
 */
@Mapper
public interface AdminMapper {
    
    /**
     * 获得所有管理员信息
     *
     * @return
     */
    List<Admin> getAdminList();

    /**
     * 根据id获得admin信息
     *
     * @param id
     * @return
     */
    Admin getAdminById(Integer id);
}
