package cn.edu.scut.diseasereport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

/**
 * @author: giahao
 * @date: 2020/5/8 22:22
 * @description:
 */
@Data
@AllArgsConstructor
public class Case {
    private Integer id;

    private Integer idUser;

    private char level;

    private String diseaseName;

    private Date createTime;

    private String remark;
}
