package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.Admin;
import cn.edu.scut.diseasereport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:09
 * @description:
 */
@RequestMapping(value = "/admin")
@RestController
public class AdminController {
    @Autowired
    private AdminService mAdminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Admin getAdminById(@RequestParam int id) {
        return mAdminService.getAdminById(id);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Admin> getAdminList() {
        return mAdminService.getAdminList();
    }
}
