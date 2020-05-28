package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:50
 * @description:
 */
@Mapper
public interface UserDao {

    /**
     * 创建User
     *
     * @param user
     * @return 成功：true 失败：false
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int createUser(User user);

    /**
     * 修改User信息
     *
     * @param user
     * @return 成功：true 失败：false
     */
    int editUser(User user);

    /**
     * 删除User
     *
     * @param id
     * @return 成功：true 失败：false
     */
    int deleteUser(Integer id);

    /**
     * 根据id获取User信息
     *
     * @param studentNum
     * @return
     */
    User getUserById(String studentNum);

    /**
     * 获取所有User信息
     *
     * @return
     */
    List<User> getUserList();
}
