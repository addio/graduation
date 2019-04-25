package com.oe.student.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.TeacherCourseFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.CourseVo;
import com.oe.student.vo.OeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@RestController
public class TeacherCourseController {

    @Autowired
    private TeacherCourseFacade courseFacade;

    @GetMapping("/getCoursesByTeacherId")
    public OeResponse getCoursesByTeacherId(String teacherId) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            JSONArray array = (JSONArray) JSONArray.toJSON(courseFacade.selectCoursesByTeacherId(teacherId));
            JSONObject object = new JSONObject();
            object.put("records", array);
            response.setBody(object);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }

        return response;
    }

    @PostMapping("/addCourse")
    public OeResponse addCourse(@RequestBody CourseVo courseVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            courseFacade.addCourse(courseVo);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }

        return response;
    }

    @PostMapping("/updateCourse")
    public OeResponse updateCourse(@RequestBody CourseVo courseVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            courseFacade.updateCourse(courseVo);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }

        return response;
    }

    @GetMapping("/deleteCourse")
    public OeResponse deleteCourse(String courseId) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            courseFacade.deleteByCourseId(courseId);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }

        return response;
    }
}

