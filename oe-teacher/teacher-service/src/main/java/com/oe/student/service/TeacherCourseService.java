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

    List<Long> selectTeacherByCourseId(Long courseId);

    List<Long> selectCourseByTeacherId(Long teacherId);
}
