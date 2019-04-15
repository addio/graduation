package com.oe.student.impl.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Course;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.CourseFacade;
import com.oe.student.service.CourseService;
import com.oe.student.vo.CourseVo;
import com.oe.student.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwj
 * @data 2019/4/8
 */
@Component
public class CourseFacadeImpl implements CourseFacade {
    @Autowired
    private CourseService courseService;

    @Override
    public void addCourse(CourseVo course) {

    }

    @Override
    public PageVo getCoursesByTeacher(Long teacherId) {
        return null;
    }

    @Override
    public PageVo<CourseVo> getCourses(CourseVo courseVo) throws OeException {
        if (courseVo.getSchoolId() == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "学校id不能为空");
        }
        Course course = new Course();
        if (StringUtils.isNotBlank(courseVo.getCourseId())) {
            course.setCourseId(Long.parseLong(courseVo.getCourseId()));
        }
        course.setCourseName(courseVo.getCourseName());
        course.setSchoolId(Long.parseLong(courseVo.getSchoolId()));
        IPage<Course> page = courseService.getCourses(course, courseVo.getCurrent(), courseVo.getSize());
        PageVo<CourseVo> pageVo = new PageVo<>();
        pageVo.setTotal(page.getTotal());
        pageVo.setSize(page.getSize());
        pageVo.setCurrent(page.getCurrent());
        List<Course> list = page.getRecords();
        List<CourseVo> records = new ArrayList<>(list.size());
        list.forEach(e -> {
            CourseVo vo = new CourseVo();
            vo.setCourseId(e.getCourseId().toString());
            vo.setCourseName(e.getCourseName());
            vo.setCourseImage(e.getCourseImage());
            vo.setCourseInfo(e.getCourseInfo());
            records.add(vo);
        });
        pageVo.setRecords(records);
        return pageVo;
    }



    @Override
    public void updateCourse(CourseVo course) {

    }
}
