package com.oe.student.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oe.student.dao.StudentDao;
import com.oe.student.entity.Student;
import com.oe.student.mapper.StudentMapper;
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
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectStudentByUserId(String userId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getUserId, userId);
        return studentMapper.selectOne(wrapper);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getUserId, student.getUserId());
        studentMapper.update(student, wrapper);
    }
}
