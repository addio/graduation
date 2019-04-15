package com.oe.account.enums;

/**
 * @author wangwj
 * @data 2019/4/2
 */
public enum RoleEnum {

    /**
     * 管理员
     */
    ADMIN(123456789L, "admin"),
    /**
     * 学生
     */
    STUDENT(1234567890L, "student"),
    /**
     * 老师
     */
    TEACHER(1234567891L, "teacher");

    private Long roleId;

    private String roleName;

    RoleEnum(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }}
