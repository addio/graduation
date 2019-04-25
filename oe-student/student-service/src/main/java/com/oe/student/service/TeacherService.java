package com.oe.student.service;


import com.oe.student.entity.Teacher;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherService {
    List<Teacher> getTeacherByName(String teacherName);

    Teacher selectTeacherByUserId(String userId);

    void updateTeacher(Teacher teacher);

    void addTeacher(Teacher teacher);
}
