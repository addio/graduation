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
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long schoolId;

    private String schoolName;

    private String schoolInfo;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(String schoolInfo) {
        this.schoolInfo = schoolInfo;
    }
}
