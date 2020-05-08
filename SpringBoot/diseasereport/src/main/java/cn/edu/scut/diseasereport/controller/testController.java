package cn.edu.scut.diseasereport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lshuang.SE
 * @date: 2020/5/8 14:54
 * @description:
 */
@RestController
public class testController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest() {
        return "hello word ";
    }
}
