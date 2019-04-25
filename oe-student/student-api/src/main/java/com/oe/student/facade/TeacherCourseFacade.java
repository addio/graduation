package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.CourseVo;
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


    void addCourse(CourseVo courseVo) throws OeException;

    void updateCourse(CourseVo courseVo) throws OeException;

    void deleteByCourseId(String courseId) throws OeException;

    List<TeacherCourseVo> selectTeachersByCourseId(String courseId) throws OeException;

    List<TeacherCourseVo> selectCoursesByTeacherId(String teacherId) throws OeException;
}
