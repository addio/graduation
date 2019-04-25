package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.StudentVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentFacade {

    StudentVo getStudentByUserId(String userId) throws OeException;

    void addStudent(StudentVo student);

    void updateStudent(StudentVo student) throws OeException;
}
