package cn.edu.scut.diseasereport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: lshuang.SE
 * @date: 2020/7/5 00:03
 * @description:
 */
@Data
@AllArgsConstructor
public class SelectResult {
    private List<String> columns;
    private List<Object> dataList;
}
