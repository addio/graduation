package com.oe.account.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oe.account.dao.UserDao;
import com.oe.account.entity.Permission;
import com.oe.account.entity.RolePermission;
import com.oe.account.entity.User;
import com.oe.account.mapper.PermissionMapper;
import com.oe.account.mapper.RoleMapper;
import com.oe.account.mapper.RolePerMapper;
import com.oe.account.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePerMapper rolePerMapper;

    @Override
    public void Login(User user) {

    }

    @Override
    public User getUserByUserName(String userName) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, userName);
        User user = userMapper.selectOne(wrapper);
        if (user != null) {
            user.setRole(roleMapper.selectById(user.getRoleId()));
            LambdaQueryWrapper<RolePermission> pWrapper = new LambdaQueryWrapper<>();
            pWrapper.eq(RolePermission::getRole_id, user.getRoleId());
            List<RolePermission> list = rolePerMapper.selectList(pWrapper);
            List<Permission> permissions = permissionMapper.selectBatchIds(list.stream().map(RolePermission::getPermissionId).collect(Collectors.toList()));
            user.setpList(permissions);
            return user;
        }
        return null;
    }

    @Override
    public void register(User user) {

    }
}
