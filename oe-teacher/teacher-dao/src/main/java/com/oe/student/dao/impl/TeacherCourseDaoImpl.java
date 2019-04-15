package com.oe.student.dao.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.dao.TeacherCourseDao;
import com.oe.student.entity.TeacherCourse;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Repository
public class TeacherCourseDaoImpl implements TeacherCourseDao {

    @Override
    public void addCourse(TeacherCourse teacherCourse) {

    }

    @Override
    public void updateCourse(TeacherCourse teacherCourse) {

    }

    @Override
    public IPage<TeacherCourse> selectTeachersByCourseId(Long courseId) {
        return null;
    }

    @Override
    public IPage<TeacherCourse> selectCoursesByTeacherId(Long teacherId) {
        return null;
    }
}
