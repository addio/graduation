package com.oe.student.impl.service;


import com.oe.student.dao.TeacherCourseDao;
import com.oe.student.entity.TeacherCourse;
import com.oe.student.service.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TeacherCourseDao teacherCourseDao;

    @Override
    public void addCourse(TeacherCourse teacherCourse) {
        teacherCourseDao.addCourse(teacherCourse);
    }

    @Override
    public void updateCourse(TeacherCourse teacherCourse) {
        teacherCourseDao.updateCourse(teacherCourse);
    }

    @Override
    public void deleteByCourseId(Long courseId) {
        teacherCourseDao.deleteByCourseId(courseId);
    }

    @Override
    public List<TeacherCourse> selectTeacherByCourseId(Long courseId) {
        return teacherCourseDao.selectTeachersByCourseId(courseId);
    }

    @Override
    public List<TeacherCourse> selectCourseByTeacherId(Long teacherId) {
        return teacherCourseDao.selectCoursesByTeacherId(teacherId);
    }

    @Override
    public TeacherCourse getTeacherCourse(TeacherCourse teacherCourse) {
        return teacherCourseDao.getTeacherCourse(teacherCourse);
    }

    @Override
    public List<TeacherCourse> getTeacherByCourseId(Long courseId) {
        return teacherCourseDao.selectTeachersByCourseId(courseId);
    }
}
