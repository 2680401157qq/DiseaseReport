package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.dao.AdminMapper;
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
    private AdminMapper mAdminMapper;

    public List<Admin> getAdminList() {
        return mAdminMapper.getAdminList();
    }

    public Admin getAdminById(int id) {
        return mAdminMapper.getAdminById(id);
    }
}
