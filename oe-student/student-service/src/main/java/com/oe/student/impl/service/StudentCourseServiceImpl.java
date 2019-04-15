package com.oe.student.impl.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.dao.StudentCourseDao;
import com.oe.student.entity.StudentCourse;
import com.oe.student.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Service
public class StudentCourseServiceImpl  implements StudentCourseService {
    @Autowired
    private StudentCourseDao studentCourseDao;


    @Override
    public void addCourse(StudentCourse studentCourse) {
        studentCourseDao.addCourse(studentCourse);
    }

    @Override
    public void updateCourse(StudentCourse studentCourse) {
        studentCourseDao.updateStudentCourse(studentCourse);
    }

    @Override
    public StudentCourse selectStudentCourse(StudentCourse studentCourse){
        return studentCourseDao.selectStudentCourse(studentCourse);
    }
    @Override
    public List<Long> selectStudentsByCourseId(Long courseId) {
        return null;
    }

    @Override
    public IPage<StudentCourse> getCoursesByStudent(StudentCourse sc, Integer current, Integer size) {

        return studentCourseDao.selectCoursesByStudent(sc,current,size);
    }


}
