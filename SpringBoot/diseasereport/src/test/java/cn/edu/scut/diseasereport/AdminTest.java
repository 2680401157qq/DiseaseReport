<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<<< Updated upstream:SpringBoot/diseasereport/src/test/java/cn/edu/scut/diseasereport/AdminTest.java
package cn.edu.scut.diseasereport;

import cn.edu.scut.diseasereport.entity.Admin;
import cn.edu.scut.diseasereport.entity.Healthful;
import cn.edu.scut.diseasereport.service.AdminService;
import cn.edu.scut.diseasereport.service.DoctorService;
import cn.edu.scut.diseasereport.service.HealthService;
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
//    @Autowired
//    HealthService healthService;
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

========
//package cn.edu.scut.diseasereport.user;
=======
//package cn.edu.scut.diseasereport;
>>>>>>> Stashed changes
=======
//package cn.edu.scut.diseasereport;
>>>>>>> Stashed changes
=======
//package cn.edu.scut.diseasereport;
>>>>>>> Stashed changes
//
//import cn.edu.scut.diseasereport.entity.Admin;
//import cn.edu.scut.diseasereport.entity.Healthful;
//import cn.edu.scut.diseasereport.service.AdminService;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
//import cn.edu.scut.diseasereport.service.impl.DoctorServiceImpl;
//
//import cn.edu.scut.diseasereport.service.DoctorService;
//import cn.edu.scut.diseasereport.service.HealthService;
//
=======
//import cn.edu.scut.diseasereport.service.DoctorService;
//import cn.edu.scut.diseasereport.service.HealthService;
>>>>>>> Stashed changes
=======
//import cn.edu.scut.diseasereport.service.DoctorService;
//import cn.edu.scut.diseasereport.service.HealthService;
>>>>>>> Stashed changes
=======
//import cn.edu.scut.diseasereport.service.DoctorService;
//import cn.edu.scut.diseasereport.service.HealthService;
>>>>>>> Stashed changes
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import java.util.List;
//
///**
// * @author: lshuang.SE
// * @date: 2020/5/10 17:00
// * @description:
// */
//
//@SpringBootTest
//public class AdminTest {
//
//    @Autowired
//    AdminService mAdminService;
////    @Autowired
////    HealthService healthService;
//    @Autowired
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
//    DoctorServiceImpl mDoctorService;
=======
//    DoctorService mDoctorService;
>>>>>>> Stashed changes
=======
//    DoctorService mDoctorService;
>>>>>>> Stashed changes
=======
//    DoctorService mDoctorService;
>>>>>>> Stashed changes
//    @Test
//    public void getAdminByIdTest() {
//        Admin adminById = mAdminService.getAdminById(1);
//        System.out.println(adminById);
//    }
//
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
>>>>>>>> Stashed changes:SpringBoot/diseasereport/src/test/java/cn/edu/scut/diseasereport/user/AdminTest.java
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
//    @Test
//    public void getAdminList() {
//        List<Admin> adminList = mAdminService.getAdminList();
//        for (Admin admin : adminList) {
//            System.out.println(admin);
//        }
//    }
//
////    @Test
////    public void getHData() {
////        List<Healthful> aList = healthService.getHData();
////        for (Healthful hdata: aList){
////            System.out.println(hdata);
////        }
////    }
//}
