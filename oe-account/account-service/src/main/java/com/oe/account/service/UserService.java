package com.oe.account.service;

import com.oe.account.entity.User;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface UserService {

    void Login(User user);

    User getUserByUserName(String userName);

    void register(User user);
}
