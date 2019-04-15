package com.oe.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.StudentCourse;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentCourseService {
    void addCourse(StudentCourse studentCourse);

    void updateCourse(StudentCourse studentCourse);

    List<Long> selectStudentsByCourseId(Long courseId);

    StudentCourse selectStudentCourse(StudentCourse studentCourse);

    IPage<StudentCourse> getCoursesByStudent(StudentCourse sc, Integer current, Integer size);
}
