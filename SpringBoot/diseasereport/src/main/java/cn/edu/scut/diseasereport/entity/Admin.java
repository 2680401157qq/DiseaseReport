package cn.edu.scut.diseasereport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: lshuang.SE
 * @date: 2020/5/9 23:53
 * @description:
 */
@Data
@AllArgsConstructor
public class Admin {
    
    private Integer id;
    
    private String name;
    
    private String password;
    
}
