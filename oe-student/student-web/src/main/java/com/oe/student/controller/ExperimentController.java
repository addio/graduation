package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.ExperimentFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.ExperimentVo;
import com.oe.student.vo.OeResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExperimentController {

    @Autowired
    private ExperimentFacade experimentFacade;

    @GetMapping("/getExperimentsByCourseId")
    public OeResponse getExperimentsByCourseId(String studentId, String courseId, Integer current, Integer size) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            response.setBody((JSONObject) JSONObject.toJSON(experimentFacade.getStudentExperimentsByCourseId(studentId, courseId, current, size)));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }

    @GetMapping("/getTeacherExperimentsByCourseId")
    public OeResponse getTeacherExperimentsByCourseId(String courseId, Integer current, Integer size) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            response.setBody((JSONObject) JSONObject.toJSON(experimentFacade.getTeacherExperimentsByCourseId(courseId, current, size)));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }

    @PostMapping("/addExperiment")
    public OeResponse addExperiment(@RequestBody ExperimentVo experimentVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            experimentFacade.addExperiment(experimentVo);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }


    @GetMapping("/getExperimentAnalysis")
    public OeResponse getExperimentAnalysis(String experimentId) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            response.setBody((JSONObject) JSONObject.toJSON(experimentFacade.getExperimentAnalysis(experimentId)));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }

    @PostMapping("/updateExperiment")
    public OeResponse updateExperiment(@RequestBody ExperimentVo experimentVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            experimentFacade.updateExperiment(experimentVo);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }

    @GetMapping("/deleteExperiment")
    public OeResponse deleteExperiment(String experimentId) {
        OeResponse response = OeResponseBuilder.buildSuccess();

        try {
            experimentFacade.deleteExperiment(experimentId);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;


    }

}

