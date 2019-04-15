package com.oe.account.impl.service;

import com.alibaba.fastjson.JSONObject;
import com.oe.account.entity.User;
import com.oe.account.enums.ResponseStatus;
import com.oe.account.enums.RoleEnum;
import com.oe.account.exception.OeException;
import com.oe.account.impl.UserDaoImpl;
import com.oe.account.service.UserService;
import com.oe.account.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@PropertySource(value = "classpath:wx/wxconfig.properties")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Value("${appid}")
    private String appId;
    @Value("${AppSecret}")
    private String appSecret;
    @Value("${grant_type}")
    private String grantType;

    private final String url_prefix = "https://api.weixin.qq.com/sns/jscode2session";

    @Override
    public User wxLogin(String code) throws OeException {
        String url = url_prefix + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" + grantType;
        String info = HttpUtils.wxSessionCodeGet(url);
        if (StringUtils.isEmpty(info)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "用户信息解析异常，请重试");
        }
        JSONObject object = JSONObject.parseObject(info);
        String username = (String) object.get("openid");
        User user = userDao.getUserByUsername(username);
        String password;
        if (user == null) {
            password = UUID.randomUUID().toString().replace("-", "");
            User newUser = new User();
            newUser.setRoleId(RoleEnum.STUDENT.getRoleId());
            newUser.setPassword(password);
            newUser.setUserName(username);
            register(newUser);
            user = newUser;
        }
        return user;

    }

    @Override
    public User getUserByUsername(String userName) {
        return userDao.getUserByUsername(userName);
    }


    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
