package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.entity.Admin;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/18 15:24
 * @description:
 */
public interface AdminService {
    
    List<Admin> getAdminList();

    Admin getAdminById(int id);
}
