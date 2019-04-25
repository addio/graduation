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
public class TeacherCourseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseId;

    private String teacherId;

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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
