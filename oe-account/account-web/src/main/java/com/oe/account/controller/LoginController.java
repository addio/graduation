package com.oe.account.controller;

import com.oe.account.exception.OeException;
import com.oe.account.facade.UserFacade;
import com.oe.account.util.JwtBuilder;
import com.oe.account.util.OeResponseBuilder;
import com.oe.account.vo.OeResponse;
import com.oe.account.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@RestController
public class LoginController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/wxLogin")
    public OeResponse wxLogin(String code, HttpServletResponse res) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        UserVo userVo;
        try {
            userVo = userFacade.wxLogin(code);
            res.addHeader("Authorization", "Bearer " + JwtBuilder.buildJwtToken(userVo));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }

    @GetMapping("/login")
    public OeResponse login(String username, String password, HttpServletResponse res) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        UserVo userVo;
        try {
            userVo = userFacade.getUserByUsername(username);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        res.addHeader("Authorization", "Bearer " + JwtBuilder.buildJwtToken(userVo));
        return response;
    }

    @PostMapping("/register")
    public OeResponse register(@RequestBody UserVo userVo, HttpServletResponse res) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            userFacade.register(userVo);
            UserVo vo = userFacade.getUserByUsername(userVo.getUsername());
            res.addHeader("Authorization", "Bearer " + JwtBuilder.buildJwtToken(vo));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }
}
