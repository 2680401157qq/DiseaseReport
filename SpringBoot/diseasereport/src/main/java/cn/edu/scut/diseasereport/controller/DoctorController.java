package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.Doctor;
import cn.edu.scut.diseasereport.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 21:32
 * @description:
 */
@RequestMapping(value = "/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService mDoctorService;

    @RequestMapping(value = "/create/request", method = RequestMethod.POST)
    public boolean createDoctor(@RequestBody Doctor doctor) {
        return mDoctorService.createDoctor(doctor);
    }

    @RequestMapping(value = "/edit/user/request", method = RequestMethod.POST)
    public boolean editDoctorInfo(@RequestBody Doctor doctor) {
        return mDoctorService.editDoctorInfo(doctor);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Doctor getDoctorById(@RequestParam int id) {
        return mDoctorService.getDoctorById(id);
    }
    
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    public List<Doctor> getDoctorList() {
        return mDoctorService.getDoctorList();
    }
}
