package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.CourseFacade;
import com.oe.student.facade.StudentFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.CourseVo;
import com.oe.student.vo.OeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public OeResponse getCourses(@RequestBody CourseVo courseVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            response.setBody((JSONObject) JSONObject.toJSON(courseFacade.getCourses(courseVo)));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }

        return response;
    }


}

