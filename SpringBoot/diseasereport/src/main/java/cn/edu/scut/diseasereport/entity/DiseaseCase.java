package cn.edu.scut.diseasereport.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author: giahao
 * @date: 2020/5/8 22:22
 * @description:
 */
@Data
public class DiseaseCase {
    private Integer id;

    private User user;

    private String diseaseLevel;

    private String diseaseName;

    private Date createTime;

    private String remark;
}
