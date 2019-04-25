package com.oe.student.impl.facade;


import com.oe.student.entity.Student;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.StudentFacade;
import com.oe.student.service.StudentService;
import com.oe.student.vo.StudentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwj
 * @data 2019/4/8
 */
@Component
public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    private StudentService studentService;

    @Override
    public StudentVo getStudentByUserId(String userId) throws OeException {
        if (StringUtils.isBlank(userId)) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "用户id不能为空！");
        }
        Student student = studentService.selectStudentByUserId(userId);
        if (student == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "当前用户未绑定信息！");
        }
        StudentVo vo = new StudentVo();
        vo.setStudentId(student.getStudentId().toString());
        vo.setSchoolId(student.getSchoolId().toString());
        vo.setSchoolName(student.getSchoolName());
        vo.setStudentName(student.getStudentName());
        vo.setSex(student.getSex());
        vo.setAvatarUrl(student.getAvatarUrl());
        return vo;
    }

    @Override
    public void addStudent(StudentVo studentVo) {
        Student student = new Student();
        student.setStudentId(Long.parseLong(studentVo.getStudentId()));
        student.setSchoolId(Long.parseLong(studentVo.getSchoolId()));
        student.setSex(studentVo.getSex());
        student.setStudentName(studentVo.getStudentName());
        student.setUserId(studentVo.getUserId());
        student.setAvatarUrl(studentVo.getAvatarUrl());
        studentService.addStudent(student);
    }

    @Override
    public void updateStudent(StudentVo studentVo) throws OeException {
        Student nStudent = new Student();
        nStudent.setUserId(studentVo.getUserId());
        nStudent.setSex(studentVo.getSex());
        nStudent.setAvatarUrl(studentVo.getAvatarUrl());
        Student student = studentService.selectStudentByUserId(studentVo.getUserId());
        if (student == null) {
            if (StringUtils.isBlank(studentVo.getSchoolId())
                    || StringUtils.isBlank(studentVo.getUserId())
                    || StringUtils.isBlank(studentVo.getStudentName())) {
                throw new OeException(ResponseStatus.FAILED.getCode(), "请填写全部内容");
            }
            nStudent.setStudentId(Long.parseLong(studentVo.getStudentId()));
            nStudent.setSchoolId(Long.parseLong(studentVo.getSchoolId()));
            nStudent.setStudentName(studentVo.getStudentName());
            nStudent.setSchoolName(studentVo.getSchoolName());
            studentService.addStudent(nStudent);
        } else {
            nStudent.setStudentId(StringUtils.isEmpty(studentVo.getStudentId()) ? null : Long.parseLong(studentVo.getStudentId()));
            nStudent.setSchoolId(StringUtils.isEmpty(studentVo.getSchoolId()) ? null : Long.parseLong(studentVo.getSchoolId()));
            nStudent.setStudentName(StringUtils.isEmpty(studentVo.getStudentName()) ? null : studentVo.getStudentName());
            nStudent.setSchoolName(StringUtils.isEmpty(studentVo.getSchoolName()) ? null : studentVo.getSchoolName());

            studentService.updateStudent(nStudent);
        }


    }
}
