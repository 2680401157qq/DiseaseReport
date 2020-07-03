package cn.edu.scut.diseasereport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: lshuang.SE
 * @date: 2020/7/2 20:08
 * @description:
 */
@Data
@AllArgsConstructor
public class LoginResult {
    private boolean success;
    private String message;
}
