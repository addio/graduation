package com.oe.account.facade;

import com.oe.account.exception.OeException;
import com.oe.account.vo.UserVo;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public interface UserFacade {

    /**
     * 微信登录
     *
     * @param code
     */
    UserVo wxLogin(String code) throws OeException;

    UserVo getUserByUsername(String oeSession) throws OeException;

    void register(UserVo userVo) throws OeException;

}
