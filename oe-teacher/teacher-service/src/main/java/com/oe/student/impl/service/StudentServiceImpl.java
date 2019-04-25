package com.oe.student.impl.service;


import com.oe.student.dao.StudentDao;
import com.oe.student.entity.Student;
import com.oe.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    public Student selectStudentByUserId(String userId) {
        return studentDao.selectStudentByUserId(userId);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {

        studentDao.updateStudent(student);
    }
}
