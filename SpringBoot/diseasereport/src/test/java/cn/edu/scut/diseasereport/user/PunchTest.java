package cn.edu.scut.diseasereport.user;

import cn.edu.scut.diseasereport.service.PunchTableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/7/3 21:57
 * @description:
 */
@SpringBootTest
public class PunchTest {
    @Autowired
    PunchTableService mPunchTableService;

    @Test
    public void createPunchTableTest() {
        List<String> temp = new ArrayList<>();
        temp.add("testOne");
        temp.add("testTwo");
        temp.add("testThree");
        mPunchTableService.createPunchTable("test", temp);
    }
}
