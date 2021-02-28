package top.xuebuyi.domain;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-27 21:08
 */
//与数据库中的users对应
public class UserInfo {
    private String id;          //主键
    private String username;    //用户名
    private String email;       //邮箱(非空,唯一)
    private String password;    //密码(加密)
    private String phoneNum;    //电话
    private Integer status;         //状态(0:关闭, 1:开启)
    private String statusStr;
    private List<Role> roles;   //角色

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status == 0){
            statusStr = "关闭";
        }else if (status == 1){
            statusStr = "开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
