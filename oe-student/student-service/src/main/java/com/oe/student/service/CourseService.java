package com.oe.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Course;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface CourseService {

    Long addCourse(Course course);

    IPage<Course> selectCoursesByTeacher(Long teacherId);

    void deleteByCourseId(Long courseId);

    IPage<Course> getCourses(Course course, Integer current, Integer size);

    Course getCourseInfo(Long courseId);

    void updateCourse(Course course);


}
