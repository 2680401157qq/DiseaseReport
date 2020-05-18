package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.UserDao;
import cn.edu.scut.diseasereport.entity.User;
import cn.edu.scut.diseasereport.service.UserService;
import cn.edu.scut.diseasereport.utils.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:51
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao mUserDao;

    public boolean createUser(User user) {
        int i = mUserDao.createUser(user);
        return SqlUtils.isOperationSuccess(i);
    }

    public boolean editUser(User user) {
        int i = mUserDao.editUser(user);
        return SqlUtils.isOperationSuccess(i);
    }

    public boolean deleteUser(Integer id) {
        int i = mUserDao.deleteUser(id);
        return SqlUtils.isOperationSuccess(i);
    }

    public User getUserById(Integer id) {
        return mUserDao.getUserById(id);
    }

    public List<User> getUserList() {
        return mUserDao.getUserList();
    }
}
