package com.oe.student.impl.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Course;
import com.oe.student.entity.Experiment;
import com.oe.student.entity.Paper;
import com.oe.student.entity.StudentCourse;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.StudentCourseFacade;
import com.oe.student.service.CourseService;
import com.oe.student.service.ExperimentService;
import com.oe.student.service.PaperService;
import com.oe.student.service.StudentCourseService;
import com.oe.student.vo.CourseInfoVo;
import com.oe.student.vo.PageVo;
import com.oe.student.vo.StudentCourseVo;
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
public class StudentCourseFacadeImpl implements StudentCourseFacade {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentCourseService studentCourseService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private ExperimentService experimentService;

    @Override
    public void addStudentCourse(StudentCourseVo studentCourse) {

    }

    @Override
    public void updateStudentCourse(StudentCourseVo studentCourseVo) throws OeException {
        if (StringUtils.isBlank(studentCourseVo.getCourseId())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        if (StringUtils.isBlank(studentCourseVo.getStudentId())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生id不能为空");
        }
        StudentCourse set = new StudentCourse();
        set.setCourseId(Long.parseLong(studentCourseVo.getCourseId()));
        set.setStudentId(Long.parseLong(studentCourseVo.getStudentId()));
        set.setiJoin(studentCourseVo.getJoin());
        set.setCollect(studentCourseVo.getCollect());
        set.setCourseName(courseService.getCourseInfo(Long.parseLong(studentCourseVo.getCourseId())).getCourseName());
        StudentCourse sc = studentCourseService.selectStudentCourse(set);
        Integer join = studentCourseVo.getJoin();
        if (sc == null) {
            studentCourseService.addCourse(set);
            if (join != null && join == 1) {
                updatePapers(studentCourseVo.getCourseId(), studentCourseVo.getStudentId(), false, true);
            }
        } else {
            if (join != null && join == 1) {
                updatePapers(studentCourseVo.getCourseId(), studentCourseVo.getStudentId(), false, false);
            } else if (join != null && join == 0) {
                updatePapers(studentCourseVo.getCourseId(), studentCourseVo.getStudentId(), true, false);
            }
            studentCourseService.updateCourse(set);
        }
    }

    @Override
    public PageVo getStudentsByCourseId(Long courseId) {
        return null;
    }

    @Override
    public PageVo<StudentCourseVo> getCoursesByStudent(StudentCourseVo studentCourseVo) throws OeException {
        if (StringUtils.isBlank(studentCourseVo.getStudentId())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生id不能为空");
        }
        StudentCourse course = new StudentCourse();
        course.setCollect(studentCourseVo.getCollect());
        course.setiJoin(studentCourseVo.getJoin());
        if (StringUtils.isNotBlank(studentCourseVo.getStudentId())) {
            course.setStudentId(Long.parseLong(studentCourseVo.getStudentId()));
        }
        if (StringUtils.isNotBlank(studentCourseVo.getCourseId())) {
            course.setCourseId(Long.parseLong(studentCourseVo.getCourseId()));
        }
        course.setCourseName(studentCourseVo.getCourseName());
        IPage<StudentCourse> page = studentCourseService.getCoursesByStudent(course, studentCourseVo.getCurrent(), studentCourseVo.getSize());
        PageVo<StudentCourseVo> pageVo = new PageVo<>();
        pageVo.setTotal(page.getTotal());
        pageVo.setSize(page.getSize());
        pageVo.setCurrent(page.getCurrent());
        List<StudentCourse> list = page.getRecords();
        List<StudentCourseVo> records = new ArrayList<>(list.size());
        list.forEach(e -> {
            StudentCourseVo vo = new StudentCourseVo();
            vo.setCourseId(e.getCourseId().toString());
            vo.setCourseName(e.getCourseName());
            vo.setCollect(e.getCollect());
            vo.setJoin(e.getiJoin());
            records.add(vo);
        });
        pageVo.setRecords(records);
        return pageVo;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId, String studentId) throws OeException {
        if (StringUtils.isBlank(courseId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        if (StringUtils.isBlank(studentId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学生id不能为空");
        }
        CourseInfoVo vo = new CourseInfoVo();
        Course course = courseService.getCourseInfo(Long.parseLong(courseId));
        if (course == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程不存在");
        }
        vo.setCourseInfo(course.getCourseInfo());
        vo.setCourseImage(course.getCourseImage());
        vo.setCourseName(course.getCourseName());
        StudentCourse set = new StudentCourse();
        set.setCourseId(course.getCourseId());

        set.setStudentId(Long.parseLong(studentId));
        IPage<StudentCourse> page = studentCourseService.getCoursesByStudent(set, 1, 1);
        if (page.getTotal() == 0) {
            vo.setCollect(0);
            vo.setJoin(0);
        } else {
            vo.setCollect(page.getRecords().get(0).getCollect());
            vo.setJoin(page.getRecords().get(0).getiJoin());
        }

        return vo;
    }

    private void updatePapers(String courseId, String studentId, boolean delete, boolean firstJoin) {
        IPage<Experiment> page = experimentService.getExperimentsByCourseId(Long.parseLong(courseId), 1, 65536);
        if (page.getTotal() != 0) {
            List<Experiment> experimentList = page.getRecords();
            experimentList.forEach(e -> {
                Paper paper = new Paper();
                paper.setStudentId(Long.parseLong(studentId));
                paper.setExperimentId(e.getExperimentId());
                paper.setExperimentTitle(e.getExperimentTitle());
                paper.setExperimentClaim(e.getExperimentClaim());
                paper.setExperimentPurpose(e.getExperimentPurpose());
                paper.setExperimentSteps(e.getExperimentSteps());
                paper.setExperimentStatus(0);
                if (delete) {
                    paper.setExperimentStatus(-1);
                    paperService.updatePaper(paper);
                } else {
                    if (firstJoin) {
                        paperService.addPaper(paper);
                    } else {
                        paper.setExperimentStatus(0);
                        paperService.updatePaper(paper);
                    }
                }
            });
        }
    }
}
