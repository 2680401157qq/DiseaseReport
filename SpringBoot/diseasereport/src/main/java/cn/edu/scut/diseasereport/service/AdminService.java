package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.dao.AdminDao;
import cn.edu.scut.diseasereport.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:07
 * @description:
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao mAdminDao;

    public List<Admin> getAdminList() {
        return mAdminDao.getAdminList();
    }

    public Admin getAdminById(int id) {
        return mAdminDao.getAdminById(id);
    }
}
