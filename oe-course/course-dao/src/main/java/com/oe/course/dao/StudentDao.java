package com.oe.course.dao;

import com.oe.course.entity.Student;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentDao {
    Student selectStudentByUserId(Long userId);

    void addStudent(Student student);
}
