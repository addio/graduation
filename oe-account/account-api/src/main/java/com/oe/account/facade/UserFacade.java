package com.oe.account.facade;

import com.oe.account.exception.OeException;
import com.oe.account.vo.UserVo;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface UserFacade {

    void Login(String userName,String password);
    UserVo getUserByUserName(String userName) throws OeException;

}
