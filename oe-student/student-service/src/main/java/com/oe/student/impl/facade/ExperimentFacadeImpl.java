package com.oe.student.impl.facade;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Experiment;
import com.oe.student.entity.Paper;
import com.oe.student.entity.StudentCourse;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.ExperimentFacade;
import com.oe.student.service.ExperimentService;
import com.oe.student.service.PaperService;
import com.oe.student.service.StudentCourseService;
import com.oe.student.vo.ExperimentVo;
import com.oe.student.vo.PageVo;
import com.oe.student.vo.StepVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwj
 * @data 2019/4/11
 */
@Component
public class ExperimentFacadeImpl implements ExperimentFacade {
    @Autowired
    private ExperimentService experimentService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private StudentCourseService studentCourseService;


    @Override
    public PageVo<ExperimentVo> getStudentExperimentsByCourseId(String studentId, String courseId, Integer current, Integer size) throws OeException {
        if (current == null) {
            current = 1;
        }
        if (size == null) {
            size = 12;
        }
        if (StringUtils.isBlank(courseId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        if (StringUtils.isBlank(studentId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生id不能为空");
        }
        IPage<Experiment> page = experimentService.getExperimentsByCourseId(Long.parseLong(courseId), current, size);
        PageVo<ExperimentVo> pageVo = new PageVo<>();
        pageVo.setCurrent(page.getCurrent());
        pageVo.setSize(page.getSize());
        pageVo.setTotal(page.getTotal());
        List<Experiment> list = page.getRecords();
        StudentCourse sc = new StudentCourse();
        sc.setStudentId(Long.parseLong(studentId));
        sc.setCourseId(Long.parseLong(courseId));
        IPage<StudentCourse> p = studentCourseService.getCoursesByStudent(sc, 1, 1);

        List<ExperimentVo> records = new ArrayList<>();
        if (p.getTotal() == 0 || p.getRecords().get(0).getiJoin() == 0) {
            list.forEach(e -> {
                ExperimentVo vo = new ExperimentVo();
                vo.setExperimentId(e.getExperimentId().toString());
                vo.setExperimentTitle(e.getExperimentTitle());
                records.add(vo);
            });
        } else {
            list.forEach(e -> {
                Paper paper = paperService.getPaper(Long.parseLong(studentId), e.getExperimentId());
                ExperimentVo vo = new ExperimentVo();
                vo.setExperimentId(e.getExperimentId().toString());
                vo.setExperimentTitle(e.getExperimentTitle());
                vo.setExperimentStatus(paper.getExperimentStatus());
                records.add(vo);
            });
        }
        pageVo.setRecords(records);
        return pageVo;

    }

    @Override
    public PageVo<ExperimentVo> getTeacherExperimentsByCourseId(String courseId, Integer current, Integer size) throws OeException {
        if (current == null) {
            current = 1;
        }
        if (size == null) {
            size = 12;
        }
        if (StringUtils.isBlank(courseId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        IPage<Experiment> page = experimentService.getExperimentsByCourseId(Long.parseLong(courseId), current, size);
        PageVo<ExperimentVo> pageVo = new PageVo<>();
        pageVo.setCurrent(page.getCurrent());
        pageVo.setSize(page.getSize());
        pageVo.setTotal(page.getTotal());
        List<Experiment> list = page.getRecords();
        List<ExperimentVo> records = new ArrayList<>();
        list.forEach(e -> {
            ExperimentVo vo = new ExperimentVo();
            vo.setExperimentId(e.getExperimentId().toString());
            vo.setExperimentTitle(e.getExperimentTitle());
            vo.setExperimentClaim(e.getExperimentClaim());
            vo.setCourseId(e.getCourseId().toString());
            vo.setExperimentSteps(JSONArray.parseArray(e.getExperimentSteps(), StepVo.class));
            vo.setExperimentPurpose(e.getExperimentPurpose());
            vo.setExperimentAnalysis(e.getExperimentAnalysis());
            records.add(vo);
        });
        pageVo.setRecords(records);
        return pageVo;
    }

    @Override
    public void addExperiment(ExperimentVo experimentVo) throws OeException {
        if (StringUtils.isAnyBlank(experimentVo.getCourseId(), experimentVo.getExperimentClaim(),
                experimentVo.getExperimentPurpose(), experimentVo.getExperimentTitle())
                || experimentVo.getExperimentSteps().size() == 0) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "请填写完整的信息！");
        }
        Experiment experiment = new Experiment();
        experiment.setCourseId(Long.parseLong(experimentVo.getCourseId()));
        experiment.setExperimentClaim(experimentVo.getExperimentClaim());
        experiment.setExperimentSteps(JSONArray.toJSONString(experimentVo.getExperimentSteps()));
        experiment.setExperimentPurpose(experimentVo.getExperimentPurpose());
        experiment.setExperimentTitle(experimentVo.getExperimentTitle());
        experiment.setExperimentAnalysis(experimentVo.getExperimentAnalysis());
        experimentService.addExperiment(experiment);
    }

    @Override
    public void updateExperiment(ExperimentVo experimentVo) throws OeException {
        if (StringUtils.isBlank(experimentVo.getExperimentId())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "实验id不能为空！");
        }
        Experiment experiment = new Experiment();
        experiment.setExperimentId(Long.parseLong(experimentVo.getExperimentId()));
        experiment.setExperimentClaim(experimentVo.getExperimentClaim());
        experiment.setExperimentSteps(JSONArray.toJSONString(experimentVo.getExperimentSteps()));
        experiment.setExperimentPurpose(experimentVo.getExperimentPurpose());
        experiment.setExperimentTitle(experimentVo.getExperimentTitle());
        experiment.setExperimentAnalysis(experimentVo.getExperimentAnalysis());
        experimentService.updateExperiment(experiment);
    }

    @Override
    public void deleteExperiment(String experimentId) throws OeException {
        if (StringUtils.isBlank(experimentId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "实验id不能为空！");
        }
        experimentService.deleteExperiment(Long.parseLong(experimentId));
    }

    @Override
    public ExperimentVo getExperimentAnalysis(String experimentId) throws OeException {
        if (StringUtils.isBlank(experimentId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "实验id不能为空！");
        }
        Experiment experiment = experimentService.getExperimentById(Long.parseLong(experimentId));
        ExperimentVo experimentVo = new ExperimentVo();
        experimentVo.setExperimentAnalysis(experiment.getExperimentAnalysis());
        return experimentVo;
    }

}
