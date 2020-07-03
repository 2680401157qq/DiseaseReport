package cn.edu.scut.diseasereport.controller;

import cn.edu.scut.diseasereport.entity.LoginData;
import cn.edu.scut.diseasereport.entity.LoginResult;
import cn.edu.scut.diseasereport.entity.User;
import cn.edu.scut.diseasereport.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lshuang.SE
 * @date: 2020/5/11 13:23
 * @description:
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService mUserService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createUser(@RequestBody User user) {
        return mUserService.createUser(user);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public boolean editUser(@RequestBody User user) {
        return mUserService.editUser(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean deleteUser(@RequestParam String id) {
        return mUserService.deleteUser(Integer.valueOf(id));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User getUserById(@RequestParam String studentNum) {
        return mUserService.getUserById(studentNum);
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    public PageInfo<User> getUserList(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageInfo<User> page = mUserService.getUserList(pageNum, pageSize);
        System.out.println(page);
        return page;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResult login(@RequestBody LoginData user) {
        return mUserService.doLogin(new User(null, user.getId(), null, user.getPassword(), null, null, null, null, null, null));
    }
}
