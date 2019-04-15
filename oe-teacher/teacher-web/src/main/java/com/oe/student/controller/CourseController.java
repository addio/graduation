package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.CourseFacade;
import com.oe.student.facade.StudentFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.CourseVo;
import com.oe.student.vo.OeResponse;
import com.oe.student.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CourseController {
    @Autowired
    private StudentFacade studentFacade;

    @Autowired
    private CourseFacade courseFacade;


    @PostMapping("/getCourses")
    public OeResponse getCourses(@RequestBody CourseVo courseVo, HttpServletRequest request) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            StudentVo studentVo = studentFacade.getStudentByUserId((String) request.getAttribute("userId"));
            if (studentVo == null) {
                return OeResponseBuilder.buildFailed(new OeException(ResponseStatus.FAILED.getCode(), "当前用户未绑定信息"));
            }
            courseVo.setSchoolId(studentVo.getSchoolId());
            response.setBody((JSONObject) JSONObject.toJSON(courseFacade.getCourses(courseVo)));
        } catch (OeException e) {
            e.printStackTrace();
        }
        return response;
    }


}

