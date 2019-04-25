package com.oe.account.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oe.account.dao.UserDao;
import com.oe.account.entity.User;
import com.oe.account.mapper.PermissionMapper;
import com.oe.account.mapper.RoleMapper;
import com.oe.account.mapper.RolePerMapper;
import com.oe.account.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public User getUserByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(wrapper);
        return getRole(user);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, user.getUserName());
        userMapper.update(user, wrapper);
    }

    private User getRole(User user) {
        if (user != null) {
            user.setRole(roleMapper.selectById(user.getRoleId()));
            return user;
        }
        return null;
    }
}
