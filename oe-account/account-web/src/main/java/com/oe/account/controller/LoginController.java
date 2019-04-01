package com.oe.account.controller;

import com.alibaba.fastjson.JSONObject;
import com.oe.account.entity.User;
import com.oe.account.impl.service.UserServiceImpl;
import com.oe.account.util.OeResponseBuilder;
import com.oe.account.vo.OeResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public OeResponse login(String userName,String password){
        OeResponse response;
        User user;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            subject.login(token);
            user = userService.getUserByUserName(userName);
            response = OeResponseBuilder.buildSuccess();
            response.setBody((JSONObject) JSONObject.toJSON(user));
        }catch (Exception e){
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }

    @GetMapping("/admin")
    public OeResponse test(){
        return OeResponseBuilder.buildSuccess();
    }
}
