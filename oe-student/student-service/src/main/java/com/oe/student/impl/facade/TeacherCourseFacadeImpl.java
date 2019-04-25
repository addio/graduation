package com.oe.student.impl.facade;

import com.oe.student.entity.Course;
import com.oe.student.entity.TeacherCourse;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.TeacherCourseFacade;
import com.oe.student.service.CourseService;
import com.oe.student.service.ExperimentService;
import com.oe.student.service.TeacherCourseService;
import com.oe.student.vo.CourseVo;
import com.oe.student.vo.TeacherCourseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwj
 * @data 2019/4/15
 */
@Component
public class TeacherCourseFacadeImpl implements TeacherCourseFacade {

    @Autowired
    private TeacherCourseService teacherCourseService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private ExperimentService experimentService;

    @Override
    public void addCourse(CourseVo courseVo) throws OeException {
        if (courseVo.getSchoolId() == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学校id不能为空");
        }

        Course course = new Course();
        course.setCourseInfo(courseVo.getCourseInfo());
        course.setSchoolId(Long.parseLong(courseVo.getSchoolId()));
        course.setCourseName(courseVo.getCourseName());
        course.setCourseImage(courseVo.getCourseImage());
        Long courseId = courseService.addCourse(course);
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setCourseId(courseId);
        teacherCourse.setTeacherId(Long.parseLong(courseVo.getTeacherId()));
        teacherCourse.setCourseName(course.getCourseName());
        teacherCourse.setTeacherName(courseVo.getTeacherName());
        teacherCourseService.addCourse(teacherCourse);
    }

    @Override
    public void updateCourse(CourseVo courseVo) throws OeException {
        if (StringUtils.isAnyBlank(courseVo.getCourseId())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setTeacherId(Long.parseLong(courseVo.getTeacherId()));
        teacherCourse.setCourseId(Long.parseLong(courseVo.getCourseId()));
        TeacherCourse tc = teacherCourseService.getTeacherCourse(teacherCourse);
        if (tc == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程不存在！");
        }
        Course course = new Course();
        course.setCourseImage(courseVo.getCourseImage());
        course.setCourseId(Long.parseLong(courseVo.getCourseId()));
        course.setSchoolId(Long.parseLong(courseVo.getSchoolId()));
        course.setCourseName(courseVo.getCourseName());
        course.setCourseInfo(courseVo.getCourseInfo());
        courseService.updateCourse(course);
    }


    @Override
    public void deleteByCourseId(String courseId) throws OeException {
        if (StringUtils.isBlank(courseId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        teacherCourseService.deleteByCourseId(Long.parseLong(courseId));
        courseService.deleteByCourseId(Long.parseLong(courseId));
        experimentService.deleteExperimentByCourseId(Long.parseLong(courseId));
    }

    @Override
    public List<TeacherCourseVo> selectTeachersByCourseId(String courseId) throws OeException {
        if (StringUtils.isBlank(courseId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "课程id不能为空");
        }
        List<TeacherCourse> list = teacherCourseService.selectTeacherByCourseId(Long.parseLong(courseId));
        List<TeacherCourseVo> result = new ArrayList<>();
        list.forEach(e -> {
            TeacherCourseVo vo = new TeacherCourseVo();
            vo.setTeacherId(e.getTeacherId().toString());
            vo.setTeacherName(e.getTeacherName());
            result.add(vo);
        });
        return result;
    }

    @Override
    public List<TeacherCourseVo> selectCoursesByTeacherId(String teacherId) throws OeException {
        if (StringUtils.isBlank(teacherId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "教师id不能为空");
        }
        List<TeacherCourse> list = teacherCourseService.selectCourseByTeacherId(Long.parseLong(teacherId));
        List<TeacherCourseVo> result = new ArrayList<>();
        list.forEach(e -> {
            TeacherCourseVo vo = new TeacherCourseVo();
            vo.setCourseId(e.getCourseId().toString());
            Course course = courseService.getCourseInfo(e.getCourseId());
            vo.setCourseImage(course.getCourseImage());
            vo.setCourseInfo(course.getCourseInfo());
            vo.setCourseName(e.getCourseName());
            result.add(vo);
        });
        return result;
    }
}
