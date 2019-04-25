package com.oe.student.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.dao.CourseDao;
import com.oe.student.entity.Course;
import com.oe.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public void addCourse(Course course) {

    }

    @Override
    public IPage<Course> selectCoursesByTeacher(Long teacherId) {
        return null;
    }

    @Override
    public IPage<Course> getCourses(Course course, Integer current, Integer size) {
        return courseDao.selectCourses(course, current, size);
    }

    @Override
    public Course getCourseInfo(Long courseId) {
        return courseDao.selectCourseInfo(courseId);
    }

    @Override
    public void updateCourse(Course course) {

    }
}
