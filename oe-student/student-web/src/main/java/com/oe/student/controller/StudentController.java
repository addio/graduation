package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.StudentFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import com.oe.student.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@RestController
@PreAuthorize("hasRole('student')")
public class StudentController {

    @Autowired
    private StudentFacade studentFacade;

    @PostMapping("/updateStudent")
    public OeResponse addStudent(@RequestBody StudentVo studentVo, HttpServletRequest request) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            studentVo.setUserId((String) request.getAttribute("userId"));
            studentFacade.updateStudent(studentVo);

        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;

    }

    @GetMapping("/getStudentInfo")
    public OeResponse getStudentInfo(HttpServletRequest request) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {

            StudentVo studentVo = studentFacade.getStudentByUserId((String) request.getAttribute("userId"));
            response.setBody((JSONObject) JSONObject.toJSON(studentVo));

        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;

    }


}

