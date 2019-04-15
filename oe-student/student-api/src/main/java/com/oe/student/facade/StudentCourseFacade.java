package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.CourseInfoVo;
import com.oe.student.vo.PageVo;
import com.oe.student.vo.StudentCourseVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface StudentCourseFacade {
    void addStudentCourse(StudentCourseVo studentCourse);

    void updateStudentCourse(StudentCourseVo studentCourse) throws OeException;

    PageVo getStudentsByCourseId(Long courseId);

    CourseInfoVo getCourseInfo(String courseId, String studentId) throws OeException;

    PageVo getCoursesByStudent(StudentCourseVo studentCourseVo) throws OeException;
}
