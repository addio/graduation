package com.oe.account.dao;

import com.oe.account.entity.Role;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface RoleDao {

    Role selectRoleByRid(Long rId);
}
