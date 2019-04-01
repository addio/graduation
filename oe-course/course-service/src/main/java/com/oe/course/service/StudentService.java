package com.oe.course.service;


import com.oe.course.entity.Student;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentService {

    Student selectStudentByUserId(Long userId);

    void addStudent(Student student);
}
