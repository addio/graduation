package com.oe.student.impl.service;


import com.oe.student.entity.TeacherCourse;
import com.oe.student.service.TeacherCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    @Override
    public void addCourse(TeacherCourse teacherCourse) {

    }

    @Override
    public void updateCourse(TeacherCourse teacherCourse) {

    }

    @Override
    public List<Long> selectTeacherByCourseId(Long courseId) {
        return null;
    }

    @Override
    public List<Long> selectCourseByTeacherId(Long teacherId) {
        return null;
    }
}
