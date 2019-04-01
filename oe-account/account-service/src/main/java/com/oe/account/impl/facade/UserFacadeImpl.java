package com.oe.account.impl.facade;

import com.oe.account.entity.User;
import com.oe.account.enums.ResponseStatus;
import com.oe.account.exception.OeException;
import com.oe.account.facade.UserFacade;
import com.oe.account.impl.service.UserServiceImpl;
import com.oe.account.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserServiceImpl userService;
    @Override
    public void Login(String userName, String password) {

    }

    @Override
    public UserVo getUserByUserName(String userName) throws OeException {
        UserVo userVo = new UserVo();
        User user = userService.getUserByUserName(userName);
        if (user==null){
            throw new OeException(ResponseStatus.FAILED.getCode(),"查不到对应的用户！");
        }
        userVo.setUserName(userName);
        userVo.setpList(user.getpList());
        userVo.setRole(user.getRole());
        return userVo;
    }
}
