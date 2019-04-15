package com.oe.student.impl.facade;

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
    public PageVo<ExperimentVo> getExperimentsByCourseId(String studentId, String courseId, Integer current, Integer size) throws OeException {
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
}
