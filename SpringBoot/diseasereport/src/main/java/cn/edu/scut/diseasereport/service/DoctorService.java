package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.dao.DoctorDao;
import cn.edu.scut.diseasereport.entity.Doctor;
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
public class DoctorService {

    @Autowired
    private DoctorDao mDoctorDao;

    //所有的boolean值，true表示操作成功，false表示操作失败
    public boolean createDoctor(Doctor doctor) {
        int i = mDoctorDao.createDoctor(doctor);
        return SqlUtils.isOperationSuccess(i);
    }

    public boolean editDoctorInfo(Doctor doctor) {
        int i = mDoctorDao.editDoctorInfo(doctor);
        return SqlUtils.isOperationSuccess(i);
    }

    public boolean deleteDoctor(Integer id) {
        int i = mDoctorDao.deleteDoctor(id);
        return SqlUtils.isOperationSuccess(i);
    }

    public Doctor getDoctorById(Integer id) {
        return mDoctorDao.getDoctorById(id);
    }

    public List<Doctor> getDoctorList() {
        return mDoctorDao.getDoctorList();
    }
    
}
