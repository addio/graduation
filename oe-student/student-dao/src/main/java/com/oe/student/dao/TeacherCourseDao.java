package com.oe.student.dao;

import com.oe.student.entity.Teacher;
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
public interface TeacherCourseDao {
    void addCourse(TeacherCourse teacherCourse);

    void updateCourse(TeacherCourse teacherCourse);

    void deleteByCourseId(Long courseId);

    List<TeacherCourse> selectTeachersByCourseId(Long courseId);

    List<TeacherCourse> selectCoursesByTeacherId(Long teacherId);

    TeacherCourse getTeacherCourse(TeacherCourse teacherCourse);

    Teacher getTeacherByCourseId(Long courseId);
}
