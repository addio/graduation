package com.oe.student.impl.facade;

import com.oe.student.entity.Teacher;
import com.oe.student.enums.ResponseStatus;
import com.oe.student.exception.OeException;
import com.oe.student.facade.TeacherFacade;
import com.oe.student.service.TeacherService;
import com.oe.student.vo.TeacherVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwj
 * @data 2019/4/15
 */
@Component
public class TeacherFacadeImpl implements TeacherFacade {

    @Autowired
    private TeacherService teacherService;

    @Override
    public List<TeacherVo> getTeacherByName(String teacherName) {
        List<Teacher> list = teacherService.getTeacherByName(teacherName);
        List<TeacherVo> result = new ArrayList<>();
        list.forEach(e -> {
            TeacherVo teacherVo = new TeacherVo();
            teacherVo.setSchoolId(e.getSchoolId().toString());
            teacherVo.setSchoolName(e.getSchoolName());
            teacherVo.setTeacherId(e.getTeacherId().toString());
            teacherVo.setTeacherName(e.getTeacherName());
            result.add(teacherVo);

        });
        return result;
    }

    @Override
    public TeacherVo selectTeacherByUserId(String userId) throws OeException {
        Teacher teacher = teacherService.selectTeacherByUserId(userId);
        if (teacher == null) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "暂未绑定信息！");
        }
        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setSchoolId(teacher.getSchoolId().toString());
        teacherVo.setSchoolName(teacher.getSchoolName());
        teacherVo.setTeacherId(teacher.getTeacherId().toString());
        teacherVo.setTeacherName(teacher.getTeacherName());
        return teacherVo;
    }

    @Override
    public void updateTeacher(TeacherVo teacherVo) throws OeException {

        if (StringUtils.isAnyBlank(teacherVo.getUserId())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "用户id不能为空");
        }
        Teacher teacher = new Teacher();
        teacher.setUserId(teacherVo.getUserId());
        teacher.setSchoolId(Long.parseLong(teacherVo.getSchoolId()));
        teacher.setSchoolName(teacherVo.getSchoolName());
        teacher.setTeacherId(Long.parseLong(teacherVo.getTeacherId()));
        teacher.setTeacherName(teacherVo.getTeacherName());
        teacherService.updateTeacher(teacher);
    }

    @Override
    public void addTeacher(TeacherVo teacherVo) throws OeException {
        if (StringUtils.isAnyBlank(teacherVo.getSchoolId(),
                teacherVo.getTeacherId(),
                teacherVo.getSchoolName(),
                teacherVo.getTeacherName())) {
            throw new OeException(ResponseStatus.FAILED.getCode(), "请完整填写信息");
        }
        Teacher t = teacherService.selectTeacherByUserId(teacherVo.getUserId());
        if (t != null) {
            updateTeacher(teacherVo);
            return;
        }
        Teacher teacher = new Teacher();
        teacher.setUserId(teacherVo.getUserId());
        teacher.setSchoolId(Long.parseLong(teacherVo.getSchoolId()));
        teacher.setSchoolName(teacherVo.getSchoolName());
        teacher.setTeacherId(Long.parseLong(teacherVo.getTeacherId()));
        teacher.setTeacherName(teacherVo.getTeacherName());
        teacherService.addTeacher(teacher);
    }
}
