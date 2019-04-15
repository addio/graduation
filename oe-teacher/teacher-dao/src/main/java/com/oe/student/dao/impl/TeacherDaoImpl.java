package com.oe.student.dao.impl;


import com.oe.student.dao.TeacherDao;
import com.oe.student.entity.Teacher;
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
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public Teacher selectTeacherByUserId(Long userId) {
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {

    }
}
