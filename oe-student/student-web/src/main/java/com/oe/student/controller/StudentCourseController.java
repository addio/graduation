package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.StudentCourseFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import com.oe.student.vo.StudentCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
@PreAuthorize("hasRole('student')")
public class StudentCourseController {

    @Autowired
    private StudentCourseFacade studentCourseFacade;


    @PostMapping("/getStudentCourses")
    public OeResponse getStudentCourses(@RequestBody StudentCourseVo vo) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            response.setBody((JSONObject) JSONObject.toJSON(studentCourseFacade.getCoursesByStudent(vo)));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }

    @GetMapping("getCourseInfo")
    public OeResponse getCourseInfo(String courseId, String studentId) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            response.setBody((JSONObject) JSONObject.toJSON(studentCourseFacade.getCourseInfo(courseId, studentId)));
        } catch (OeException e) {
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("updateCourseInfo")
    public OeResponse updateCourseInfo(@RequestBody StudentCourseVo studentCourseVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            studentCourseFacade.updateStudentCourse(studentCourseVo);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }
}

