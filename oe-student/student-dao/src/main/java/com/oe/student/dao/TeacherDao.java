package com.oe.student.dao;

import com.oe.student.entity.Teacher;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherDao {
    Teacher selectTeacherByUserId(String userId);

    List<Teacher> getTeacherByName(String teacherName);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);
}
