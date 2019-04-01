package com.oe.account.impl.service;

import com.oe.account.entity.User;
import com.oe.account.impl.UserDaoImpl;
import com.oe.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;
    @Override
    public void Login(User user) {

    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public void register(User user) {

    }
}
