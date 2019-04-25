package com.oe.student.service;


import com.oe.student.entity.TeacherCourse;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherCourseService {

    void addCourse(TeacherCourse teacherCourse);

    void updateCourse(TeacherCourse teacherCourse);

    void deleteByCourseId(Long courseId);

    List<TeacherCourse> selectTeacherByCourseId(Long courseId);

    List<TeacherCourse> selectCourseByTeacherId(Long teacherId);

    TeacherCourse getTeacherCourse(TeacherCourse teacherCourse);

    List<TeacherCourse> getTeacherByCourseId(Long courseId);
}
