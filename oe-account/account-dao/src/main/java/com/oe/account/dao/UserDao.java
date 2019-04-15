package com.oe.account.dao;

import com.oe.account.entity.User;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface UserDao {
    void Login(User user);

    User getUserByUsername(String username);

    void register(User user);

    void update(User user);
}
