package cn.edu.scut.diseasereport;

import cn.edu.scut.diseasereport.entity.Admin;
import cn.edu.scut.diseasereport.service.AdminService;
import cn.edu.scut.diseasereport.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 17:00
 * @description:
 */
@SpringBootTest
public class AdminTest {

    @Autowired
    AdminService mAdminService;

    @Autowired
    DoctorService mDoctorService;
    @Test
    public void getAdminByIdTest() {
        Admin adminById = mAdminService.getAdminById(1);
        System.out.println(adminById);
    }

    @Test
    public void getAdminList() {
        List<Admin> adminList = mAdminService.getAdminList();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
    
}
