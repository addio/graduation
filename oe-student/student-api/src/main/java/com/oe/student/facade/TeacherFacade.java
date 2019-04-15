package com.oe.student.facade;

import com.oe.student.vo.TeacherVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherFacade {

    TeacherVo selectTeacherByUserId(Long userId);

    void addTeacher(TeacherVo teacher);
}
