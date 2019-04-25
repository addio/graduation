package com.oe.student.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.TeacherCourse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherCourseDao {
    void addCourse(TeacherCourse teacherCourse);

    void updateCourse(TeacherCourse teacherCourse);

    IPage<TeacherCourse> selectTeachersByCourseId(Long courseId);

    IPage<TeacherCourse> selectCoursesByTeacherId(Long teacherId);
}
