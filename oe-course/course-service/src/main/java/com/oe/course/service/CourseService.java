package com.oe.course.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.course.entity.Course;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface CourseService {

    void addCourse(Course course);

    IPage<Course> selectCoursesByTeacher(Long teacherId);

    void updateCourse(Course course);


}
