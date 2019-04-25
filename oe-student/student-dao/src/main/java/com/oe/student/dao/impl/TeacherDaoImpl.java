package com.oe.student.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oe.student.dao.TeacherDao;
import com.oe.student.entity.Teacher;
import com.oe.student.mapper.TeacherMapper;
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
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher selectTeacherByUserId(String userId) {
        return teacherMapper.selectById(userId);
    }

    @Override
    public List<Teacher> getTeacherByName(String teacherName) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Teacher::getTeacherName, teacherName);
        return teacherMapper.selectList(wrapper);
    }


    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateById(teacher);
    }
}
