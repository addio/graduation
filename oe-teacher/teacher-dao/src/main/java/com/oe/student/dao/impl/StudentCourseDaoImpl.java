package com.oe.student.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oe.student.dao.StudentCourseDao;
import com.oe.student.entity.StudentCourse;
import com.oe.student.mapper.StudentCourseMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Repository
public class StudentCourseDaoImpl implements StudentCourseDao {
    @Autowired
    private StudentCourseMapper studentCourseMapper;


    @Override
    public void addCourse(StudentCourse studentCourse) {
        studentCourseMapper.insert(studentCourse);
    }

    @Override
    public void updateStudentCourse(StudentCourse studentCourse) {
        LambdaQueryWrapper<StudentCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentCourse::getStudentId, studentCourse.getStudentId())
                .eq(StudentCourse::getCourseId, studentCourse.getCourseId());
        studentCourseMapper.update(studentCourse, wrapper);
    }

    @Override
    public StudentCourse selectStudentCourse(StudentCourse studentCourse) {
        LambdaQueryWrapper<StudentCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudentCourse::getStudentId, studentCourse.getStudentId())
                .eq(StudentCourse::getCourseId, studentCourse.getCourseId());

        return studentCourseMapper.selectOne(wrapper);
    }

    @Override
    public IPage<StudentCourse> selectStudentsByCourseId(Long courseId) {
        return null;
    }

    @Override
    public IPage<StudentCourse> selectCoursesByStudent(StudentCourse sc, Integer current, Integer size) {
        LambdaQueryWrapper<StudentCourse> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(sc.getCourseName())) {
            wrapper.like(StudentCourse::getCourseName, sc.getCourseName());
        }
        if (sc.getCollect() != null && sc.getCollect() == 1) {
            wrapper.eq(StudentCourse::getCollect, sc.getCollect());
        }
        if (sc.getiJoin() != null && sc.getiJoin() == 1) {
            wrapper.eq(StudentCourse::getCollect, sc.getCollect());
            wrapper.eq(StudentCourse::getiJoin, sc.getiJoin());
        }
        if (sc.getStudentId() != null) {
            wrapper.eq(StudentCourse::getStudentId, sc.getStudentId());
        }
        if (sc.getCourseId() != null) {
            wrapper.eq(StudentCourse::getCourseId, sc.getCourseId());
        }
        Page<StudentCourse> page = new Page<>(current, size);
        return studentCourseMapper.selectPage(page, wrapper);
    }


}
