package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.TeacherFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import com.oe.student.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherFacade teacherFacade;

    @PostMapping("/updateTeacher")
    public OeResponse updateTeacher(@RequestBody TeacherVo teacherVo, HttpServletRequest request) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            teacherVo.setUserId((String) request.getAttribute("userId"));
            teacherFacade.addTeacher(teacherVo);

        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;

    }

    @GetMapping("/getTeacherInfo")
    public OeResponse getTeacherInfo(HttpServletRequest request) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {

            TeacherVo teacherVo = teacherFacade.selectTeacherByUserId((String) request.getAttribute("userId"));
            response.setBody((JSONObject) JSONObject.toJSON(teacherVo));

        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;

    }
}

