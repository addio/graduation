package com.oe.course.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.course.entity.StudentCourse;

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

    void updateCourse(StudentCourse studentCourse);

    IPage<StudentCourse> selectStudentsByCourseId(Long courseId);

    IPage<StudentCourse> selectCoursesByStudentId(Long studentId);
}
