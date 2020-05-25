package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.Doctor;
import cn.edu.scut.diseasereport.service.DoctorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createDoctor(@RequestBody Doctor doctor) {
        return mDoctorService.createDoctor(doctor);
    }

    @RequestMapping(value = "/edit/user", method = RequestMethod.POST)
    public boolean editDoctorInfo(@RequestBody Doctor doctor) {
        return mDoctorService.editDoctorInfo(doctor);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean deleteDoctor(@RequestParam String id) {
        return mDoctorService.deleteDoctor(Integer.valueOf(id));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Doctor getDoctorById(@RequestParam int id) {
        return mDoctorService.getDoctorById(id);
    }
    
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    public PageInfo<Doctor> getDoctorList(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageInfo<Doctor> page = mDoctorService.getDoctorList(pageNum, pageSize);
        return page;
    }
}
