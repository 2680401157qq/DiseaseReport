package cn.edu.scut.diseasereport.service;

import cn.edu.scut.diseasereport.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:51
 * @description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mUserMapper;
}
