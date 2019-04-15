package com.oe.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.oe.student.facade.SchoolFacade;
import com.oe.student.util.OeResponseBuilder;
import com.oe.student.vo.OeResponse;
import com.oe.student.vo.PageVo;
import com.oe.student.vo.SchoolVo;
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
public class SchoolController {

    @Autowired
    private SchoolFacade schoolFacade;

    @PostMapping("/getSchools")
    public OeResponse getSchools(@RequestBody SchoolVo schoolVo) {
        OeResponse response = OeResponseBuilder.buildSuccess();
        PageVo pageVo = schoolFacade.getSchools(schoolVo);
        response.setBody((JSONObject) JSONObject.toJSON(pageVo));
        return response;
    }
}

