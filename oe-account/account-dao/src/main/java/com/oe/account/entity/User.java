package com.oe.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public class User {
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String userName;

    private String password;

    private Long roleId;

    @TableField(exist = false)
    private Role role;

    @TableField(exist = false)
    private List<Permission> pList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
