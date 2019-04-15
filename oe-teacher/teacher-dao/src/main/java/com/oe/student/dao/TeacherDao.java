package com.oe.student.dao;

import com.oe.student.entity.Teacher;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherDao {
    Teacher selectTeacherByUserId(Long userId);

    void addTeacher(Teacher teacher);
}
