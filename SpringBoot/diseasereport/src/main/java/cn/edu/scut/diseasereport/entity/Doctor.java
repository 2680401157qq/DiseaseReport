package cn.edu.scut.diseasereport.entity;

import lombok.Data;

/**
 * @author: lshuang.SE
 * @date: 2020/5/10 16:35
 * @description:
 */
@Data
public class Doctor {
    
    private Integer id;

    private String name;

    private String password;
    
    private String sex;

    public Doctor(int i, String doctor1, String doctor11, String 男) {
    }
}
