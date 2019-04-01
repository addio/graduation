package com.oe.course.dao;

import com.oe.course.entity.Teacher;

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
