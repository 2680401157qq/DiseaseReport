package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.UserDao;
import cn.edu.scut.diseasereport.entity.LoginResult;
import cn.edu.scut.diseasereport.entity.User;
import cn.edu.scut.diseasereport.service.UserService;
import cn.edu.scut.diseasereport.utils.SqlUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public User getUserById(String studentNum) {
        return mUserDao.getUserById(studentNum);
    }

    public PageInfo<User> getUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = mUserDao.getUserList();
        return new PageInfo<>(userList);
    }

    @Override
    public LoginResult doLogin(User user) {
        User userById = mUserDao.getUserById(user.getStudentNum());
        //用户不存在
        if (userById == null) {
            return new LoginResult(false, "用户不存在");
        }
        //用户存在
        //对比密码
        if (!user.getPassword().equals(userById.getPassword())) {
            return new LoginResult(false, "用户名或密码错误");
        }
        return new LoginResult(true, "登录成功");
    }
}
