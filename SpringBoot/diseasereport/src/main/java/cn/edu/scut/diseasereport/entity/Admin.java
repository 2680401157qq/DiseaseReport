package cn.edu.scut.diseasereport.entity;

/**
 * @author: lshuang.SE
 * @date: 2020/5/9 23:53
 * @description:
 */
public class Admin {
    private Integer id;
    private String password;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
