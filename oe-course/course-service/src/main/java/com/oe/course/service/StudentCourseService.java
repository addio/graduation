package com.oe.course.service;

import com.oe.course.entity.StudentCourse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentCourseService {
    void addCourse(StudentCourse studentCourse);

    void updateCourse(StudentCourse studentCourse);

    List<Long> selectStudentsByCourseId(Long courseId);

    List<Long> selectCoursesByStudentId(Long studentId);
}
