package com.oe.course.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long studentId;

    private Long userId;

    private Long schoolId;

    public Long getSchoolId() {
        return schoolId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
