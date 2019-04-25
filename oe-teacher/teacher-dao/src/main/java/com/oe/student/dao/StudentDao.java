package com.oe.student.dao;

import com.oe.student.entity.Student;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentDao {
    Student selectStudentByUserId(String userId);

    void addStudent(Student student);

    void updateStudent(Student student);
}
