package com.oe.student.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oe.student.dao.TeacherCourseDao;
import com.oe.student.entity.Teacher;
import com.oe.student.entity.TeacherCourse;
import com.oe.student.mapper.TeacherCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Repository
public class TeacherCourseDaoImpl implements TeacherCourseDao {

    @Autowired
    private TeacherCourseMapper courseMapper;

    @Override
    public void addCourse(TeacherCourse teacherCourse) {
        courseMapper.insert(teacherCourse);
    }

    @Override
    public void updateCourse(TeacherCourse teacherCourse) {
        LambdaQueryWrapper<TeacherCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherCourse::getCourseId, teacherCourse.getCourseId())
                .eq(TeacherCourse::getTeacherId, teacherCourse.getTeacherId());
        courseMapper.update(teacherCourse, wrapper);
    }

    @Override
    public void deleteByCourseId(Long courseId) {

        LambdaQueryWrapper<TeacherCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherCourse::getCourseId, courseId);
        courseMapper.delete(wrapper);
    }

    @Override
    public List<TeacherCourse> selectTeachersByCourseId(Long courseId) {
        LambdaQueryWrapper<TeacherCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherCourse::getCourseId, courseId);
        return courseMapper.selectList(wrapper);
    }

    @Override
    public List<TeacherCourse> selectCoursesByTeacherId(Long teacherId) {
        LambdaQueryWrapper<TeacherCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherCourse::getTeacherId, teacherId);
        return courseMapper.selectList(wrapper);
    }

    @Override
    public TeacherCourse getTeacherCourse(TeacherCourse teacherCourse) {
        LambdaQueryWrapper<TeacherCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherCourse::getTeacherId, teacherCourse.getTeacherId())
                .eq(TeacherCourse::getCourseId, teacherCourse.getCourseId());
        return courseMapper.selectOne(wrapper);
    }

    @Override
    public Teacher getTeacherByCourseId(Long courseId) {
        LambdaQueryWrapper<TeacherCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TeacherCourse::getCourseId, courseId);
        TeacherCourse teacherCourse = courseMapper.selectOne(wrapper);
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherCourse.getTeacherId());
        teacher.setTeacherName(teacherCourse.getTeacherName());
        return teacher;
    }
}
