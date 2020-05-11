package cn.edu.scut.diseasereport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:35
 * @description:
 */
@Data
@AllArgsConstructor
public class User {

    private Integer id;

    private String studentId;
    
    private String name;

    private String password;
    
    private String sex;

    private String institute;

    private String major;

    private String dormitory;

    private String clazz;

    private String grade;
}
