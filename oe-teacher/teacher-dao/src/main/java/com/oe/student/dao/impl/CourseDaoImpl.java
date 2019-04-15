package com.oe.student.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oe.student.dao.CourseDao;
import com.oe.student.entity.Course;
import com.oe.student.mapper.CourseMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public void addCourse(Course course) {

    }

    @Override
    public IPage<Course> selectCoursesByTeacher(Long teacherId) {
        return null;
    }

    @Override
    public IPage<Course> selectCourses(Course course, Integer current, Integer size) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        if (course.getCourseId() != null) {
            wrapper.eq(Course::getCourseId, course.getCourseId());
        }
        wrapper.eq(Course::getSchoolId, course.getSchoolId());
        if (StringUtils.isNotBlank(course.getCourseName())) {
            wrapper.like(Course::getCourseName, course.getCourseName());
        }
        Page<Course> page = new Page<>(current, size);
        return courseMapper.selectPage(page, wrapper);
    }

    @Override
    public Course selectCourseInfo(Long courseId) {
        return courseMapper.selectById(courseId);
    }

    @Override
    public void updateCourse(Course course) {

    }
}
