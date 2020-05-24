package cn.edu.scut.diseasereport.utils;

/**
 * @author: lshuang.SE
 * @date: 2020/5/11 12:41
 * @description:
 */
public class SqlUtils {
    private static final int SUCCESS = 1;

    /**
     * 判断SQL语句是否执行成功
     * 
     * @param i
     * @return
     */
    public static boolean isOperationSuccess(int i) {
        if (i == SUCCESS) {
            return true;
        } else {
            return false;
        }
    }
}
