package com.oe.course.dao;

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
public interface CourseDao {
    void addCourse(Course course);

    IPage<Course> selectCoursesByTeacher(Long teacherId);

    void updateCourse(Course course);

}
