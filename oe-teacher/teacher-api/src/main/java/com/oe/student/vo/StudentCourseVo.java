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

public class StudentCourseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseId;

    private String studentId;
    private String courseName;


    private Integer current = 1;

    private Integer size = 12;
    private Integer collect;

    private Integer join ;

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getJoin() {
        return join;
    }

    public void setJoin(Integer join) {
        this.join = join;
    }

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
