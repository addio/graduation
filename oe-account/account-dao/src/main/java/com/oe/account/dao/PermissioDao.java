package com.oe.account.dao;

import com.oe.account.entity.Permission;

import java.util.List;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface PermissioDao {

    List<Permission> selectPermissionByRId(Long rId);
}
