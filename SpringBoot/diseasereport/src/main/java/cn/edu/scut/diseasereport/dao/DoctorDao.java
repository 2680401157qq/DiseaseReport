package cn.edu.scut.diseasereport.dao;

import cn.edu.scut.diseasereport.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:50
 * @description:
 */
@Mapper
public interface DoctorDao {

    /**
     * 创建Doctor用户
     *
     * @param doctor
     * @return 成功：true 失败：false
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int createDoctor(Doctor doctor);

    /**
     * 修改Doctor的信息
     *
     * @param doctor
     * @return 成功：true 失败：false
     */
    int editDoctorInfo(Doctor doctor);

    /**
     * 根据id删除Doctor用户
     *
     * @param id
     * @return 成功：true 失败：false
     */
    int deleteDoctor(Integer id);
    
    /**
     * 根据id获得Doctor用户信息
     *
     * @param id
     * @return
     */
    Doctor getDoctorById(Integer id);
    
    /**
     * 获取所有Doctor信息
     *
     * @return
     */
    List<Doctor> getDoctorList();

}
