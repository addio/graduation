package com.oe.student.impl.service;


import com.oe.student.dao.TeacherDao;
import com.oe.student.entity.Teacher;
import com.oe.student.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getTeacherByName(String teacherName) {
        return teacherDao.getTeacherByName(teacherName);
    }

    @Override
    public Teacher selectTeacherByUserId(String userId) {
        return teacherDao.selectTeacherByUserId(userId);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }


    @Override
    public void addTeacher(Teacher teacher) {

        teacherDao.addTeacher(teacher);
    }
}
