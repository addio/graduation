package com.oe.student.impl.service;


import com.oe.student.entity.Teacher;
import com.oe.student.service.TeacherService;
import org.springframework.stereotype.Service;

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

    @Override
    public Teacher selectTeacherByUserId(Long userId) {
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {

    }
}
