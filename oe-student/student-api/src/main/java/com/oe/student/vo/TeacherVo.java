package com.oe.student.vo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class TeacherVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String teacherId;

    private String userId;

    private String schoolId;

    private Integer current = 1;

    private Integer size = 12;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
