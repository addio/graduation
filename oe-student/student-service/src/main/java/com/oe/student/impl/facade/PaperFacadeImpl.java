package com.oe.student.impl.facade;

import com.alibaba.fastjson.JSONArray;
import com.oe.student.entity.Paper;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.PaperFacade;
import com.oe.student.service.PaperService;
import com.oe.student.vo.PaperVo;
import com.oe.student.vo.StepVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwj
 * @data 2019/4/12
 */
@Component
public class PaperFacadeImpl implements PaperFacade {

    @Autowired
    private PaperService paperService;

    @Override
    public void addPaper(PaperVo paperVo) throws OeException {

    }

    @Override
    public void updatePaper(PaperVo paperVo) throws OeException {
        if (StringUtils.isBlank(paperVo.getPaperId())){
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生未参加课程");
        }
        Paper paper = new Paper();
        paper.setPaperId(Long.parseLong(paperVo.getPaperId()));
        paper.setExperimentStatus(paperVo.getExperimentStatus());
        paper.setExperimentSteps(JSONArray.toJSONString(paperVo.getExperimentSteps()));
        paper.setExperimentPurpose(paperVo.getExperimentPurpose());
        paper.setExperimentClaim(paperVo.getExperimentClaim());
        paper.setExperimentTitle(paperVo.getExperimentTitle());
        paper.setExperimentFeeling(paperVo.getExperimentFeeling());
        paperService.updatePaper(paper);
    }

    @Override
    public PaperVo getPaper(String studentId, String experimentId) throws OeException {
        check(studentId, experimentId);
        Paper paper = paperService.getPaper(Long.parseLong(studentId),Long.parseLong(experimentId));
        PaperVo paperVo = new PaperVo();
        paperVo.setExperimentClaim(paper.getExperimentClaim());
        paperVo.setExperimentFeeling(paper.getExperimentFeeling());
        paperVo.setExperimentId(paper.getExperimentId().toString());
        paperVo.setExperimentPurpose(paper.getExperimentPurpose());
        paperVo.setExperimentStatus(paper.getExperimentStatus());
        paperVo.setPaperId(paper.getPaperId().toString());
        paperVo.setExperimentSteps(JSONArray.parseArray(paper.getExperimentSteps(), StepVo.class));
        paperVo.setExperimentTitle(paper.getExperimentTitle());
        return paperVo;

    }

    private void check(String studentId, String experimentId) throws OeException {
        if (StringUtils.isAnyBlank(experimentId, studentId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生id或者实验id不能为空");
        }
        Paper paper = paperService.getPaper(Long.parseLong(studentId), Long.parseLong(experimentId));
        if (paper == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生未参加课程");
        }
    }
}
