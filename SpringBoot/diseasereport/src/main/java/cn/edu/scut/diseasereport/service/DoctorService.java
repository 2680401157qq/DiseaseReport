package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.entity.Doctor;
import cn.edu.scut.diseasereport.entity.LoginResult;
import com.github.pagehelper.PageInfo;

/**
 * @author: lshuang.SE
 * @date: 2020/5/18 15:25
 * @description:
 */
public interface DoctorService {

    boolean createDoctor(Doctor doctor);

    boolean editDoctorInfo(Doctor doctor);

    boolean deleteDoctor(Integer id);

    Doctor getDoctorById(Integer id);

    PageInfo<Doctor> getDoctorList(int pageNum, int pageSize);

    LoginResult doLogin(Doctor doctor);
}
