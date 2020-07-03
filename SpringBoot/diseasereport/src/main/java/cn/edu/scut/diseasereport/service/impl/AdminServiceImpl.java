package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.AdminDao;
import cn.edu.scut.diseasereport.entity.Admin;
import cn.edu.scut.diseasereport.entity.LoginResult;
import cn.edu.scut.diseasereport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:07
 * @description:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao mAdminDao;

    public List<Admin> getAdminList() {
        return mAdminDao.getAdminList();
    }

    public Admin getAdminById(int id) {
        return mAdminDao.getAdminById(id);
    }

    @Override
    public LoginResult doLogin(Admin admin) {
        Admin adminById = mAdminDao.getAdminById(admin.getId());
        //用户不存在
        if (adminById == null) {
            return new LoginResult(false, "用户不存在");
        }
        //用户存在
        //对比密码
        if (!admin.getPassword().equals(adminById.getPassword())) {
            return new LoginResult(false, "用户名或密码错误");
        }
        return new LoginResult(true, "登录成功");
    }
}
