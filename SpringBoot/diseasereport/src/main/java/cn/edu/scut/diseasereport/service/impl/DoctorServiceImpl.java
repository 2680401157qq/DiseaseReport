package cn.edu.scut.diseasereport.service.impl;

import cn.edu.scut.diseasereport.dao.DoctorDao;
import cn.edu.scut.diseasereport.entity.Doctor;
import cn.edu.scut.diseasereport.entity.LoginResult;
import cn.edu.scut.diseasereport.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {

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

    public PageInfo<Doctor> getDoctorList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> doctorList = mDoctorDao.getDoctorList();
        return new PageInfo<>(doctorList);
    }

    @Override
    public LoginResult doLogin(Doctor doctor) {
        Doctor doctorById = mDoctorDao.getDoctorById(doctor.getId());
        //用户不存在
        if (doctorById == null) {
            return new LoginResult(false, "用户不存在");
        }
        //用户存在
        //对比密码
        if (!doctor.getPassword().equals(doctorById.getPassword())) {
            return new LoginResult(false, "用户名或密码错误");
        }
        return new LoginResult(true, "登录成功");
    }
}
