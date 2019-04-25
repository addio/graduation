package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.TeacherVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface TeacherFacade {
    List<TeacherVo> getTeacherByName(String teacherName);

    TeacherVo selectTeacherByUserId(String userId) throws OeException;

    void updateTeacher(TeacherVo teacher) throws OeException;

    void addTeacher(TeacherVo teacher) throws OeException;
}
