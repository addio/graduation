package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.ExperimentFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ExperimentController {

    @Autowired
    private ExperimentFacade experimentFacade;

    @GetMapping("/getExperimentsByCourseId")
    public OeResponse getExperimentsByCourseId(String studentId, String courseId, Integer current, Integer size) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            response.setBody((JSONObject) JSONObject.toJSON(experimentFacade.getExperimentsByCourseId(studentId, courseId, current, size)));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }

}

