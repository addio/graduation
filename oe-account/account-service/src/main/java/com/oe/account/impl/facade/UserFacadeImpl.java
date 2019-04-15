package com.oe.account.impl.facade;

import com.oe.account.entity.User;
import com.oe.account.enums.ResponseStatus;
import com.oe.account.exception.OeException;
import com.oe.account.facade.UserFacade;
import com.oe.account.impl.service.UserServiceImpl;
import com.oe.account.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserServiceImpl userService;
    @Override
    public UserVo wxLogin(String code) throws OeException {

        if (StringUtils.isEmpty(code)){
            throw new OeException(ResponseStatus.FAILED.getCode(),"code为空");
        }
        User user = userService.wxLogin(code);
        UserVo userVo = new UserVo();
        userVo.setUsername(user.getUserName());
        userVo.setPassword(user.getPassword());
        userVo.setRole(user.getRole());
        return userVo;
    }

    @Override
    public UserVo getUserByUsername(String username) throws OeException {
        UserVo userVo = new UserVo();
        User user = userService.getUserByUsername(username);
        if (user==null){
            throw new OeException(ResponseStatus.FAILED.getCode(),"查不到对应的用户！");
        }
        userVo.setUsername(username);
        userVo.setPassword(user.getPassword());
        userVo.setpList(user.getpList());
        userVo.setRole(user.getRole());
        return userVo;
    }

    @Override
    public void register(UserVo userVo) throws OeException {
        if (StringUtils.isEmpty(userVo.getUsername())||StringUtils.isEmpty(userVo.getPassword())){
            throw new OeException(ResponseStatus.FAILED.getCode(),"用户名或密码不能为空");
        }
        User user = userService.getUserByUsername(userVo.getUsername());
        if (user!=null){
            throw new OeException(ResponseStatus.FAILED.getCode(),"当前用户名已经被使用，换一个试试");
        }
        User newUser = new User();
        newUser.setPassword(userVo.getPassword());
        newUser.setUserName(userVo.getUsername());
        newUser.setRoleId(userVo.getRole().getId());
        userService.register(newUser);
    }
}
