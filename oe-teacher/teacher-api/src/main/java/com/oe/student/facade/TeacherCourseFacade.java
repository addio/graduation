package com.oe.student.facade;

import com.oe.student.vo.TeacherCourseVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherCourseFacade {

    void addCourse(TeacherCourseVo teacherCourse);

    void updateCourse(TeacherCourseVo teacherCourse);

    List<Long> selectTeacherByCourseId(Long courseId);

    List<Long> selectCourseByTeacherId(Long teacherId);
}
