package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.entity.LoginResult;
import cn.edu.scut.diseasereport.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * @author: lshuang.SE
 * @date: 2020/5/18 15:26
 * @description:
 */
public interface UserService {
    
    boolean createUser(User user);

    boolean editUser(User user);

    boolean deleteUser(Integer id);

    User getUserById(String studentNum);

    PageInfo<User> getUserList(int pageNum, int pageSize);

    LoginResult doLogin(User user);
}
