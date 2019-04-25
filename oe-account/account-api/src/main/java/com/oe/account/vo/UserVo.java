package com.oe.account.vo;


import com.oe.account.entity.Permission;
import com.oe.account.entity.Role;

import java.util.List;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public class UserVo implements Vo {


    private String username;

    private String password;

    private Role role;

    private List<Permission> pList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Permission> getpList() {
        return pList;
    }

    public void setpList(List<Permission> pList) {
        this.pList = pList;
    }
}
