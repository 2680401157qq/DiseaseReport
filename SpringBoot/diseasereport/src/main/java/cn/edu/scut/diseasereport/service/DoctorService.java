package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.dao.DoctorDao;
import cn.edu.scut.diseasereport.entity.Doctor;
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
    
    private static final int SUCCESS = 1;

    @Autowired
    private DoctorDao mDoctorDao;

    //所有的boolean值，true表示操作成功，false表示操作失败
    public boolean createDoctor(Doctor doctor) {
        int i = mDoctorDao.createDoctor(doctor);
        return isOperationSuccess(i);
    }

    public boolean editDoctorInfo(Doctor doctor) {
        int i = mDoctorDao.editDoctorInfo(doctor);
        return isOperationSuccess(i);
    }

    public boolean deleteDoctor(Integer id) {
        int i = mDoctorDao.deleteDoctor(id);
        return isOperationSuccess(i);
    }

    public Doctor getDoctorById(Integer id) {
        return mDoctorDao.getDoctorById(id);
    }

    public List<Doctor> getDoctorList() {
        return mDoctorDao.getDoctorList();
    }

    /**
     * 判断sql语句是否执行成功
     *
     * @param i
     * @return
     */
    private boolean isOperationSuccess(int i) {
        if (i == SUCCESS) {
            return true;
        } else {
            return false;
        }
    }
}
