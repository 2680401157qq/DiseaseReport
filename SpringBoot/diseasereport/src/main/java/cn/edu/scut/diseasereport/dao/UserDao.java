package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.Doctor;
import cn.edu.scut.diseasereport.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
    boolean createUser(User user);

    /**
     * 修改User信息
     *
     * @param id
     * @return 成功：true 失败：false
     */
    boolean editUser(Integer id);

    /**
     * 删除用户
     *
     * @param id
     * @return 成功：true 失败：false
     */
    boolean deleteUser(Integer id);

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    Doctor getDoctorById(Integer id);

    /**
     * 获取所有医生用户信息
     *
     * @return
     */
    List<Doctor> getDoctorList();
}
