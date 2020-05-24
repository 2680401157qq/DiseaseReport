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
public class Doctor {
    
    private Integer id;

    private String name;

    private String password;
    
    private String sex;
    
}
