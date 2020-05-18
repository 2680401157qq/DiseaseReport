package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.entity.User;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/18 15:26
 * @description:
 */
public interface UserService {

    boolean createUser(User user);

    boolean editUser(User user);

    boolean deleteUser(Integer id);

    User getUserById(Integer id);

    List<User> getUserList();
}
