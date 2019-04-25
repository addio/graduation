package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.CourseVo;
import com.oe.student.vo.PageVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface CourseFacade {

//    void addCourse(CourseVo course) throws OeException;

    PageVo getCoursesByTeacher(Long teacherId, Long schoolId) throws OeException;

    PageVo getCourses(CourseVo courseVo) throws OeException;


    void updateCourse(CourseVo course);


}
