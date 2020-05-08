package cn.edu.scut.diseasereport.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author: giahao
 * @date: 2020/5/8 22:22
 * @description:
 */
@Data
@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Integer idUser;

    private char level;

    private String diseaseName;

    private Date createTime;

    private String remark;
}
