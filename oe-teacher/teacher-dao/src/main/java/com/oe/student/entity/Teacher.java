package com.oe.student.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long teacherId;

    private Long userId;

    private Long schoolId;

    public Long getSchoolId() {
        return schoolId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
