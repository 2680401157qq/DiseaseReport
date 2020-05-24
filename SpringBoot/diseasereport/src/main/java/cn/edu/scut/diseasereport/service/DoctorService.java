package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.entity.Doctor;

import java.util.List;

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

    List<Doctor> getDoctorList(int pageNum,int pageSize);
}
