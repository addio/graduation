package com.oe.account.service;

import com.oe.account.entity.User;
import com.oe.account.exception.OeException;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface UserService {

    User wxLogin(String code) throws OeException;

    User getUserByUsername(String username);


    void register(User user);

    void update(User user);
}
