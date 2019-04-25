package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.exception.OeException;
import com.oe.student.facade.PaperFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import com.oe.student.vo.PaperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 * 学生完成的内容 前端控制器
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@RestController
@PreAuthorize("hasRole('student')")
public class PaperController {

    @Autowired
    private PaperFacade paperFacade;

    @GetMapping("/getPaper")
    public OeResponse getPaper(String studentId, String experimentId) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            PaperVo paperVo = paperFacade.getPaper(studentId, experimentId);
            response.setBody((JSONObject) JSONObject.toJSON(paperVo));
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }

    @PostMapping("/updatePaper")
    public OeResponse updatePaper(@RequestBody PaperVo paperVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            paperFacade.updatePaper(paperVo);
        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }

    @PostMapping("/executeCode")
    public OeResponse executeCode(@RequestBody PaperVo paperVo, HttpServletRequest request) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        try {
            String realPath = request.getServletContext().getRealPath(File.separator);
            response.setBody((JSONObject) JSONObject.toJSON(paperFacade.executeCode(paperVo, realPath)));

        } catch (OeException e) {
            return OeResponseBuilder.buildFailed(e);
        }
        return response;
    }
}

