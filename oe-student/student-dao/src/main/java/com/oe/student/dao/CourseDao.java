package com.oe.student.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Course;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface CourseDao {
    void addCourse(Course course);

    IPage<Course> selectCoursesByTeacher(Long teacherId);
    IPage<Course> selectCourses(Course course,Integer current, Integer size);
    Course selectCourseInfo(Long courseId);
    void updateCourse(Course course);

}
