package com.oe.student.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.StudentCourse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentCourseDao {
    void addCourse(StudentCourse studentCourse);

    void updateStudentCourse(StudentCourse studentCourse);

    StudentCourse selectStudentCourse(StudentCourse studentCourse);

    IPage<StudentCourse> selectStudentsByCourseId(Long courseId);

    IPage<StudentCourse> selectCoursesByStudent(StudentCourse sc,Integer current,Integer size);
}
