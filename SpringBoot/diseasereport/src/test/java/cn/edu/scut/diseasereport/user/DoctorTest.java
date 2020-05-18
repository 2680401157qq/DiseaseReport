package cn.edu.scut.diseasereport.user;

import cn.edu.scut.diseasereport.entity.Doctor;
import cn.edu.scut.diseasereport.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 22:52
 * @description:
 */
@SpringBootTest
public class DoctorTest {
    @Autowired
    DoctorService mDoctorService;

    @Test
    public void createDoctorTest() {
        Doctor doctor = new Doctor(2, "张三", "doctorPassWord", "男");
        mDoctorService.createDoctor(doctor);
    }

    @Test
    public void editDoctorInfo() {
        Doctor doctor = new Doctor(1, "李四", "doctorEdit", "女");
        mDoctorService.editDoctorInfo(doctor);
    }

    @Test
    public void deleteDoctor() {
        mDoctorService.deleteDoctor(2);
    }

    @Test
    public void getDoctorById() {
        Doctor doctorById = mDoctorService.getDoctorById(1);
        System.out.println(doctorById);
    }

    @Test
    public void getDoctorList() {
        List<Doctor> doctorList = mDoctorService.getDoctorList();
        System.out.println(doctorList);
    }
}
