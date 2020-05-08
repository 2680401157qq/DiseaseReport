package cn.edu.scut.diseasereport.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: giahao
 * @date: 2020/5/8 22:40
 * @description:
 */
@SpringBootTest
class CaseRepositoryTest {
    @Autowired
    CaseRepository caseRepository;

    @Test
    void caseTest() {
        System.out.println(caseRepository.findAll());
    }
}