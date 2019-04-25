package com.oe.student.vo;

/**
 * @author wangwj
 * @data 2019/4/11
 */
public class CourseInfoVo implements Vo {

    private String courseName;

    private String courseImage;

    private String courseInfo;

    private Integer collect;

    private Integer join;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

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
}
