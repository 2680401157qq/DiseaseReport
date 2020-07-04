package cn.edu.scut.diseasereport.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: lshuang.SE
 * @date: 2020/7/4 15:22
 * @description:
 */
@Data
public class PunchHistory {
    private String punchName;
    private int state;
    private Date date;
}
